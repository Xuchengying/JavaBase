package com.stx.epcs.controller;

import com.stx.epcs.dao.VirusDao;
import com.stx.epcs.entity.Vrius;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2020/4/15 0015.
 */
@WebServlet("/AddVirusServlet")
  public class AddVirusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
     //
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String vname = req.getParameter("vname");
        String description = req.getParameter("description");
        PrintWriter out = resp.getWriter();
        VirusDao virusDao = new VirusDao();
        Vrius vrius = new Vrius();
        vrius.setName(vname);
        vrius.setDescrip(description);
        if(vname == "" || description == "") {
            out.write("<p>病毒名称和描述不能为空</p>");
            return;
        }
        int num = virusDao.addVrius(vrius);
        if(num == 1) {
            out.write("添加病毒成功！");
        }else {
            out.write("添加病毒失败！");
        }
    }
}
