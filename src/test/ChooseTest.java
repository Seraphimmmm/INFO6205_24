package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.GA;

public class ChooseTest {
	GA ga = new GA();
	@Before
	public void setUp() throws Exception {
		   ga.initial();
		   ga.generate();
	}

	
	@Test
	public void testChoose() {
		ga.choose(50, 0.8);
		int count = 0;
		for(int i = 0;i < ga.getMarkCross().length;i++) {
			int[] temp = ga.getMarkCross();
			if(temp[i] == 1) count++;
		}
		assertEquals(count,(int)(50*0.8));
		
	}
	@Test
	public void testChoose2() {
		ga.choose(30, 0.8);
		int count = 0;
		for(int i = 0;i < ga.getMarkCross().length;i++) {
			int[] temp = ga.getMarkCross();
			if(temp[i] == 1) count++;
		}
		assertEquals(count,(int)(30*0.8));
		
	}
	@Test
	public void testChoose3() {
		ga.choose(20, 0.8);
		int count = 0;
		for(int i = 0;i < ga.getMarkCross().length;i++) {
			int[] temp = ga.getMarkCross();
			if(temp[i] == 1) count++;
		}
		assertEquals(count,(int)(20*0.8));
		
	}
	@Test
	public void testChoose4() {
		ga.choose(00, 0.8);
		int count = 0;
		for(int i = 0;i < ga.getMarkCross().length;i++) {
			int[] temp = ga.getMarkCross();
			if(temp[i] == 1) count++;
		}
		assertEquals(count,(int)(00*0.8));
		
	}

}
