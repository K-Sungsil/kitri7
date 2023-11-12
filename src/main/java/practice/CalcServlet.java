package practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", value = "/practice/Calc-servlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int val1 = Integer.parseInt(req.getParameter("val1"));
        String s = req.getParameter("op");
        int val2 = Integer.parseInt(req.getParameter("val2"));

        switch(s) {
            case "+":
                out.println("<p> val1" + "+" + "val2" + "=" + (val1+val2) + "</p>");
                break;
            case "-":
                out.println("<p> val1" + "-" + "val2" + "=" + (val1-val2) + "</p>");
                break;
            case "*":
                out.println("<p> val1" + "*" + "val2" + "=" + (val1*val2) + "</p>");
                break;
            case "/":
                if(val2 !=0) {
                    out.println("<p> val1" + "/" + "val2" + "=" + (val1/val2) + "</p>");
                }
                else {
                    out.println("<p> 0으로 나눌 수 없습니다.</p>");
                }
                break;
            default:
                out.println("<p> 사직연산 외에 연산자는 사용할 수 없습니다.</p>");
        }
    }
}
