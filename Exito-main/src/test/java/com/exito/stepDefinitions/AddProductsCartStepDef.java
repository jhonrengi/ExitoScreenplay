package com.exito.stepDefinitions;

import com.exito.questions.ProductValidationQuestion;
import com.exito.tasks.HomeTask;
import com.exito.tasks.ProductsCatalogTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AddProductsCartStepDef {
    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("that user open page exito and select any category and select any subcategory")
    public void thatUserOpenPageExitoAndSelectAnyCategoryAndSelectAnySubcategory() {
        theActorCalled("User").wasAbleTo(
                Open.url("https://www.exito.com/"),
                HomeTask.on()
        );
    }

    @When("clicks on add on three products choosing their quantities and clicks on the shopping cart")
    public void clicksOnAddOnThreeProductsChoosingTheirQuantitiesAndClicksOnTheShoppingCart() {
        theActorInTheSpotlight().attemptsTo(
                ProductsCatalogTask.on()
        );
    }

    @Then("user will be able to see the selected products with their quantities")
    public void userWillBeAbleToSeeTheSelectedProductsWithTheirQuantities() {
        theActorInTheSpotlight().should(
                seeThat(
                        ProductValidationQuestion.from(), Matchers.equalTo(true)
                )
        );
    }

}
