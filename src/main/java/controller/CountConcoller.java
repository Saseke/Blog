package controller;

import Util.SecurityUtil;
import model.Author;
import model.Comment;
import model.File;
import model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BusinessService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 控制主体
 */
@Controller
@RequestMapping("/opeate")
public class CountConcoller {
    private BusinessService s;
    private Logger logger = LoggerFactory.getLogger(CountConcoller.class);
    public BusinessService getS() {
        return s;
    }
//自动装配
    @Autowired
    public void setS(BusinessService s) {
        this.s = s;
    }
//      文章类
    //    通过关键字查出文章
    @RequestMapping(value = "/findFile")
    public String findFile(HttpServletRequest request) {
//        得到用户输入的关键字
        String content = request.getParameter("content");
//        先通过模糊查询标题查找文章
        List<File> files = s.findByTitle(content);
        if (files.size() != 0) {
            request.setAttribute("findfiles", files);
            return "find";
        } else {
//            如果查询标题没有，就模糊查询内容
            List<File> files1 = s.findFile(content);
            if (files1.size() != 0) {
                request.setAttribute("findfiles", files1);
                return "find";
            }
//如果什么都没查到就返回no thing
            else {
                return "error";
            }
        }

    }

    //    列出所有的文章
    @RequestMapping(value = "/listFile")
    public String showALl(HttpServletRequest request, HttpServletResponse response) {
        try {
//            设置编码
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
         Image image = (Image)request.getAttribute("image");
        Author author = (Author) request.getSession().getAttribute("currentAuthor");
//        int s1= Integer.parseInt(request.getParameter("id"));

//            Author author =  s.findAuthorWithFile();

//        实现分页
        int pageSize = 5; // 每页的条数
        String currentpage = request.getParameter("page");//当前页数
        if (currentpage == null || "".equals(currentpage.trim())) {
            currentpage = "1";//currentpage.equals(0)
        }
        int currentPage = Integer.parseInt(currentpage);
        System.out.println(currentPage);
        int totalRecord;
        List<File> file = s.listAll();
        totalRecord = file.size(); //总条数
        int counts = totalRecord / 5;
        int endPage = totalRecord % 5 == 0 ? counts : counts + 1;      //结束页码
        int startIndex = (currentPage - 1) * pageSize;//计算每页的开始索引
        List<File> files = new ArrayList<File>();
        for (int i = startIndex; i < startIndex + pageSize; i++) {
            if (i < file.size()) {
                files.add(file.get(i));
            }
        }
//        是否有头像
//        int count = 0;
        request.setAttribute("files", files);
        request.setAttribute("count", endPage);
        request.setAttribute("author", author);
        request.setAttribute("image",image);
//        request.setAttribute("count",count);
//        request.setAttribute("id",id);
        return "listFile";
    }

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request){
         Author author = (Author) request.getSession().getAttribute("currentAuthor");
         int id = author.getId();
//         查出当前用户所有的文章
         List<File> files = s.list(id);
//         分页
        int pageSize = 5; // 每页的条数
        String currentpage = request.getParameter("page");//当前页数
        if (currentpage == null || "".equals(currentpage.trim())) {
            currentpage = "1";//currentpage.equals(0)
        }
        int currentPage = Integer.parseInt(currentpage);
        int totalRecord;
        List<File> fileList = s.list(author.getId());
        totalRecord = fileList.size(); //总条数
        int counts = totalRecord / 5;
        int endPage = totalRecord % 5 == 0 ? counts : counts + 1;      //结束页码
        int startIndex = (currentPage - 1) * pageSize;//计算每页的开始索引
        List<File> fileArrayList = new ArrayList<File>();
        for (int i = startIndex; i < startIndex + pageSize; i++) {
            if (i < fileList.size()) {
                fileArrayList.add(fileList.get(i));
            }
        }
        request.setAttribute("fileArrayList",fileArrayList);
        request.setAttribute("count", endPage);

//         将个人用户所有文章上传至jsp
         request.setAttribute("files",files);
        return "list";
    }
    //    添加文章
    @RequestMapping(value = "/addFile",method = RequestMethod.POST)
    public String addFile(HttpServletRequest request, HttpServletResponse response) {
        Author author = (Author) request.getSession().getAttribute("currentAuthor");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        String textTitle = request.getParameter("title");
        String textContent = request.getParameter("content");
        File file = new File(textTitle, textContent, new Date(), 0,author.getId());
        s.addFile(file);
        return "redirect:/opeate/listFile.html";
    }

