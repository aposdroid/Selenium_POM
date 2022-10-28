package order;

import POM.MainPage;
import POM.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
@RunWith(Parameterized.class)

public class OrderButton {

    private WebDriver driver;

    private final int numberOfButton;
    private final String name;
    private final String surname;
    private final String metro;
    private final String address;
    private final String phone;
    private final String date;
    private final String period;
    private final String colour;
    private final String text;


    public OrderButton(int numberOfButton, String name, String surname, String metro, String address, String phone, String date, String period, String colour, String text){
        this.numberOfButton = numberOfButton;
        this.name = name;
        this.surname = surname;
        this.metro = metro;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.colour = colour;
        this.text = text;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData(){
        return new Object[][]{
                {0, "Динар", "Мубар", "Сокольники", "Елабуга", "89178715095", "12.12.2022", "сутки", "grey", "Захвати пива 2 литра"},
                {1, "Ваагн", "Вовк", "Динамо", "Москва", "89503109515", "25.03.2023", "пятеро суток", "black", "И ещё 2 литра для Ваагна"},
        };
    }

    @Before
    public void setUpChrome() {
        driver = new ChromeDriver();// для проверки в хроме
        //driver = new FirefoxDriver();// для проверки в фаерфоксе
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
        @Test
        public void orderScooter(){
            MainPage mainPage = new MainPage(driver);
            OrderPage orderPage = new OrderPage(driver);

            mainPage.open();
            mainPage.clickOrderButton(numberOfButton);
            orderPage.inputName(name);
            orderPage.inputSurname(surname);
            orderPage.inputAddress(address);
            orderPage.selectMetroStation(metro);
            orderPage.inputPhoneNumber(phone);
            orderPage.clickDalee();
            orderPage.selectDeliveryDate(date);
            orderPage.selectRentalPeriod(period);
            orderPage.clickColourOfScooter(colour);
            orderPage.inputComment(text);
            orderPage.clickFinalOrderButton();
            orderPage.clickYesButton();
            orderPage.checkOrderIsAccepted();
        }

     @After
    public void tearDown(){
        driver.quit();
    }
}