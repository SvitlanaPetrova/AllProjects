package com.sveta_petrova.taskCalc.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.sveta_petrova.taskCalc.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the google calculator page")
    public void givenTheUserIsOnTheGoogleCalculatorPage() {
        endUser.isTheGoogleCalculatorHomePage();
    }

    @When("the user click on the buttons one by one for receive field '$action'")
    public void whenTheUserClickOnTheButtonsOneByOneForReceiveField(String action) {
        endUser.performance(action);
    	
    }

    @Then("the user should see a correct result of action '$expectedResult'")
    public void thenTheUserorrectResultOfAction(String expectedResult) {
        endUser.shouldSeeCorrectResult(expectedResult);
    }
}