    @RequestMapping(value = "/seeAll")
    public String seeAll(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        File file = s.findByid(id);
        List<Comment> comments =  s.selectComment(id);
        request.setAttribute("comments", comments);
        request.setAttribute("file", file);
//        int authorId = file.getAuthor_id();
        return "seeAll";
    }
//    更新文章——1
    @RequestMapping(value = "updateFile")
    public String updateFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
//        Author author = (Author) request.getSession().getAttribute("currentAuthor");
        int id = Integer.parseInt(request.getParameter("id"));
//        根据文章id查询文章
            File file = s.findByid(id);
            request.setAttribute("file",file);
            return "update";
    }
    @RequestMapping(value = "updateFile1",method = RequestMethod.POST)
    public String update1(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=utf-8");
        /*String i = request.getParameter("id");
        int id = Integer.parseInt(i);*/
        int id = Integer.parseInt(request.getParameter("id"));
        File file = s.findByid(id);
        String title =  request.getParameter("title");
        String content = request.getParameter("content");
        file.setTitle(title);
        file.setContent(content);
        s.realUpdate(file);
        return "redirect:/opeate/list.html";
    }


    //    删除文章
  /*  @RequestMapping(value = "/seeAll")
    public String deleteFile(HttpServletRequest request){

    }*/
//    转发
    @RequestMapping(value = "/rd")
    public String rdirect() {
        return "addfile";
    }

    //  更新访问量
    @RequestMapping(value = "/rt")

    public String rty(HttpServletRequest request) {
        Author author = (Author) request.getSession().getAttribute("currentAuthor");
        int id = Integer.parseInt(request.getParameter("id"));
        File file1 = s.findByid(id);
        int author_id = file1.getAuthor_id();
        if (author_id!=author.getId()) {
            s.update(file1);
        }
        return "redirect:/opeate/listFile.html";
    }

    //模糊查询文章
    @RequestMapping(value = "/direfile")
    public String direfile(HttpServletRequest request) {
        String string = request.getParameter("name");
        logger.info("操作："+string);
        logger.info("time"+new Date());
        if (string.equals("linux")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }
        } else if (string.equals("mybatis")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }
        } else if (string.equals("Spring")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }
        } else if (string.equals("java")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }
        } else if (string.equals("databases")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }
        } else if (string.equals("diary")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }
        } else if (string.equals("others")) {
            List<File> files = s.findByTitle(string);
            if (files.size() == 0) {
                List<File> files1 = s.findFile(string);
                request.setAttribute("files", files1);
            } else {
                request.setAttribute("files", files);
            }

        }
        return "direfile";


    }

    //登录.
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =  response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remenber = request.getParameter("auto");
//        password = SecurityUtil.md5(password);
        Author author = s.login(username);
        logger.info("author  :"+author.getUsername());
        logger.info("time  :"+new Date());
        if (SecurityUtil.md5(password).equals(author.getPassword())) {
//            out.write("null");
                if("1".equals(remenber)){
                    Cookie cookie = new Cookie("login", SecurityUtil.base64encode(username)+"_"+password);
                    cookie.setPath(request.getContextPath());
                    cookie.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(cookie);

                }
                    HttpSession session = request.getSession();
                    session.setAttribute("currentAuthor", author);
                return "redirect:/opeate/listFile.html?id=" + author.getId();
            } else {
                response.getWriter().write("错误的用户名或密码");
                return "login";
            }

        }


    //    通道 到达login.jsp
    @RequestMapping(value = "/seelogin")
    public String seelogin() {
        return "login";
    }


    // /    通达注册界面
    @RequestMapping(value = "/seeRegist")
    public String seeRegist() {
        return "register";
    }

    //    注册
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("name_r");

        String description = request.getParameter("des");
        String password = request.getParameter("pwd");
//      对密码进行加密


        String repassword = request.getParameter("confirmPwd");
        if (password.equals(repassword)) {
            Author author = new Author(username, SecurityUtil.md5(password), description, new Date());
            s.addAuthor(author);
            logger.info("author  :"+author.getUsername());
            logger.info("author  :"+author.getPassword());
            logger.info("date  :",new Date());
            return "login";
        } else {
            return "register";


        }


    }

//    个人的主页
//    打开显示所有文章
    @RequestMapping(value = "backhome")
    public String backhome(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        File file = s.findByid(id);
        List<Comment> comments = s.selectComment(id);
        request.setAttribute("comments",comments);
        request.setAttribute("file", file);
//        int authorId = file.getAuthor_id();
        return "back";

    }
    @RequestMapping(value = "back")
    public String back(HttpServletRequest request){
        return "redirect:/opeate/list.html";
    }
//跳转到评论界面
    @RequestMapping(value = "toaddComment")
    public String toaddComment(HttpServletRequest request){
        int file_id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("file_id",file_id);
        return "addComment";
    }

//    评论
    @RequestMapping(value = "addComment")
    public String addComment(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Author author = (Author) request.getSession().getAttribute("currentAuthor");
        String id = request.getParameter("id");
//得到文章的id
        int file_id = Integer.parseInt(id);
//        得到文章的内容
        String comment = request.getParameter("comment");
        if (comment!=null) {
            Comment comment1 = new Comment();
            comment1.setFile_id(file_id);
            comment1.setAuthor_id(author.getId());
            comment1.setMatter(comment);
            comment1.setDate(new Date());
            s.addComment(comment1);
            return "redirect:/opeate/listFile.html";
        }else {
            out.write("<script>\n" +
                    "        alert(\"发送失败，您所发内容为空\");\n" +
                    "    </script>");
            return "listFile";

        }
    }

}



