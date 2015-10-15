package com.sveta_petrova.taskCalc.steps;

import java.util.concurrent.TimeUnit;

import com.sveta_petrova.taskCalc.pages.GoogleCalculatorPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EndUserSteps extends ScenarioSteps {

    GoogleCalculatorPage googleCalculatorPage;
   
   @Step 
   public void performance(String fieldOp){
	   char[] fieldOfOp = fieldOp.toCharArray();
	   for (int i = 0; i < fieldOfOp.length; i++){
		   if(googleCalculatorPage.isOperation(fieldOfOp[i])){
			   googleCalculatorPage.chooseOperation(fieldOfOp[i]);
		   }
		   else{
			   googleCalculatorPage.enterOfElementOperation(fieldOfOp[i]);
	       }
	   }
   }
    
    @Step 
    public void shouldSeeCorrectResult(String expectedResult){
    	assertThat(googleCalculatorPage.getResult(), equalTo(expectedResult));
    }
    
    @Step
    public void isTheGoogleCalculatorHomePage() {
    	googleCalculatorPage.open();
    	googleCalculatorPage.enter_keywords("1-1");
    	googleCalculatorPage.startsSearch();
    }
    
}