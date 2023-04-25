package myaccounts;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyOptions(String option) {

        clickOnElement(By.linkText("My Account"));
        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a"));
        for (WebElement element : optionsList) {
            if (element.getText().equalsIgnoreCase(option)) {
                clickOnElement(element);
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyOptions("Register"); // driver.findElement(By.xpath("//a[normalize-space()='Register']"))

        //1.3 Verify the text “Register Account”.
        By actualText = By.xpath("//h1[contains(text(),'Register Account')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]")).getText());
        assertVerifyText(actualText, "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyOptions("Login");

        // 2.3 Verify the text “Returning Customer”.
        By actualText = By.xpath("//h2[normalize-space()='Returning Customer']");
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).getText());
        assertVerifyText(actualText, "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyOptions("Register");

        // 3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"), "Magnus");

        // 3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Smith");

        // 3.5 Enter Email
        String randomEmail = randomEmail();
        sendTextToElement(By.id("input-email"), randomEmail);

        // 3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"), "9825655114");

        // 3.7 Enter Password
        sendTextToElement(By.id("input-password"), "smith123456");

        // 3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "smith123456");

        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));

        // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        // 3.12 Verify the message “Your Account Has Been Created!”
        By actualText = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText());
        assertVerifyText(actualText, "Your Account Has Been Created!");
        Thread.sleep(2000);

        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        // 3.14 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        Thread.sleep(2000);

        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyOptions("Logout");

        // 3.16 Verify the text “Account Logout”
        By actualText1 = By.xpath("//h1[contains(text(),'Account Logout')]");
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText());
        assertVerifyText(actualText1, "Account Logout");

        // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyOptions("Login");

        // 4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "magnussmith123@gmail.com");

        // 4.4 Enter Password
        sendTextToElement(By.id("input-password"), "smith123456");

        // 4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        // 4.7 Verify text “My Account
        By actualText1 = By.xpath("//h2[normalize-space()='My Account']");
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText());
        assertVerifyText(actualText1, "My Account");

        // 4.8 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));
        Thread.sleep(2000);

        // 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyOptions("Logout");

        // 4.10 Verify the text “Account Logout”
        By actualText = By.xpath("//h1[normalize-space()='Account Logout']");
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Account Logout']")).getText());
        assertVerifyText(actualText, "Account Logout");
        Thread.sleep(2000);

        // 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
