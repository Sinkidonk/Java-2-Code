/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apary
 */
public class FactorialBean {
    private int number;
    
    /** Return number property */
    public int getNumber() {
        return number;
    }
    
    /* set number property */
    public void setNumber(int newValue) {
        number = newValue;
    }
    
    /* Obtain factorial */
    public long getFactorial() {
        long factorial = 1;
        for (int i = 1; i<= number; i++)
            factorial *= i;
        return factorial;
    }
}
