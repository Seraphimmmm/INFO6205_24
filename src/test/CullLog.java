package test;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import main.GA;
import main.Trait;

public class CullLog {
	 private static Logger log = Logger.getLogger(CullLog.class);
	   public static void main(String[] args) {
		   PropertyConfigurator.configure("log4j.properties");
		   GA ga = new GA();
		   ga.initial();
		   ga.generate();
		   ArrayList<Trait> tempList = ga.getTraitList();
	       for(Trait t : tempList) {
	    	  System.out.println();
	          log.info("key: "+t.getGenetype()+" value: "+t.getValue());  
	          System.out.println();
	       }
	       ga.cull();
	       log.info("After culling");
	       for(Trait t : tempList) {
	     	  System.out.println();
	           log.info("key: "+t.getGenetype()+" value: "+t.getValue());  
	           System.out.println();
	        }
	       log.info("remaining number: "+tempList.size());
	   }
	   
}
