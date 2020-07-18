/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apary
 */
public class Factorial {
    
    private int factorialMax = 10;
    
    public Factorial() {
            for (int i =0;i < factorialMax; i++) {
                calcFactorial(i);
            }
    
    }
    
        private String calcFactorial(int i) {
        long factorials = 1;
        
        for(int counter = 1; counter <= i; counter++) {
            factorials *= counter;
        }
        
        return Long.toString(factorials);
        }
}