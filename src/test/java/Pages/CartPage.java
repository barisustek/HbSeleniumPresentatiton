package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends PageObject {

    public CartPage(WebDriver driver){super(driver);}

    private List<WebElement> getCartItemList(){

        WebElement elements = driver.findElement(By.xpath("//section[@id='onboarding_item_list']/ul"));

        return elements.findElements(By.tagName("li"));
    }

    public boolean checkItemNameFromCart(String item){

        List <WebElement> list = getCartItemList();
        ArrayList <String> item_name = new ArrayList<>();
        for (WebElement webElement : list) {
            item_name.add(webElement.findElement(By.xpath("//div[contains(@class, 'product_name')]//a")).getText());
        }

        return (item_name.contains(item));

    }

}


