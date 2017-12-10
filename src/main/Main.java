package main;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class);
	
    public static void main(String[] args) {
    	PropertyConfigurator.configure("log4j.properties");
    	
    	ArrayList<Integer> set1 = new ArrayList<Integer>();
    	ArrayList<Integer> set2 = new ArrayList<Integer>();
    	ArrayList<Integer> set3 = new ArrayList<Integer>();
    	
    	GA ga = new GA();
    	ga.initial();
    	ga.generate();
    	
    	int flag =-1;
    	int generation = 0;
    	int[] data = ga.getData();
    	
    	logger.info("Generation: 0");
    	for(Trait trait : ga.getTraitList())
    		logger.info(trait.toString());
    	
    	for(int i = 1; i <= ga.getGeneration();i++) {
    		flag = ga.getTraitList().get(0).getValue();
    		generation = i;
    		if(flag==0) break;
    		ga.cull();
    		ga.breed();
    		ga.mutate();
    		
    		logger.info("Generation: "+ i);
        	for(Trait trait : ga.getTraitList())
        		logger.info(trait.toString());
    		
    	}
    	
    	for(int i = 0; i < ga.getTraitList().get(0).getGenetype().length;i++) {
    		if(ga.getTraitList().get(0).getGenetype(i) == 0) set1.add(data[i]);
    		else if (ga.getTraitList().get(0).getGenetype(i) == 1) set2.add(data[i]);
    		else set3.add(data[i]);
    		
    	}
    	
    	System.out.print("The raw data : {");
    	for(int i = 0; i < data.length;i++) {
    		if(i != data.length-1) System.out.print(data[i]+",");
    		else System.out.print(data[i]);
    	}
    	System.out.println("}");
    	
    	if(flag == 0)  System.out.print("The best solution : {");
    	else           System.out.print("The optimal solution this time: {");
    	
    	
    	for(int i = 0; i < set1.size(); i ++) {
    		if(i != set1.size()-1)
    		System.out.print(set1.get(i)+",");
    		else System.out.print(set1.get(i)+"}  {");
    	}
    	for(int i = 0; i < set2.size(); i ++) {
    		if(i != set2.size()-1)
    		System.out.print(set2.get(i)+",");
    		else System.out.print(set2.get(i)+"}  {");
    	}
    	for(int i = 0; i < set3.size(); i ++) {
    		if(i != set3.size()-1)
    		System.out.print(set3.get(i)+",");
    		else System.out.print(set3.get(i)+"}      "+"trait: "
    		+ga.getTraitList().get(0).getValue()+ "      generation: " +generation);
    	}
    }
}
