package test;

import java.util.ArrayList;
import org.apache.log4j.*;
import main.GA;
import main.Trait;
public class BreedLog {
	   private static Logger log = Logger.getLogger(BreedLog.class);
	   public static void main(String[] args) {
		   PropertyConfigurator.configure("log4j.properties");
		   GA ga = new GA();
		   ga.initial();
		   int j = 0;
		   ga.generate();
		while(j  < 10) {
			int count = ga.getRemainNumber();
		   ga.cull();
		   ga.breed();
		   int[] tempMark = ga.getMarkCross();
		   System.out.println("Generation: "+ j);
		   ArrayList<Trait> tempList = ga.getTraitList();
	       for(int i = 0; i < 50; i++) {
	    	   if(tempMark[i] == 2) {
	    	  System.out.println();
	          log.info("Father :"+ tempList.get(i).toString());  
	          log.info("children: "+tempList.get(count).toString());
	          log.info("children2: "+tempList.get(++count).toString());
	          System.out.println();
	          count++;
	        }
	       }
	       j++;
	   }
	   }
}
