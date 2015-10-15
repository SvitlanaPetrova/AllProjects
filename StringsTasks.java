package com.epam.svitlana_petrova.lesson1.task1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.*;

public class StringsTasks {
	private int numberOfStrings;

    public int setNumberOfStrings() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        return numberOfStrings = scanner.nextInt();
    }
    public int getNumberOfStrings(){
        return numberOfStrings;
    }

    public ArrayList<String> inputString (ArrayList<String> string, int numberOfElements){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print("Enter " + (i + 1) + " string: ");
            string.add(scanner.nextLine());
        }
        return string;
    }

    public int getAvgLenght(ArrayList<String> strings){
        int sumOfLegthes = 0;
        for (String item : strings) {
            sumOfLegthes += item.length() ;
        }
       // System.out.println("Avg length = " + (int)(sumOfLegthes/strings.size()));
        return (int)(sumOfLegthes/strings.size());
    }

    public ArrayList<String> task2_1(ArrayList<String> string){
        ArrayList<String> resultArray = new ArrayList();
        String maxLengthString = string.get(0);
        String minLengthString = string.get(0);
        for (int i = 0; i < string.size(); i++) {
            if (string.get(i).length() > maxLengthString.length()){
                resultArray.add(string.get(i));
            }
            if (string.get(i).length() < minLengthString.length()){
                resultArray.add(string.get(i));
            }
        }
        return resultArray;
    }

    public ArrayList<String> task2_2(ArrayList<String> strings){
        ArrayList<String> resultArray = new ArrayList();
        int avgLegths = this.getAvgLenght(strings);
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() > avgLegths){
                resultArray.add(strings.get(i));
                //System.out.println("String: " + strings[i] + " ; Length: " + strings[i].length());
            }
        }
        return resultArray;
    }
    public ArrayList<String> task2_3(ArrayList<String> strings){
        ArrayList<String> resultArray = new ArrayList();
        int avgLegths = this.getAvgLenght(strings);
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < avgLegths){
                resultArray.add(strings.get(i));
               // System.out.println("String: " + strings[i] + " ; Length: " + strings[i].length());
            }
        }
        return resultArray;
    }

    public String task2_4 (String[] strings){
        return  findWordWithMinDifferentSymbols(strings);

    }

    public String task2_5 (String[] strings){
        return findAllWordWithDifferentSymbols(strings);
    }

    public int countDifferentSymbolsInWord(String string) {
        char[] stringChars = string.toCharArray();
        StringBuilder sb = new StringBuilder(string);
        int lengthString = stringChars.length;
        for (int i = 1; i < lengthString; i++){
            for (int j = i; j < lengthString; j++) {
                if (stringChars[i] == stringChars[j]) {
                    sb.deleteCharAt(j);
                    lengthString--;
                }
            }
        }
        return sb.length();
    }

    public String findWordWithMinDifferentSymbols(String[] strings) {
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (this.countDifferentSymbolsInWord(result) > this.countDifferentSymbolsInWord(strings[i])) {
                result = strings[i];
            }
        }
        //System.out.println(result + "(" + this.countDifferentSymbolsInWord(result) + ")");
        return result;
    }

    public String findAllWordWithDifferentSymbols(String[] strings){
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (this.countDifferentSymbolsInWord(result) == strings[i].length()) {
                result = strings[i];
            }
        }
        //System.out.println(result + "(" + this.countDifferentSymbolsInWord(result) + ")");
        return result;
    }

    public String task2_6(String[] strings){
        //System.out.println("Result = " + this.findNumericWord(strings));
        return findNumericWord(strings);
        

    }

    public boolean isNumericWord(String string) {
        if (string.matches("[+-]?[0-9]+")) {
            return true;
        }
        return false;
    }

    public String findNumericWord(String[] strings){
        int count = 0;
        String result = "There is no numeric word ";
        for (int i = 0; i < strings.length; i++) {
            if(count < 2) {
                if (this.isNumericWord(strings[i])) {
                    count++;
                    result = strings[i];
                }
            }
        }
    return result;
    }
    
}

