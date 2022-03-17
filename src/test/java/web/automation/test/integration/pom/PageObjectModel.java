package web.automation.test.integration.pom;

import org.openqa.selenium.By;

/*Page Object Model(POM)*/
public class PageObjectModel {

    public static By ADD_To_WISHLIST_PRODUCT_ONE = By.xpath("(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]");

    public static By BROWSE_WISHLIST = By.xpath("(//a[@data-title='Browse wishlist'])[1]");

    public static By CLOSE_ACCEPT_COOKIES = By.xpath("//a[@class='cc-btn cc-accept-all cc-btn-no-href']");

    public static By ADD_TO_PRODUCT_TITLE_ONE = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']/h2)[1]");

    public static By ADD_TO_PRODUCT_TITLE_TWO = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']/h2)[2]");

    public static By ADD_TO_PRODUCT_TITLE_THREE = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']/h2)[3]");

    public static By ADD_TO_PRODUCT_TITLE_FOUR = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']/h2)[4]");

    public static By VERIFY_PRODUCT_TITLE_ONE = By.xpath("(//td[@class='product-name'])[1]");

    public static By VERIFY_PRODUCT_TITLE_TWO = By.xpath("(//td[@class='product-name'])[2]");

    public static By VERIFY_PRODUCT_TITLE_THREE = By.xpath("(//td[@class='product-name'])[3]");

    public static By VERIFY_PRODUCT_TITLE_FOUR = By.xpath("(//td[@class='product-name'])[4]");

    public static By CART_PRODUCT_PRICE = By.xpath("//td[@class='product-price']");

    public static By ADD_TO_CART = By.xpath("//td[@class='product-add-to-cart']");

    public static By VIEW_TO_CART = By.xpath("//i[@class='la la-shopping-bag']");
}
