package com.epam.svitlana_petrova.lesson1.task1;

public class ArraysTasks {

	 public int[] createRandomArray (int[] array, int leftBorder, int rightBorder, int numberOfElements){
	        for (int i = 0; i < numberOfElements; i++) {
	            array[i] =  (int)(leftBorder+(Math.random()*(rightBorder-leftBorder)));
	        }
	        return array;
	    }

	    public void printArray(int[] array){
	        System.out.println("Printing array...");
	        for (int i = 0; i < array.length; i++) {
	            System.out.print("a[" + i + "] = " + array[i] + "; ");
	        }
	    }

	    public int getIndexOfMaxNegativeValue(int[] array){
	        int maxNegativeValue = 0;
	        int index = 0;
	        boolean flag = false;
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] < 0){
	                if (!flag){
	                    maxNegativeValue = array[i];
	                    flag = true;
	                }
	                if (array[i] >= maxNegativeValue){
	                    maxNegativeValue = array[i];
	                    index = i;
	                }
	            }
	        }
	        return index;
	    }

	    public int getIndexOfMinPositiveValue(int[] array){
	        int minPositiveValue = 0;
	        int index = 0;
	        boolean flag = false;
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] > 0){
	                if (!flag){
	                    minPositiveValue = array[i];
	                    flag = true;
	                }
	                if (array[i] < minPositiveValue){
	                    minPositiveValue = array[i];
	                    index = i;
	                }
	            }

	        }
	        return index;
	    }

	    public int[] swapValues(int[] array){
	        int temp = 0;
	        int indexOfMinPositiveValue = this.getIndexOfMinPositiveValue(array);
	        int indexOfMaxNegativeValue = this.getIndexOfMaxNegativeValue(array);
	        System.out.println("");
	        System.out.println(indexOfMaxNegativeValue + "<-- - + -->" + indexOfMinPositiveValue);
	        temp = array[indexOfMinPositiveValue];
	        array[indexOfMinPositiveValue] = array[indexOfMaxNegativeValue];
	        array[indexOfMaxNegativeValue] = temp;
	        return  array;
	    }

	    public  int[] task1_1(int[] array){
	        this.printArray(array);
	        int[] resultArray = this.swapValues(array);
	        return resultArray;
	    }

	    public int task1_2(int[] array){
	        //array = this.createRandomArray(array, -10, 10, 20);
	        // this.printArray(array);
	        int resultSumElements = 0;
	        for (int i = 0; i < array.length; i++){
	            if ((i%2) == 0){
	                resultSumElements += array[i];
	            }
	        }
	        return resultSumElements;

	    }

	    public int[] task1_3(int[] array){
	        //array = this.createRandomArray(array, -10, 10, 20);
	        //this.printArray(array);
	        int[] resultArray = new int[array.length];
	        for (int i = 0; i < array.length; i++){
	            if(array[i] < 0) {
	                resultArray[i] = 0;
	            }
	            else {
	                resultArray[i] = array[i];
	            }
	        }
	        return resultArray;
	    }

	    public int[] task1_4(int[] array){
	       // array = this.createRandomArray(array, -10, 10, 20);
	       // this.printArray(array);
	        int[] resultArray = new int[array.length];
	        for (int i = 0; i < array.length; i++) {
	            if ( (array[i] > 0) && (array[i+1] < 0) ){
	                resultArray[i] = array[i] * 3;
	            }
	            else {
	                resultArray[i] = array[i];
	            }
	        }
//	       main.MyArrays asdas = new main.MyArrays();
	        return resultArray;
	    }

	    public int task1_5(int[] array){
	        int getMinValue = array[0];
	        int sumAllElements = 0;
	        int averageElements = 0;
	        int subAvrMin = 0;
	        //array = this.createRandomArray(array, -10, 10, 5);
	        //this.printArray(array);
	        for (int i = 0; i < array.length; i++){
	            sumAllElements += array[i];
	        }
	        averageElements = (int)(sumAllElements/array.length);
	        for (int i = 0; i < array.length; i++){
	            if (getMinValue > array[i]){
	                getMinValue = array[i];
	            }
	        }
	        subAvrMin = averageElements - getMinValue;
	        // System.out.println(getMinValue);
	        return subAvrMin;
	    }
	    public int[] task1_6 (int[] array){
	        int[] neparnArray = this.getNeparniiElements(array);
	        return this.getElement(neparnArray);
	    }

	    public  int[] getNeparniiElements(int[] array)
	    {
	        int[] resultArray = new int[(int)(array.length/2)];
	        int indexResult = 0;
	        for (int i = 0; i < array.length; i++)
	        {
	            if (i % 2 != 0)
	            {
	                resultArray[indexResult] = array[i];
	                indexResult++;
	            }
	        }
	        return resultArray;
	    }

	    public boolean isInArray (int[] array, int element){
	        boolean k = false;
	        for (int i = 0; i < array.length; i++) {
	            if(array[i] == element){
	                k = true;
	                return k;
	            }
	        }
	        return k;
	    }

	    public int[] getElement(int[] array)
	    {
	        int[] resultArray = new int[array.length];
	        int count = 0;
	        int resultIndex = 0;
	        for (int i = 0; i < array.length; i++)
	        {
	            count = 1;
	            for (int j = i; j < array.length; j++)
	            {
	                if (array[i] == array[j])
	                {
	                    count++;
	                }
	            }
	            if (count > 1)
	            {
	                if(!this.isInArray(resultArray, array[i])){
	                    resultArray[resultIndex] = array[i];
	                    resultIndex++;
	                }
	            }
	        }
	        return resultArray;
	    }

	    public boolean areArraysEqual (int[] expectedArray, int[] actualArray){
	        for (int i = 0; i < expectedArray.length; i++) {
	            if (expectedArray[i] != actualArray[i]){
	                return  false;
	            }
	        }
	    return  true;
	    }
}
    
