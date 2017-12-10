package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.GA;
import main.Trait;

public class CrossoverTest {

	int[] solution1 = {0,0,0,0,0,0,0,0,0,0,0,0};
	int[] solution2 = {1,1,1,1,1,1,1,1,1,1,1,1};
	GA ga = new GA();
	Trait traitOne = new Trait(solution1,1);
	Trait traitTwo = new Trait(solution2,2);
	
	@Test
	public void test1() {
		assertEquals("000000000000",traitOne.toString());
	}

	@Test
	public void test() {
		int[] traitT = Trait.crossover(traitOne, traitTwo);
		int[] traitF = Trait.crossover(traitTwo, traitOne);
		String str1 = "";
		   for(int i = 0; i < traitT.length;i++)
			   str1 += ""+traitT[i];
		String str2 = "";
		   for(int i = 0; i < traitF.length;i++)
			   str2 += ""+traitF[i];
		   
		assertEquals(traitOne.toString(),"000000000000");
		assertEquals(str1,"010101010101");
		assertEquals(str2,"101010101010");
	}

}
