package test;
import org.apache.log4j.*;

import main.GA;
public class ChooseLog {
	   private static Logger log = Logger.getLogger(ChooseLog.class);
	   public static void main(String[] args) {
		   PropertyConfigurator.configure("log4j.properties");
		   GA ga = new GA();
		   ga.initial();
		   ga.generate();
		   ga.choose(50, 0.8);
		   int[] tempMark = ga.getMarkCross();
	       for(int i = 0; i < tempMark.length; i++) {
	    	  System.out.println();
	          log.info("Mark"+i+": "+tempMark[i]);  
	          System.out.println();
	       }
	   }
}
