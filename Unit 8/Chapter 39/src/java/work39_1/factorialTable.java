/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work39_1;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author apary
 */
@Named(value = "factorialTable")
@RequestScoped
public class factorialTable {

    /**
     * Creates a new instance of factorialTable
     */
    public factorialTable() {
    }
    
    public String getTable() {
        String result = "<h1>Display Factorials</h1>";
        result += "<table border=\"1\">"
                + "<tr><td>Number</td><td>Factorial</td></tr>";
        for (int i = 0; i <= 10; i++) {
            result += "<tr><td>" + i + "</td><td>" + computeFactorial(i)
                    + "</td></tr>";
        }
        result += "</table>";
        return result;
    }
    
    private long computeFactorial(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * computeFactorial(n - 1);
        }
    }
    
}
