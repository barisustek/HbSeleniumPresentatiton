package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Login butonu
    @FindBy(id="login")
    private WebElement login_btn;

    //Hesaplarım butonu
    @FindBy(id="MyAccount")
    private WebElement myAccount_btn;

    //Kullanıcı adı textboxu
    @FindBy(css = "#myAccount > div.usersProsess > a.login.user-name")
    private WebElement username;

    //Arama textboxu
    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-inputContainer > div.desktopOldAutosuggestTheme-container > input")
    private WebElement search_txtbox;

    //Arama butonu
    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer")
    private WebElement search_btn;

    //Sepete ekle butonu
    @FindBy(css = "#shoppingCart")
    private WebElement cart_button ;

    private void clickCartButton(){
        cart_button.click();
    }

    private void search(String text){
        search_txtbox.sendKeys(text);
        search_btn.click();
    }

    public SearchResultPage searchText(String text){
        search(text);
        return new SearchResultPage(driver);
    }

    public CartPage goToCart(){
        clickCartButton();
        return new CartPage(driver);
    }

}
