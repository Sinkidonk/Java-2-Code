<%-- 
    Document   : Factorials
    Created on : Mar 25, 2018, 10:32:52 PM
    Author     : apary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border='1'>
            <tr>
                <td>Number</td>
                <td>Factorial</td>
            </tr>
            <% for (int i = 0; i <= 10; i++) { %>
            <tr>
                <td><%= i %></td>
                <td> <%= computeFactorial(i) %></td>
            </tr>
            <% } %>
            
            
        </table>
            
            <%! private long computeFactorial(int n) {
            if (n == 0)
                return 1;
            else
                return n * computeFactorial(n-1);
            } 
            %>
            
    </body>
</html>
