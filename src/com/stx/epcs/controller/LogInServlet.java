package com.stx.epcs.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        PrintWriter out = resp.getWriter();
        if (("admin").equals(username) && ("123456").equals(password)) {
//            out.write("ok");
            out.write("用户名是"+username+"密码是"+password);
//            RequestDispatcher rd = req.getRequestDispatcher("index.html");
//            rd.forward(req,resp);
        }else{
            out.write("登录失败 ~ ~ ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req,resp);
    }
}
