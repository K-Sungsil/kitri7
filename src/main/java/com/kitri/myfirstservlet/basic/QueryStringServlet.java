package com.kitri.myfirstservlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "queryStringServlet", value = "/query-string-servlet")
public class QueryStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 메서드 요청을 처리
        // 쿼리 스트링을 추출 해야함 : req.getParameter();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<h3>GET요청</h3>" );
        out.println(req.getParameter("name") + "<br>");
        out.println(req.getParameter("city") + "<br>");


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8"); // <- 한글 깨짐 방지

        PrintWriter out = resp.getWriter();

        out.println("<h3>POST요청</h3>");
        out.println(req.getParameter("name2") + "<br>");
        out.println(req.getParameter("city2") + "<br>");
    }
}
