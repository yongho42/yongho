package lesson01.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yongho on 14. 12. 5.
 */
@WebServlet("/calc")
@SuppressWarnings("serial")
public class CalculatorServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String operator = req.getParameter("op");
        int v1 = Integer.parseInt(req.getParameter("v1"));
        int v2 = Integer.parseInt(req.getParameter("v2"));
        int result = 0;

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        switch(operator)
        {
            case "+" : result = v1 + v2;    break;
            case "-" : result = v1 - v2;    break;
            case "*" : result = v1 * v2;    break;
            case "/":
            {
                if(v2 == 0)
                {
                    out.println("0 으로 나눌 수 없습니다.");
                    return;
                }
                result = v1/v2;
                break;
            }
        }

        out.println(v1+" "+operator+" "+v2+" = "+result);
    }
}
