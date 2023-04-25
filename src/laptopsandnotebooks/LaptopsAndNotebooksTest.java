package laptopsandnotebooks;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // 1.3 Select Sort By "Price (High > Low)"
        selectAnElementFromDropdown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 1.4 Verify the Product price will arrange in High to Low order.

        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='row']//p[@class='price']"));
        Thread.sleep(2000);
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            actualList.add(element.getText());
        }

        System.out.println(actualList);


        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            expectedList.add(element.getText());
        }

        Collections.sort(expectedList);
        System.out.println(expectedList);
        Assert.assertEquals("Not matched", expectedList, actualList);


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // 2.3 Select Sort By "Price (High > Low)"
        selectAnElementFromDropdown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));
        Thread.sleep(2000);
        // 2.5 Verify the text “MacBook”
        By text = By.xpath("//h1[normalize-space()='MacBook']");
        String actualText = driver.findElement(By.xpath("//h1[normalize-space()='MacBook']")).getText();
        System.out.println(actualText);
        assertVerifyText(text, "MacBook");
        Thread.sleep(2000);
        // 2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        WebElement elementMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actual = elementMessage.getText();
        System.out.println(actual);
        String expected = "Success: You have added MacBook to your shopping cart!";

        System.out.println(expected);
        boolean message = actual.contains(expected.trim());
        Assert.assertTrue(message);
        Thread.sleep(2000);

        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));

        // 2.9 Verify the text "Shopping Cart"
        By cart = By.xpath("//h1[contains(text(),'Shopping Cart')]");
        assertVerifyText(cart, "Shopping Cart  (0.00kg)");
//      String actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
//      System.out.println(actualMessage);

        // 2.10 Verify the Product name "MacBook"
        By productName = By.xpath("(//a[contains(text(),'MacBook')])[2]");
        System.out.println(driver.findElement(By.xpath("(//a[contains(text(),'MacBook')])[2]")).getText());
        assertVerifyText(productName, "MacBook");

        // 2.11 Change Quantity "2"
        WebElement element = driver.findElement(By.cssSelector("input[value='1']"));
        element.clear();
        sendTextToElement(By.cssSelector("input[value='1']"), "2");
        Thread.sleep(2000);

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        Thread.sleep(2000);

        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        WebElement elementMessage1 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actual1 = elementMessage1.getText();
        System.out.println(actual1);
        String expected1 = "Success: You have modified your shopping cart!";

        System.out.println(expected1);
        boolean message1 = actual1.contains(expected1.trim());
        Assert.assertTrue(message1);
        Thread.sleep(2000);

        // 2.14 Verify the Total £737.45
        By total = By.xpath("//tbody//tr//td[6]");
        System.out.println(driver.findElement(By.xpath("//tbody//tr//td[6]")).getText());
        assertVerifyText(total, "$1,204.00");

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        By actualText1 = By.xpath("//h1[normalize-space()='Checkout']");
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Checkout']")).getText());
        assertVerifyText(actualText1, "Checkout");

        //2.17 Verify the Text “New Customer”
        By newText = By.xpath("//h2[normalize-space()='New Customer']");
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).getText());
        assertVerifyText(newText, "New Customer");

        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(2000);

        // 2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        // 2.20 Fill the mandatory fields
        //Enter first name
        sendTextToElement(By.id("input-payment-firstname"), "John");
        //Enter last name
        sendTextToElement(By.id("input-payment-lastname"), "Smith");
        //Enter email
        //String randomEmail = randomEmail();
        sendTextToElement(By.id("input-payment-email"), "john123@gmail.com");
        //Enter telephone
        sendTextToElement(By.id("input-payment-telephone"), "056981239");
        //Enter address
        sendTextToElement(By.id("input-payment-address-1"), "CrossWay");
        //Enter city
        sendTextToElement(By.id("input-payment-city"), "Slough");
        //postcode
        sendTextToElement(By.id("input-payment-postcode"), "363641");
        //country
        selectAnElementFromDropdown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        //Region
        selectAnElementFromDropdown(By.xpath("//select[@id='input-payment-zone']"), "Cardiff");

        // 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(2000);

        // 2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "I have added two products");

        // 2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        // 2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        Thread.sleep(2000);

        // 2.25 Verify the message “Warning: Payment method required!”
        WebElement elementMessage2 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String actual2 = elementMessage2.getText();
        System.out.println(actual2);
        String expected2 = "Warning: Payment method required!";

        System.out.println(expected2);
        boolean message2 = actual2.contains(expected2.trim());
        Assert.assertTrue(message2);
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
