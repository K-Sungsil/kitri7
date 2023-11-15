package com.kitri.myfirstservlet.pracitice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import static com.kitri.myfirstservlet.pracitice.JoinServlet.member;
import static com.kitri.myfirstservlet.pracitice.JoinServlet.sc;


@WebServlet(name = "logInOutServlet", value = "/practice/loginOut")
public class LogInOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // 세션 id 추출

        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding(("UTF-8"));
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String pw1 = req.getParameter("pw1");
        Member member1 = (Member) sc.getAttribute(id);
//        Member m = (Member) JoinServlet.sc.getAttribute(id);

//        HashMap hm = (HashMap) JoinServlet.sc.getAttribute(id);
//        Member m.getPw();
//        HashMap pm = (HashMap) JoinServlet.sc.getAttribute(pw1);
//        Member p = (Member) hm.get(pw1);

        if (session.getAttribute("id") == null) {
            if (member1 != null) { // 가져온 member값(member1) 안에 값이 있는지 비교하기(id가 있는지 먼저 비교하기)
                if (pw1.equals(member1.getPw())) { //pw 비교
                    out.println("로그인 성공 했습니다.");
                    session.setAttribute("id", id); // id값에 세션 저장
                } else {
                    out.println("비밀번호가 틀렸습니다.");
                    out.println("<hr><a href=loginOut.html>로그인 화면으로 돌아가기</a></hr>");
                }
            } else {
                out.println("해당 회원ID는 존재하지 않습니다.");
                out.println("<hr><a href=loginOut.html>로그인 화면으로 돌아가기</a></hr>");
            }
        } else {
            out.println("로그인 상태입니다.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding(("UTF-8"));
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        if (session != null && session.getAttribute("id") != null){
            session.invalidate();
            out.print("로그아웃 되었습니다.");
        } else {
            out.println("현재 로그인 상태가 아닙니다");
            out.println("<hr><a href=loginOut.html>로그인 화면으로 돌아가기</a></hr>");
        }
        out.close();
    }
}
