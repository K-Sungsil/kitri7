package com.kitri.myfirstservlet.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.time.LocalTime.now;

//WebServlet 이란 어노테이션을 등록
@WebServlet(name = "CurrentTimeServlet", value = "/current-time-servlet")
public class CurrentTimeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = ""+now();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}