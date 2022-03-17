/*
 * Step Definition file
 */
package web.automation.test.integration.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import web.automation.test.integration.navigations.AddViewCart;
import web.automation.test.integration.navigations.WishListNavigations;

public class WebStepDefinition extends PageObject {

    @Steps
    WishListNavigations wishListNavigations;

    @Steps
    AddViewCart addViewCart;

    @Given("I add four different products to my wish list")
    public void iAddFourDifferentProductsToMyWishList() {
        wishListNavigations.launchingWebsite();
        wishListNavigations.addItemsintoWishList();
    }

    @When("I view my wishlist table")
    public void iViewMyWishlistTable() {
        wishListNavigations.navigateToMyWishList();
    }

    @Then("I find total four selected items in my Wishlist")
    public void iFindTotalFourSelectedItemsInMyWishlist() {
        wishListNavigations.verifyMyWishList();
    }

    @When("I search for lowest price product")
    public void iSearchForLowestPriceProduct() {
        addViewCart.fetchLowestPriceProduct();
    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {
        addViewCart.addLowestPriceProduct();
    }

    @Then("I am able to verify the item in my cart")
    public void iAmAbleToVerifyTheItemInMyCart() {
        addViewCart.verifyCartLowestPriceProduct();
    }
}
