package controller;

import model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 控制主体
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    private static Logger logger = LoggerFactory.getLogger(ImageController.class);
    @RequestMapping("/Photo")
    public void download(HttpServletRequest request, HttpServletResponse response){
        Author author = (Author) request.getSession().getAttribute("currentAuthor");
        try {
            OutputStream out = response.getOutputStream();
            java.io.File file = null;
            if (author.getImage()==1) {
                 file = new java.io.File("/Images/" + author.getId() + ".jpg");
            }else {
                 file = new java.io.File("/Images/head.jpg");

            }

            if (!file.exists()){
                logger.debug(file.getAbsolutePath()+"图片不存在");
                return;
            }
            FileInputStream in = new FileInputStream(file);
            byte[] buf = new byte[1024 * 500];
            int i;
            while ((i=in.read(buf))!=-1){
                out.write(buf,0,i);
            }
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
