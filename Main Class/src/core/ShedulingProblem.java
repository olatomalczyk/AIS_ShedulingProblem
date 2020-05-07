/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import org.jacop.core.*;
import org.jacop.constraints.*;
import org.jacop.search.*;
import java.util.ArrayList;
import java.lang.Object;
import org.jacop.constraints.Diff;
import org.jacop.constraints.Diff2;
/**
 *
 * @author KUBA i OLA
 */
/**

 * It solves museum problem
 *
 */
public class ShedulingProblem extends CLP_Class {

	@Override
	public void model() {

	// Creating constraint store
		store = new Store();
		vars = new ArrayList<IntVar>();
		               
        // four groups x trhree exhibitions = 12 
        IntVar[] exhibitions = new IntVar[11];
         //each day is 3 periods
		for (int i = 0; i < 11; i++) {
			exhibitions[i] = new IntVar(store, "exhibitions[" + i + "]", 1, 3);
			vars.add(exhibitions[i]);
		}
        
        exhibitions[0]= new IntVar(store, "Telecommunication in automobiles",0,240);
        exhibitions[1]= new IntVar(store, "Telecommunication in cameras",45,240);
        exhibitions[2]= new IntVar(store, "Telecommunication in radio communication",70,150);
        
        
        exhibitions[3]= new IntVar(store, "Electronics in radio communication",30,150);
        exhibitions[4]= new IntVar(store, "Electronics in automobiles",90,140);
        exhibitions[5]= new IntVar(store, "Electronics in cameras",120,140);
        
        exhibitions[6]= new IntVar(store, "Architecture in cameras",75,255);  
        exhibitions[7]= new IntVar(store, "Architecture in radio communication",105,180);
        exhibitions[8]= new IntVar(store, "Architecture in automobiles",135,255);
       
        exhibitions[9]= new IntVar(store, "Mechanical engineering in automobiles",105,270);
        exhibitions[10]= new IntVar(store, "Mechanical engineering in radio communication",165,190);
        exhibitions[11]= new IntVar(store, "Mechanical engineering in cameras",185,270);
        
       //durations
       int[] durations = new int[11];
       
       durations[0]=45;
       durations[1]=25;
       durations[2]=60;
       durations[3]=60;
       durations[4]=30;
       durations[5]=40;
       durations[6]=30;
       durations[7]=30;
       durations[8]=45;
       durations[9]=60;
       durations[10]=20;
       durations[11]=30;
       
       // time of start + duration <= time of startf of next exhibition
       
		store.impose(new XplusClteqZ(exhibitions[0], durations[0],exhibitions[1]));
                store.impose(new XplusClteqZ(exhibitions[1], durations[1],exhibitions[2]));
        
                store.impose(new XplusClteqZ(exhibitions[3], durations[3],exhibitions[4]));
                store.impose(new XplusClteqZ(exhibitions[4], durations[4],exhibitions[5]));
              
               	store.impose(new XplusClteqZ(exhibitions[6], durations[6],exhibitions[7]));
                store.impose(new XplusClteqZ(exhibitions[7], durations[7],exhibitions[8]));
		
                store.impose(new XplusClteqZ(exhibitions[9], durations[9],exhibitions[10]));
                store.impose(new XplusClteqZ(exhibitions[10], durations[10],exhibitions[11]));
                
// Y
		IntVar one = new IntVar(store, "one", 1, 1);
                //tak jak w perfect square te grupki pogrupowac i z nich zrobic diffy
//automobiles
		Diff2([exhibitions[0], one, durations[0], one],[exhibitions[4], one, durations[4], one],[exhibitions[8], one, durations[8], one],[exhibitions[9], one, durations[9], one]);
//cameras
                Diff2([exhibitions[1], one, durations[1], one],[exhibitions[5], one, durations[5], one],[exhibitions[6], one, durations[6], one],[exhibitions[11], one, durations[11], one]);
//radio communucations
                Diff2([exhibitions[2], one, durations[2], one],[exhibitions[3], one, durations[3], one],[exhibitions[7], one, durations[7], one],[exhibitions[10], one, durations[10], one]);


	}
			
	
	
	/**
	 * It executes the program which solves this simple problem.
	 * @param args no arguments are read.
	 */
        
         public String search() {
             
             ShedulingProblem example = new ShedulingProblem();
		
		example.model();

		if (example.searchAllAtOnce())
			System.out.println("Solution(s) found");
                
         };
         
}
	
	}			

}


