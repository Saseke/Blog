package controller;

import Util.SecurityUtil;
import model.Author;
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
import java.util.Date;

/**
 * 控制主体
 */
@Controller
@RequestMapping("control")
public class loginControl {
    private BusinessService s;

    public BusinessService getS() {
        return s;
    }

    @Autowired
    public void setS(BusinessService s) {
        this.s = s;
    }

    //    用户登录
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remenber = request.getParameter("auto");
        Author author = s.login(username);
        if (SecurityUtil.md5(password).equals(author.getPassword())) {
//            out.write("null");
            if ("1".equals(remenber)) {

                Cookie cookie = new Cookie("login", SecurityUtil.base64encode(username) + "_" + password);
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cookie);

            }
            HttpSession session = request.getSession();
            session.setAttribute("currentAuthor", author);
            return "redirect:/opeate/listFile.html?id=" + author.getId();
        } else {
            return "login";
        }

    }

    //    用户注册
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public String regist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("name_r");

        String description = request.getParameter("des");
        String password = request.getParameter("pwd");
        password = SecurityUtil.md5(password);
        System.out.println(password);
//      对密码进行加密
        String repassword = request.getParameter("confirmPwd");
        repassword = SecurityUtil.md5(repassword);
        if (password.equals(repassword)) {
            Author author = new Author(username, password, description, new Date());
            s.addAuthor(author);

            return "login";
        } else {
            return "register";
        }


    }

    //    通往登录
    @RequestMapping(value = "/seelogin")
    public String seelogin() {
        return "login";
    }


    // /    通达注册界面
    @RequestMapping(value = "/seeRegist")
    public String seeRegist() {
        return "register";
    }

}
