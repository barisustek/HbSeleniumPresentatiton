package Tests;

import Configurations.Connection;
import Pages.*;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AddToCartWithoutLogin extends Connection {

    MainPage mainpage ;
    SearchResultPage searchResultPage ;
    ProductPage productPage ;
    CartPage cartPage;

    String search_text = "Asus Bilgisayar";

    @Test
    public void addToCartWithoutLogin() {

        mainpage = new MainPage(driver);

        assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com",driver.getTitle());

        searchResultPage = mainpage.searchText(search_text);

        AssertJUnit.assertTrue(searchResultPage.checkSearchText(search_text));

        productPage = searchResultPage.enterProductDetail(2);
        productPage.clickCurrentSellerAddToCart();

        AssertJUnit.assertTrue(productPage.isItemAdded("Ürün sepetinizde"));

        productPage.clickClosePopUpButton();
        String product_name = productPage.getProductText();
        cartPage = mainpage.goToCart();

        AssertJUnit.assertTrue(cartPage.checkItemNameFromCart(product_name));

    }
}