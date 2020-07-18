/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author apary
 */

public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        int x = 55;
        int y = 4;
        int total = x+y*(x+y)*(y/x);
        int factorialMax = 10;
        // output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, Java Servlets</h1>");
        out.println("<p>" + total + "</p>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Number</th>");
        out.println("<th>Factorial</th>");
        out.println("</tr>");
        for(int i = 0; i < factorialMax; i++) {
            out.println("<tr>");
            out.println("<th>" + i + "</th>");
            out.println("<th>" + calcFactorial(i) + "</th>");
            out.println("</tr>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    private String calcFactorial(int i) {
        long factorials = 1;
        
        for(int counter = 1; counter <= i; counter++) {
            factorials *= counter;
        }
        
        return Long.toString(factorials);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}