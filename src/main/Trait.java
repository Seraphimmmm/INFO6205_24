package main;

/*Trait class provides a structure to store each gene expression and its fitness value
 * 
 */

public class Trait implements Comparable<Trait>{
		   private int[] genetype;
		   private int value;
	
		   public Trait() {};
		   public Trait(int[] genetype,int value) {
			   this.genetype = genetype;
			   this.value = value;
		   }
		   public int[] getGenetype() {
			   return genetype;
		   }
		   public int getValue() {
			   return value;
		   }
		   
		   public int getGenetype(int location) {
			   return genetype[location];
		   }
		   public void setGenetype(int location,int k) {
			   genetype[location] = k;
		   }
		   public String toString() {
			  String str = "";
			   for(int i = 0; i < genetype.length;i++)
				   str += ""+genetype[i];
			   
			return str;
		   }
		@Override
		public int compareTo(Trait b) {
			// TODO Auto-generated method stub
			return  value - b.getValue() ;
		}
		
		public  static int[] crossover(Trait t1, Trait t2) {
			// TODO Auto-generated method stub
			int[] offspring1 = new int[t1.genetype.length];
			for(int i = 0; i < offspring1.length;i+=2) {
				offspring1[i] = t1.getGenetype(i); 
			}
			for(int i = 1; i < offspring1.length;i+=2) {
				offspring1[i] = t2.getGenetype(i); 
			}
			return offspring1;
		}
		
		   
		 public void mutate(int location) {
					int x = 0;
				    if(Math.random()>0.5)
					 x = genetype[location] + 1;
				    else x=genetype[location] + 2;
					genetype[location] = x%3;
		 }
	   }


