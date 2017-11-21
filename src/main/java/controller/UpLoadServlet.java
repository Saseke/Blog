package controller;

import model.Author;
import model.Image;
import service.BusinessService;
import service.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 控制主体
 */
@WebServlet(name = "UpLoadServlet")
public class UpLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        BusinessService bs = new BusinessServiceImpl();
        Author author = (Author) req.getSession().getAttribute("currentAuthor");
        PrintWriter out = resp.getWriter();

            InputStream fileSource = req.getInputStream();
            String tempFileName = "C:/tempFile";
            //tempFile指向临时文件
            File tempFile = new File(tempFileName);
            //outputStram文件输出流指向这个临时文件
            FileOutputStream outputStream = new FileOutputStream(tempFile);
            byte b[] = new byte[1024];
            int n;
            while ((n = fileSource.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
            //关闭输出流、输入流
            outputStream.close();
            fileSource.close();

            //获取上传文件的名称
            RandomAccessFile randomFile = new RandomAccessFile(tempFile, "r");
            randomFile.readLine();
            String str = randomFile.readLine();
            int beginIndex = str.lastIndexOf("=") + 2;
            int endIndex = str.lastIndexOf("\"");
            String filename = str.substring(beginIndex, endIndex);
            String[] s = filename.split("\\.");
            System.out.println(s[0]);
            System.out.println(s[1]);
            filename = author.getId() + "." + s[1];
        /*System.out.println("filename:" + filename);
        String[] s =  filename.split("\\.");
        System.out.println(s[0]);
        System.out.println(s[1]);
        filename = author.getId()+s[1];*/
            //重新定位文件指针到文件头
            randomFile.seek(0);
            long startPosition = 0;
            int i = 1;
            //获取文件内容 开始位置
            while ((n = randomFile.readByte()) != -1 && i <= 4) {
                if (n == '\n') {
                    startPosition = randomFile.getFilePointer();
                    i++;
                }
            }
            startPosition = randomFile.getFilePointer() - 1;
            //获取文件内容 结束位置
            randomFile.seek(randomFile.length());
            long endPosition = randomFile.getFilePointer();
            int j = 1;
            while (endPosition >= 0 && j <= 2) {
                endPosition--;
                randomFile.seek(endPosition);
                if (randomFile.readByte() == '\n') {
                    j++;
                }
            }
            endPosition = endPosition - 1;

            //设置保存上传文件的路径
            String realPath = "D:\\Images";
            System.out.println(realPath);
            File fileupload = new File(realPath);
            if (!fileupload.exists()) {
                fileupload.mkdir();
            }
            File saveFile = new File(realPath, filename);
            RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
            //从临时文件当中读取文件内容（根据起止位置获取）
            randomFile.seek(startPosition);
            while (startPosition < endPosition) {
                randomAccessFile.write(randomFile.readByte());
                startPosition = randomFile.getFilePointer();
            }
            //关闭输入输出流、删除临时文件
            randomAccessFile.close();
            randomFile.close();
//            tempFile.delete();
            bs.updateImage(author.getId());
            author.setImage(1);
            filename = author.getId() + filename;
            Image image = new Image(author.getId(), realPath, filename);
            req.setAttribute("image", image);

            out.write("<script>alert(\"上传成功,请点击返回主页返回\");window.history.back()</script>");
//            req.getRequestDispatcher("/01.jsp").forward(req, resp);
        /*}else {
            out.write("<script>alert(\"对不起，不能重复设置\");window.history.go(-2);</script>");
//            req.getRequestDispatcher("/opeate/listFile.do").forward(req,resp);
        }
*/



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
