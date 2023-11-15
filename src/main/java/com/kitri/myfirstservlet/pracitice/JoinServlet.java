package com.kitri.myfirstservlet.pracitice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "joinServlet", value = "/practice/join")
public class JoinServlet extends HttpServlet {
    static HashMap<String, Member> member = new HashMap<>();
    static ServletContext sc = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
//        sc.getAttribute(id, new Member(id, pw));
//        member m = new Member();
//        m.getId(id);
//        m.getPw(pw);
        //sc.getAttribute(id);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding(("UTF-8"));
        PrintWriter out  = resp.getWriter();

        String id = req.getParameter("id");
        String pw1 = req.getParameter("pw1");
        String pw2 = req.getParameter("pw2");

//        member.get(id);
        if(sc.getAttribute(id) == null) {
            if(pw1.equals(pw2)) {
                sc.setAttribute(id, new Member(id, pw1));
//                member.put(id, new Member(id, pw1));
                out.println("회원가입을 완료하였습니다.");
                out.println("<hr><a href=loginOut.html>로그인 화면으로 돌아가기</a></hr>");
            } else {
                out.println("비밀번호가 다릅니다.");
                out.println("<hr><a href=loginOut.html>로그인 화면으로 돌아가기</a></hr>");
            }
        } else {
            out.println("이미 존재하는 회원입니다.");
            out.println("<hr><a href=loginOut.html>로그인 화면으로 돌아가기</a></hr>");
        }
    }
}
