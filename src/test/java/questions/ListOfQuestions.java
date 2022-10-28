package questions;

import POM.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ListOfQuestions {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();// для проверки в хроме
        //driver = new FirefoxDriver();// для проверки в фаерфоксе
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        mainPage.open();
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    @Test
    public void checkQuestions(){
        MainPage mainPage = new MainPage(driver);

        mainPage.checkPriceQuestion();
        mainPage.checkAmountQuestion();
        mainPage.checkTimeQuestion();
        mainPage.checkTodayQuestion();
        mainPage.checkExtendQuestion();
        mainPage.checkChargerQuestion();
        mainPage.checkCancellationQuestion();
        mainPage.checkMkadQuestion();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
