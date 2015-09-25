package com.epam.svitlana_petrova.lesson1.task1;
import java.util.ArrayList;

public class MainApplication {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
	        int[] array = new int[20];
	        ArrayList<String > strings = new ArrayList();
	        MainApplication programm = new MainApplication();
	        programm.startTask1Array(array);
	        programm.startTask1String(strings);



	    }
	     public void startTask1Array(int[] sourceArray){
	         final int SIZE = 20;
	         final int LEFTBORDER = -10;
	         final int RIGHTBORDER = 10;
	         ArraysTasks myArrays = new ArraysTasks();
	         int[] resultArray = new int[SIZE];
	         sourceArray = myArrays.createRandomArray(sourceArray,LEFTBORDER,RIGHTBORDER,SIZE);
	         myArrays.printArray(sourceArray);
	         resultArray = myArrays.swapValues(sourceArray);
	         myArrays.printArray(resultArray);
	     }
	     

	    public void startTask1String(ArrayList<String> strings){
	        ArrayList<String> resultStrings = new ArrayList();
	        int numberOfStrings = 0;
	        StringsTasks myStrings = new StringsTasks();
	        System.out.println("Please input number of strings:");
	        numberOfStrings = myStrings.setNumberOfStrings();
	        System.out.println("Input " + numberOfStrings + "strings: ");
	        strings = myStrings.inputString(strings,numberOfStrings);
	        resultStrings = myStrings.task2_1(strings);
	        System.out.println("Result: " + resultStrings.toString());
	    }

}

