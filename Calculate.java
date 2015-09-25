package com.epam.svitlana_petrova.lesson1.task1;
import java.util.Scanner; 

public class Calculate {
	 Scanner scanner = new Scanner(System.in);

	    public void inputNumbers(){
	        System.out.println("Choose number of operation");
	        System.out.println("1. Add operation");
	        System.out.println("2. Differ operation");
	        System.out.println("3. Division operation");
	        System.out.println("4. Multiple operation");
	       // String operation = scanner.next();
	    }

	    public int setInputNumber (String message){
	        System.out.println(message);
	       return scanner.nextInt();
	    }

	    public int chooseOperation(int firstInputNumber, int secondInputNumber){
	        int resultOperation = 0;
	        System.out.println("Choose operation: 1 - Add; 2 - Differ; 3 - Division; 4 - Multiple; 0 - Exit");
	        int operation = scanner.nextInt();
	        switch (operation)
	        {
	            case 1: resultOperation = this.Add(firstInputNumber, secondInputNumber);
	                break;
	            case 2: resultOperation = this.Differ(firstInputNumber, secondInputNumber);
	                break;
	            case 3: resultOperation = this.Division(firstInputNumber, secondInputNumber);
	                break;
	            case 4: resultOperation = this.Multiple(firstInputNumber, secondInputNumber);
	                break;
	        }
	        return resultOperation;
	    }
	    public int Add (int firstInputNumber, int secondInputNumber){
	        return  firstInputNumber + secondInputNumber;
	    }

	    public int Multiple (int firstInputNumber, int secondInputNumber){
	        return firstInputNumber * secondInputNumber;
	    }

	    public int Division (int firstInputNumber, int secondInputNumber){
	        return firstInputNumber / secondInputNumber;
	    }

	    public int Differ (int firstInputNumber, int secondInputNumber){
	        return firstInputNumber - secondInputNumber;
	    }

	    public void runApplication (){
	            int firstInputNumber = this.setInputNumber("Please input 1st number: ");
	            int secondInputNumber = this.setInputNumber("Please input 2nd number: ");
	            int result = this.chooseOperation(firstInputNumber, secondInputNumber);
	            System.out.println("Result = " + result);
	        }

}
