package com.epam.svitlana_petrova.lesson1.task_test;

import junit.framework.TestCase;
import org.junit.Before;
import com.epam.svitlana_petrova.lesson1.task1.ArraysTasks;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayTestCase {
	private ArraysTasks MyArrays;

	public ArraysTasks myArrays = new ArraysTasks();
    int[] arrayForTest = {1,2,3,4,5,-2,-5};
    int[] expectedArray = {-2, 2,3,4,5,1,-5};
    int[] expectedForZeroArray = {1,2,3,4,5,0,0};
    int[] expected3Array = {1,2,3,4,15,-2,-5};
    int[] arrayFor6Test = {1,3,5,3,-5,5,-5,2,3};
    int[] expected6Array = {3};
    
    @Before
    public void SetUp(){
    	MyArrays = new ArraysTasks();
    }
    
    @Test
    public void maxNegTest() {
        assertEquals(5, myArrays.getIndexOfMaxNegativeValue(arrayForTest));
    }

    @Test
    public void minPosTest() {
        assertEquals(0, myArrays.getIndexOfMinPositiveValue(arrayForTest));
    }

    @Test
    public void swapTest() {
        assertArrayEquals(expectedArray, myArrays.swapValues(arrayForTest));
    }

    @Test
    public void sumElementsTest() {
        assertEquals(4, myArrays.task1_2(arrayForTest));
    }

    @Test
    public void task1_3(){
        assertArrayEquals(expectedForZeroArray, myArrays.task1_3(arrayForTest));
    }

    @Test
    public void task1_4(){
        assertArrayEquals(expected3Array, myArrays.task1_4(arrayForTest));
    }

    @Test
    public void task1_5Test() {
        assertEquals(6, myArrays.task1_5(arrayForTest));
    }
    @Test
    public void task1_6Test() {
        assertTrue(myArrays.areArraysEqual(expected6Array, myArrays.task1_6(arrayFor6Test)));
    }
}
