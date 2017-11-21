package controller;

import Util.SecurityUtil;
import model.Author;
import service.BusinessService;
import service.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制主体
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        BusinessService s = new BusinessServiceImpl();
        String username  =  request.getParameter("username");
        if (username!=null){
            PrintWriter pw = null;
            try {
                pw = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<Author> authors =  s.listAuthors();
            List names = new ArrayList();
            for (Author authors1:authors){
                names.add(authors1.getUsername());
            }
            if (names.contains(username)){
                System.out.println(username);
            }else {
                pw.write("<font color='red'>用户名不存在</font>");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
