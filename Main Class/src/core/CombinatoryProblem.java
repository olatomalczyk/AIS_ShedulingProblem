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

/**
 *
 * @author KUBA I OLA 
 * 
 *  It models and solves Gamers logic puzzle.
 * 
 * There are four gentlemen: Adam, Bill, Charles and Dean.
They all like games and each gentleman is a master in a different one. Somebody is great at playing
bridge, another person is a chess master, some third one is unbeatable in checkers, and the last one
always wins in domino.
They also play sports. One rides a bicycle, another plays tennis, yet another swims, and the last one
goes skiing.
Furthermore, we know that:
1. Adam plays chess.
2. Bicycle rider plays checkers really well.
3. Dean does not play bridge.
4. Charles is not the swimmer.
5. Adam does not ski.
6. Bill does not know how to play checkers nor tennis.
7. Dean cannot ride a bike.
8. Charles does not play domino.
9. Bridge player cannot ski.
Which game and which sport are Dean's favourite ones?
* 
* 
 */
public class CombinatoryProblem extends CLP_Class {
    public CombinatoryProblem()
    {
        result_info = new String();
    }
    
    @Override
	public void model() {

		store = new Store();
		vars = new ArrayList<IntVar>();
		
		System.out.println("Program to solve Gamers problem ");

		String[] gameNames = { "chess", "checkers", "domino", "bridge" };
		int ichess = 0, icheckers = 1, idomino = 2, ibridge= 3;

		String[] sportNames = { "swim", "bike", "ski", "tennis"};
		int iswim = 0, ibike = 1, iski = 2, itennis = 3 ;
		
		String[] nameNames = { "Adam", "Bill", "Charles", "Dean" };
		int iAdam = 0, iBill = 1, iCharles = 2, iDean = 3 ;

		IntVar game[] = new IntVar[4];
		IntVar sport[] = new IntVar[4];
		IntVar name[] = new IntVar[4];

		for (int i = 0; i < 4; i++) {
			game[i] = new IntVar(store, gameNames[i], 0, 3);
			sport[i] = new IntVar(store, sportNames[i], 0, 3);
			name[i] = new IntVar(store, nameNames[i], 0, 3);
			
			vars.add(game[i]); vars.add(sport[i]); vars.add(name[i]);
	
		}

		store.impose(new Alldifferent(game));
		store.impose(new Alldifferent(sport));
		store.impose(new Alldifferent(name));


		// S1 to S9
		store.impose(new XeqY(name[iAdam], game[ichess])); //s1
		store.impose(new XeqY(sport[ibike], game[icheckers])); //s2
		store.impose(new XneqY(name[iDean], game[ibridge])); //s3 
		store.impose(new XneqY(name[iCharles], sport[iswim])); //s4
		store.impose(new XneqY(name[iAdam], sport[iski])); //s5
		store.impose(new XneqY(name[iBill], game[icheckers])); //s6
                store.impose(new XneqY(name[iBill], sport[itennis])); //s6
                store.impose(new XneqY(name[iDean], sport[ibike])); //s7
		store.impose(new XneqY(name[iCharles], game[idomino])); //s8
                store.impose(new XneqY(game[ibridge], sport[iski])); //s9
		

	}
	
	
	/**
	 * It executes the program to solve this simple logic puzzle.
	 * 
	 * @param args no argument is used.
	*/
 
        
        //IntVar[] vars;
        
   /**
     * It specifies simple search method based variable order which
     * takes into account the number of constraints attached to a variable
     * and lexigraphical ordering of values.
     *
     * @return true if there is a solution, false otherwise.
     */

         
    @Override
     public String search() {
        long T1, T2;
	T1 = System.nanoTime();

        search = new DepthFirstSearch<IntVar>();

        SelectChoicePoint<IntVar> select = new SimpleSelect<>(vars.toArray(new IntVar[1]), new MostConstrainedStatic<>(), new IndomainMin<>());

        result = search.labeling(store, select);
        T2 = System.nanoTime();
        
        result_info1 = "\nNodes:"+search.getNodes()+"      Decisions:"+search.getDecisions()+"      WrongDecisions:"+search.getWrongDecisions()+"      Backtracks:"+search.getBacktracks()+ "      Max Depth:"+ search.getMaximumDepth();
        result_info1 += "      Time in nanoseconds: "+(T2-T1);
        
        result_info +=("\nDean's favourite game:  "+vars.get(6)+", sport:  "+vars.get(7)+"\n");
   
        firstStr=select.toString();
        secondStr=result_info.toString();
        thirdStr=result_info1.toString();
        
		if(!result)
                    return("No solution");
                else    
                    return "";
            
     }

    }	
	
    



