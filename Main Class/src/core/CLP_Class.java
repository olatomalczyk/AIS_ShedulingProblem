/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import org.jacop.core.*;
import org.jacop.search.*;
import java.util.ArrayList;

/**
 *
 * @author KUBA i OLA
 */
public class CLP_Class {
    
    
    /**
     * class nedeed to convert intVar to String
     **/
    public static String firstStr;
    public static String secondStr;
    public static String thirdStr;
    public boolean result;
    public String result_info;
    public String result_info1;

    /**
     * protected classes
     */
    protected Store store=new Store();
    protected DepthFirstSearch search=new DepthFirstSearch();
    protected IntVar[] array;
    
    protected ArrayList<IntVar> vars;
    protected ArrayList<IntVar> intvar;
   
    
    /**
     * Body of empty method - method()
     */
    public void method()
    {
        
    };
    
     /**
     * Body of search() method
     * This method searches for a solution of problem
     * @return string information about the result
     */
    
    public String search()
    {
    return "b";
    };
    
     /**
     * Body of model () method
     * @return string information about the result
     */
    
     public void model()
    {
        
    };

     
     
}
    
