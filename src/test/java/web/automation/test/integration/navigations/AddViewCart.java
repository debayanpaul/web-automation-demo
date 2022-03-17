package web.automation.test.integration.navigations;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.automation.test.integration.driver.DriverConfig;
import web.automation.test.integration.pom.PageObjectModel;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*Wish List Implementation Class*/
public class AddViewCart {

    WebDriver driver;

    public AddViewCart() {
        this.driver = DriverConfig.driver;
    }

    /*Search for lowest price product */
    public void fetchLowestPriceProduct() {
        HashMap<Integer,String> priceMap = new HashMap<Integer,String>();
        int position = 0;

        List<WebElement> allPriceResults = driver.findElements(PageObjectModel.CART_PRODUCT_PRICE);

        for(WebElement eachResult:allPriceResults) {
            priceMap.put(position, (eachResult.getText().substring(eachResult.getText().lastIndexOf("£") + 1)));
            position++;
        }

        priceMap.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> Serenity.setSessionVariable("PositionLowestPrice").to(k.getKey()));

        Serenity.setSessionVariable("AmountLowestPrice").
                to(priceMap.get(Serenity.sessionVariableCalled("PositionLowestPrice")));
    }

    /*Add the lowest price item to my cart */
    public void addLowestPriceProduct(){
        try{Thread.sleep(1000);}catch (Exception e){e.printStackTrace();}
        int position = 0;
        List<WebElement> allPriceCart = driver.findElements(PageObjectModel.ADD_TO_CART);

        for(WebElement eachResult:allPriceCart) {
            if(position == (int)Serenity.sessionVariableCalled("PositionLowestPrice"))
                eachResult.click();
            position++;
        }
    }

    /*Verify the lowest price item in my cart */
    public void verifyCartLowestPriceProduct() {
        try{Thread.sleep(1000);}catch (Exception e){e.printStackTrace();}
        driver.findElement(PageObjectModel.VIEW_TO_CART).click();

        assertThat(driver.findElements(PageObjectModel.CART_PRODUCT_PRICE).size() == 1);
        assertThat(driver.findElements(PageObjectModel.CART_PRODUCT_PRICE).equals(Serenity.sessionVariableCalled("AmountLowestPrice")));
    }
}
