/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf2demo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author apary
 */
@Named(value = "timeBean")
@RequestScoped
public class TimeBean {

    /**
     * Creates a new instance of TimeBean
     */
    public TimeBean() {
    }
    
    public String getTime() {
        return new java.util.Date().toString();
    }
    
}
