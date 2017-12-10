package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.GA;
import main.Trait;

public class TraitMutateTest {

	int[] solution1 = {0,0,0,0,0,0,0,0,0,0,0,0};
	int[] solution2 = {1,1,1,1,1,1,1,1,1,1,1,1};
	int[] solution3 = {3,3,3,3,3,3,3,3,3,3,3,3};
	
	Trait traitOne = new Trait(solution1,1);
	Trait traitTwo = new Trait(solution2,2);
	Trait traitThree = new Trait(solution3,2);

	
	@Test
	public void test1() {
		int count = 0;
		int[] temps = {1,1,1,1,1,1,1,1,1,1,1,1};
		Trait temp = new Trait(temps,traitTwo.getValue()) ;
		traitTwo.mutate(10);
		for(int i = 0; i < temp.getGenetype().length;i++)
			if(temp.getGenetype(i)!=traitTwo.getGenetype(i)) count++;
		assertEquals(count,1);
	}

	@Test
	public void test2() {
		int count = 0;
		int[] temps = {1,1,1,1,1,1,1,1,1,1,1,1};
		Trait temp = new Trait(temps,traitTwo.getValue()) ;
		traitTwo.mutate(0);
		for(int i = 0; i < temp.getGenetype().length;i++)
			if(temp.getGenetype(i)!=traitTwo.getGenetype(i)) count++;
		assertEquals(count,1);
	}
	@Test
	public void test3() {
		int count = 0;
		int[] temps = {1,1,1,1,1,1,1,1,1,1,1,1};
		Trait temp = new Trait(temps,traitTwo.getValue()) ;
		traitTwo.mutate(3);
		for(int i = 0; i < temp.getGenetype().length;i++)
			if(temp.getGenetype(i)!=traitTwo.getGenetype(i)) count++;
		assertEquals(count,1);
	}
	@Test
	public void test4() {
		int count = 0;
		int[] temps = {1,1,1,1,1,1,1,1,1,1,1,1};
		Trait temp = new Trait(temps,traitTwo.getValue()) ;
		traitTwo.mutate(11);
		for(int i = 0; i < temp.getGenetype().length;i++)
			if(temp.getGenetype(i)!=traitTwo.getGenetype(i)) count++;
		assertEquals(count,1);
	}
}
