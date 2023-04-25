package homepage;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.linkText("Desktops"));

        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        String menu = "Show AllDesktops";
        selectMenu(menu);

        // 1.3 Verify the text ‘Desktops’
        assertVerifyText(By.xpath("//h2[normalize-space()='Desktops']"), "Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        String menu = "Show AllLaptops & Notebooks";
        selectMenu(menu);

        // 2.3 Verify the text ‘Laptops & Notebooks’
        assertVerifyText(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"),"Laptops & Notebooks");
    }

    @Test
    public void  verifyUserShouldNavigateToComponentsPageSuccessfully() {
        // 3.1  Mouse hover on “Components” Tab and click
        mouseHoverOnElement(By.linkText("Components"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        String menu = "Show AllComponents";
        selectMenu(menu);

        // 3.3 Verify the text ‘Components’
        assertVerifyText(By.xpath("//h2[normalize-space()='Components']"),"Components");
    }
    @After
    public void tearDown() {
        //closeBrowser();
    }


}
