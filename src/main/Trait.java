package main;



public class Trait implements Comparable<Trait>{
		   private int[] genetype;
		   private int value;
		   private int[] markGene ;
		   public Trait() {};
		   public Trait(int[] genetype,int value) {
			   
			   this.genetype = genetype;
			   this.value = value;
			   markGene = new int[genetype.length];
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
		
		 private void choose(int length) {
			   int count = 0;
			   int j = 0;
			   
			for(int i = 0; i < markGene.length; i++)
				   markGene[i] = 0;
			   while(count < (int)(length)) {
				  
			   if(markGene[j] == 0 && Math.random()<0.5) {markGene[j] = 1;
			   count++;
			   }
			   j++;
			   if(j>=markGene.length) j = 0;
			   }
		   }
		   
		/*public void mutate(int length) {
			choose(length);
			for(int i=0;i<markGene.length;i++) {
			if(markGene[i] == 1) {
			int x = 0;
		    if(Math.random()>0.5)
			 x = genetype[i] + 1;
		    else x=genetype[i] + 2;
			genetype[i] = x%3;
		       }
			 }
		  }*/
		 
		 public void mutate(int location) {
					int x = 0;
				    if(Math.random()>0.5)
					 x = genetype[location] + 1;
				    else x=genetype[location] + 2;
					genetype[location] = x%3;
		 }
	   }

