package web.automation.test.integration.navigations;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.automation.test.integration.driver.DriverConfig;
import web.automation.test.integration.pom.PageObjectModel;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/*Wish List Implementation Class*/
public class WishListNavigations extends UIInteractionSteps {

    private static final String URL = "https://testscriptdemo.com/";
    WebDriver driver;

    public WishListNavigations() {
        this.driver = DriverConfig.getDriver();
    }

    /*Launching and Loading the website */
    public void launchingWebsite() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(URL);

        driver.manage().window().maximize();
        closeAcceptCookies();
    }

    /*Resolve AcceptCookies Popup */
    public void closeAcceptCookies(){
        driver.findElement(PageObjectModel.CLOSE_ACCEPT_COOKIES).click();
    }

    /*Add four different products to my wish list */
    public void addItemsintoWishList() {
        int count=0;
        WebDriverWait wait = new WebDriverWait(driver,30);

        try {
            do {
                Thread.sleep(1000);
                driver.findElement(PageObjectModel.ADD_To_WISHLIST_PRODUCT_ONE).click();
                count++;
            } while (count < 4);
            getListProducsTitle();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*Get the list of Product title from product listing page */
    public void getListProducsTitle() {

        List<String> listProductTitle = List.of(
                driver.findElement(PageObjectModel.ADD_TO_PRODUCT_TITLE_ONE).getText().toString(),
                driver.findElement(PageObjectModel.ADD_TO_PRODUCT_TITLE_TWO).getText().toString(),
                driver.findElement(PageObjectModel.ADD_TO_PRODUCT_TITLE_THREE).getText().toString(),
                driver.findElement(PageObjectModel.ADD_TO_PRODUCT_TITLE_FOUR).getText().toString()
        );
        Serenity.setSessionVariable("ListProductTitle").to(listProductTitle);
    }

    /*View my wishlist page */
    public void navigateToMyWishList() {
        driver.findElement(PageObjectModel.BROWSE_WISHLIST).click();
    }

    /*Find total four selected items in my Wishlist */
    public void verifyMyWishList() {
        List<String> verifyProductTitle = List.of(
                driver.findElement(PageObjectModel.VERIFY_PRODUCT_TITLE_ONE).getText().toString(),
                driver.findElement(PageObjectModel.VERIFY_PRODUCT_TITLE_TWO).getText().toString(),
                driver.findElement(PageObjectModel.VERIFY_PRODUCT_TITLE_THREE).getText().toString(),
                driver.findElement(PageObjectModel.VERIFY_PRODUCT_TITLE_FOUR).getText().toString()
        );

        assertThat(verifyProductTitle.size() == 4);
        assertThat(verifyProductTitle.containsAll(Serenity.sessionVariableCalled("ListProductTitle")));
    }
}