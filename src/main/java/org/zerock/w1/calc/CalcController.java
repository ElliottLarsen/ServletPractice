package org.zerock.w1.calc;

import org.zerock.w1.calc.dto.CalcDTO;
import org.zerock.w1.calc.service.CalcService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(name = "calcController", urlPatterns = "/calc/calculate")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FROM CALCCONTROLLER");
        CalcDTO userInput = new CalcDTO();
        userInput.setNum1(Integer.parseInt(req.getParameter("num1")));
        userInput.setNum2(Integer.parseInt(req.getParameter("num2")));

        CalcDTO calculated = CalcService.INSTANCE.calculate(userInput);

        req.setAttribute("dto", calculated);

        req.getRequestDispatcher("/WEB-INF/calc/result.jsp").forward(req, resp);
    }
}
