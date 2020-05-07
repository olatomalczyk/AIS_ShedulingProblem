/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pkgclass;
import gui.MyFrame;
import core.CombinatoryProblem;
import core.ShedulingProblem;

/**
 *
 * @author KUBA i OLA
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hejo");
        
        
        CombinatoryProblem cp= new CombinatoryProblem();
        cp.model();
        cp.search();
        
        
        ShedulingProblem sp= new ShedulingProblem();
        sp.model();
        sp.search();
        
        
        MyFrame myframe= new MyFrame();
        
        myframe.setVisible(true);
        
    }
    
}
