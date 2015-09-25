package com.epam.svitlana_petrova.lesson1.task_test;

import junit.framework.TestCase;
import com.epam.svitlana_petrova.lesson1.task1.StringsTasks;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.lang.Object;
import java.util.Arrays;

public class StringTestCase {
	   
	    private StringsTasks MyString;
	   
	    ArrayList<String> stringsToTest = new ArrayList(Arrays.asList("java", "cat", "lip","homework", "mail"));
	    String[] string1ToTest = {"jaasda", "cat", "lip","homework", "mail", "123"};
	    ArrayList<String> expectedResult = new ArrayList(Arrays.asList( "cat","lip", "homework"));
	    ArrayList<String> expectedAvgMaxResult = new ArrayList(Arrays.asList("homework"));
	    ArrayList<String> expectedAvgMinResult = new ArrayList(Arrays.asList("cat", "lip" ));

	   @Before 
	   public void setUp(){
		   MyString = new StringsTasks();  
		   
	   }
	    @Test
	    public void minMaxLength (){
	    	
	        assertEquals(expectedResult, MyString.task2_1(stringsToTest));
	    }

	    @Test
	    public void getMinString (){
	        assertEquals(expectedAvgMaxResult, MyString.task2_2(stringsToTest));
	    }
	   @Test
	    public void getMaxString (){
	        assertEquals(expectedAvgMinResult, MyString.task2_3(stringsToTest));
	    }

	    @Test
	    public void getMinDiffString (){
	        assertEquals("cat", MyString.task2_4(string1ToTest));
	    }

	    @Test
	    public void getAllDiffString (){
	        assertEquals("cat", MyString.task2_5(string1ToTest));
	    }

	    @Test
	    public void getNumericWord (){
	        assertEquals("123", MyString.task2_6(string1ToTest));
	    }
	    

}
