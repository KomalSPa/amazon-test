package testsuite;
/**
 * 1. Open the URL https://www.amazon.co.uk/
 * 2. Type "Dell Laptop" in the search box and press enter or click on search Button. *
 * 3. Click on the checkbox brand Dell on the left side.
 * 4. Verify that the  30(May be different) products are displayed on the page.
 * 5. Print all product names in the console.
 * 6. Click on the product name 'Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14" Ful HD Windows 10 Pro Laptop - CT22R
 * Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14" Ful HD Windows 10 Pro Laptop - CT22R'
 * 7. Close the Browser.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {
    // 1. Open the URL https://www.amazon.co.uk/
    String baseURL = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {


        openBrowser(baseURL);
        clickOnElement(By.id("sp-cc-accept"));
    }

    @Test
    public void dellLaptop() {
        // 2. Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));

        // 3. Click on the checkbox brand Dell on the left side.
        // clickOnElement(By.xpath("//li[@id='p_89/Dell']//span[@class='a-list-item']//a[@class='a-link-normal s-navigation-item']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//label//i[@class='a-icon a-icon-checkbox']"));
        clickOnElement(By.xpath("//span[@class='a-size-base a-color-base'][contains(text(),'Dell')]"));

        // 4. Verify that the  30(May be different) products are displayed on the page.

        int expectedQty = 24;
        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQty = productList.size();
        Assert.assertEquals("Product QTY does not match", expectedQty, actualQty);

        //  5. Print all product names in the console.

        List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement e : productNames) {
            System.out.println(e.getText());
        }

        // 6. Click on the product name 'Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14" Ful HD Windows 10 Pro Laptop - CT22R
        clickOnElement(By.xpath("//span[contains(text(),'Dell Latitude 7420 Intel Core i5-1145G7 vPro 16GB RAM 256GB SSD 14\" Ful HD Windows 10 Pro Laptop - CT22R')]"));
    }
    @After
    public void closeBrowser() {driver.quit();}


}
