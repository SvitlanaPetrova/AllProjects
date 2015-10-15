package com.sveta_petrova.taskCalc.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

@DefaultUrl("http://www.google.com/")
public class GoogleCalculatorPage extends PageObject {

	@FindBy(name="q")
    private WebElementFacade searchField;

    @FindBy(name="btnG")
    private WebElementFacade lookUpButton;
    
    public WebDriver driver;
    
    @FindBy(id="cwbt26")
    private WebElementFacade operationMult;
    
    @FindBy(id="cwbt16")
    private WebElementFacade operationDiv;
    
    @FindBy(id ="cwbt36")
    private WebElementFacade operationSub;
    
    @FindBy(id="cwbt46")
    private WebElementFacade operationAdd;
    
    @FindBy(id="cwbt45")
    private WebElementFacade operationEqual;
    
    @FindBy(id="cwotbl")
    public WebElementFacade resultField;
    
    @FindBy(xpath = "//*[contains (@id, 'cwbt')]")
    private List<WebElementFacade> allElementsOp;

    public void lookUpField() {
        lookUpButton.click();
    }
    
    public void startsSearch() {
        lookUpField();
    }
    
    public void clickOnAddButton(){
    	operationAdd.click();
    }
    
    public void clickOnMultButton(){
        operationMult.click();
    }
    
    public void clickOnDivButton(){
    	operationDiv.click();
    }
    
    public void clickOnSubButton(){
    	operationSub.click();
    }
    
    public void clickOnEqualButton(){
    	operationEqual.click();
    }
    

	public void enter_keywords(String base_word) {
		searchField.sendKeys(base_word);
	}
    
	public void enterOfElementOperation(char elementsOperation){
			for(WebElementFacade buttonElement: allElementsOp){
				if(buttonElement.getText().toCharArray()[0] == elementsOperation){
					buttonElement.click();
				}
		    }
	}
	
	 public boolean isOperation(char elementField){
 		if((elementField == '+') || (elementField == '-') || (elementField == '*') || (elementField == '/') || (elementField == '=') ){
 			return true;
 	}
 		return false;
 }
	 
	 public void chooseOperation(char operation){
		   
		   switch(operation){
		          case '+': 
			   clickOnAddButton();
		          break;
		          case '-': 
			   clickOnSubButton();
		          break;
		          case '*': 
			
			   clickOnMultButton();
		          break;
		          case '/': 
			   clickOnDivButton();
		          break;
		          case '=': 
			   clickOnEqualButton();
		          break;
		   }
	   }
	
	public String getResult(){
	      return resultField.getText();
		}
	
}