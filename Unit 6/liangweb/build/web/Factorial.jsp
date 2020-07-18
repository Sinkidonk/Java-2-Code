<%-- 
    Document   : Factorial
    Created on : Mar 23, 2018, 1:27:09 PM
    Author     : apary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorial</title>
    </head>
    <body>
        <% for (int i = 0; i <= 10; i++) { %>
        Factorial of <%= i %> is
        <%= computeFactorial(i) %> <br />
        <% } %>
        
        <%! private long computeFactorial(int n) {
            if (n == 0)
                return 1;
            else
                return n * computeFactorial(n-1);
            }
            %>
            
    </body>
</html>
