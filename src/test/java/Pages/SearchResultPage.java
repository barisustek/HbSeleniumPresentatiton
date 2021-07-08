package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageObject {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //Arama yapılan textin arama sonuçları sayfasında bulunan elementi
    @FindBy(css = "#categorySuggestionList > div.category-suggestion-title > h1")
    private WebElement searchedText;

    public boolean checkSearchText(String text){
        return searchedText.getText().equals(text);
    }

    private List<WebElement> getSearchList(){

        WebElement searchlist = driver.findElement(By.xpath("//div[@class='desktop widget SearchListing']/div/div/ul"));
        return searchlist.findElements(By.tagName("li"));

    }

    private void selectProductFromList(int index){

        List<WebElement> item_list = getSearchList();
        item_list.get(index).click();

    }

    public ProductPage enterProductDetail(int index){
        selectProductFromList(index);
        return new ProductPage(driver);
    }

}
