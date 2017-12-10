package main;
/* GA class provides all the method to generate the solution.
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GA {
   int[] data = {1,62,92,4,15,6,7,8,9,10,13,16,3,6,9,12,15,21}; //raw data
   final int N = data.length;
   private double remainRate = (double)5/9;                  //after culling,the remaining rate
   private double mutateRate = 0.1;                          
   private double crossoverRate = 0.8;
   


   private int number = 90;                                 //the number of solutions in each generation
   private int generation = 100;                            //generation number
   private int sum = 0;                                     //accumulation of each data
   private int remainNumber = (int) (number*remainRate);
   
 
   public void initial() {
	   for(int i = 0; i < data.length;i++) sum += data[i];
   }
   
   
   public int fitness(int[] genetype) {                    //generate fitness value
	   int[] boxes = new int[3];
	   int fitValue = 0;
	   for(int i = 0; i < genetype.length; i++)
		 boxes[genetype[i]] += data[i];
	   for(int i = 0; i < 3;i++)
		 fitValue += Math.abs(boxes[i]-sum/3);
	   return fitValue;
   }
   
   public void generate() {                               //to create the first generation
	   for(int i = 0; i < number;i++) {
		   int[] genetype = new int[N];
		   for(int j = 0; j < data.length;j++) 
			   genetype[j] = (int)(Math.random()*3);
	       traitList.add(new Trait(genetype,fitness(genetype)));
	   }
	   
   }
   
   public void cull() {                                  //cull the last 40 rank in each generation
	   Collections.sort(traitList);
	  for(int i = remainNumber; i < number; i++)
		  traitList.remove(traitList.size()-1) ;
   }
   
   
   public void choose(int rNumber,double rate) {        //decide which solution to crossover
	   int count = 0;
	   int j = rNumber-1;
	   for(int i = 0; i < rNumber; i++)
		   markCross[i] = 0;
	   while(count < (int)(rNumber*rate)) {
		  
	   if(markCross[j] == 0 && Math.random()<rate) {markCross[j] = 1;
	   count++;
	   }
	   j--;
	   if(j<0) j = rNumber-1;
	   }
   }
   
   
   public void breed() {                                //generate 40 children by crossover 2 solution
	  choose(remainNumber,crossoverRate);
	  int count = 0;
	  int j = 0;
	  while(count < remainNumber*crossoverRate/2){
		   if(markCross[j]==1) {
		   int object = (int)(Math.random()*(remainNumber));
		   while(markCross[object] != 1 || object == j ) {
			   object++;
			   if(object == remainNumber) object = 0;
		   }
		   int[] genetype1 = Trait.crossover(traitList.get(j),traitList.get(object));
		   int[] genetype2 = Trait.crossover(traitList.get(object), traitList.get(j));
		   traitList.add(new Trait(genetype1,fitness(genetype1)));
		   traitList.add(new Trait(genetype2,fitness(genetype2)));
		   markCross[j]=2;
		   markCross[object] = 3;
		   count++;
		   }
		   j++;
	   }
	   
   }
   
   public void mutate() {                                //mutate
	   for(Trait trait : traitList) {
		   if(Math.random() <= mutateRate) {
			   int location = (int)(Math.random()*trait.getGenetype().length);
			   trait.mutate(location);
		   }
	   }
   }
   public int getRemainNumber() {
		return remainNumber;
	}


	   public int getGeneration() {
			return generation;
		}

	private ArrayList<Trait> traitList = new ArrayList<Trait>();
	   private int[] markCross = new int[remainNumber];
	   
	   
	   public int[] getMarkCross() {
		return markCross;
	}
	   
	   public ArrayList<Trait> getTraitList() {
		return traitList;
	}
	   public int[] getData() {
			return data;
		}

}
