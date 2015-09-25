package com.epam.svitlana_petrova.lesson1.task_test;

import junit.framework.TestCase;
import com.epam.svitlana_petrova.lesson1.task1.Calculate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculateTestCase{

	Calculate calculate = new Calculate();
	
	@Test
    public void add (){
		 assertEquals(5, calculate.Add(2, 3)); 
		 assertEquals(5, calculate.Add(-100, 100));
		 assertEquals(5, calculate.Add(0, 3));
    }
	
	@Test
    public void sub (){
         assertEquals(-4, calculate.Differ(-7, -3));
         assertEquals(-4, calculate.Differ(15, 0));
         assertEquals(-4, calculate.Differ(2, 18));
    }
	
	@Test
    public void mult (){
        assertEquals(30, calculate.Multiple(10, 3));
        assertEquals(30, calculate.Multiple(-15, 3));
        assertEquals(30, calculate.Multiple(-10, -10));
    }
	
	@Test
    public void div (){
        assertEquals(3, calculate.Division(15, 5));
        assertEquals(3, calculate.Division(0, 10));
        assertEquals(3, calculate.Division(5, 5));
    }
	
}
