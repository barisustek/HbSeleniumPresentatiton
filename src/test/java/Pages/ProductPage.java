package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Sepete ekle butonu
    @FindBy(css = "#addToCart")
    private WebElement add_to_cart_btn ;

    //Ana satıcının adı
    @FindBy(xpath = "//div[@class ='seller-container']/span[@class='seller']/span/a")
    private WebElement current_seller_name ;

    //Sepete ürün eklendiğinde açılan popup
    @FindBy(xpath = "//div[contains(@class, 'hb_sfc_close')]")
    private WebElement close_pop_up ;

    //Ürün adı
    @FindBy(xpath = "//h1[@id='product-name']")
    private WebElement product_name;

    //Ürününüz Sepette
    @FindBy(xpath = "//div[contains(@class, 'sf-SalesFrontCashProductInfo-3jPka')]//div")
    private WebElement isAddedText;

    //Ürün adını döner
    public String getProductText(){
        return product_name.getText();
    }

    public Boolean isItemAdded(String isAddedText){

        return this.isAddedText.getText().equals(isAddedText);

    }

    public void clickCurrentSellerAddToCart(){
        add_to_cart_btn.click();
    }

    public void clickClosePopUpButton(){
        close_pop_up.click();
    }

}
