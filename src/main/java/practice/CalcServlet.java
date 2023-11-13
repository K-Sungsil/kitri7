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

        switch(req.getParameter("op")) {
            case "plus":
                out.println(val1 + "+" + val2 + "결과 =>");
                out.println(val1 + val2);
                break;
            case "minus":
                out.println(val1 + "-" + val2 + "결과 =>");
                out.println(val1 - val2);
                break;
            case "mul":
                out.println(val1 + "*" + val2 + "결과 =>");
                out.println(val1 * val2);
                break;
            case "div":
                out.println(val1 + "/" + val2 + "결과 =>");
                out.println(val1 / val2);
            case "mov":
                out.println(val1 + "%" + val2 + "결과 =>");
                out.println(val1 % val2);
                break;
            default:
                out.println("<p> 사직연산 외에 연산자는 사용할 수 없습니다.</p>");
                break;
        }
    }
}
