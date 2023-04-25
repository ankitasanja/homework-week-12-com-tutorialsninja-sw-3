package browserfactory;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will select an element from dropdown list
     */
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    /**
     * This method will click on number of element
     */
    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will click on element
     */

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * Hovermoving method
     */
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }


    /**
     * Hovermoving method and click on that element
     */
    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * This method will select the option by visible text
     */
    public void selectAnElementFromDropdown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

    /**
     * Assert method
     */
    public void assertVerifyText(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        String expectedText1 = expectedText;
        Assert.assertEquals("Error= Test Failed", expectedText1, actualText);
    }
}
