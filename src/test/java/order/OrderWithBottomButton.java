package order;

import POM.MainPage;
import POM.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrderWithBottomButton {

    private WebDriver driver;

    @Before
    public void setUp() {
  //      driver = new ChromeDriver();// для проверки в хроме
        driver = new FirefoxDriver();// для проверки в фаерфоксе
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void orderScooter(){
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        mainPage.open();
        mainPage.clickOrderBottomButton();
        orderPage.inputName("Динар");
        orderPage.inputSurname("Мубар");
        orderPage.inputAddress("Елабуга");
        orderPage.selectMetroStation();
        orderPage.inputPhoneNumber("89178715095");
        orderPage.clickDalee();
        orderPage.selectDeliveryDate();
        orderPage.selectRentalPeriod();
        orderPage.clickColourOfScooter();
        orderPage.inputComment();
        orderPage.clickFinalOrderButton();
        orderPage.clickYesButton();
        orderPage.checkOrderIsAccepted();
    }

   @After
   public void tearDown(){
        driver.quit();
   }
}

