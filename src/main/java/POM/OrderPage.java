package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class OrderPage {

    //поле ввода имени:
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //поле ввода фамилии:
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле ввода адреса:
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле выбора станции метро:
    private final By metroStationField = By.xpath(".//input[@class='select-search__input']");

    //поле ввода номера телефона:
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее":
    private final By daleeButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");



    //поле выбора даты доставки:
    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле выбора срока аренды:
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");

    //поле ввода комментария для курьера:
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //большая кнопка "Заказать" внизу справа:
    private final By finalOrderButton = By.xpath(".//div[contains(@class,'Order_Buttons__1xGrp')]/button[text()='Заказать']");

    //кнопка "Да":
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");

    //Заказ оформлен:
    private final By orderIsAccepted = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    private final WebDriver driver;

    public OrderPage(WebDriver driver){

        this.driver = driver;
    }

    public void inputName(String text){//ввод имени в поле имени
        driver.findElement(nameField).sendKeys(text);
    }

    public void inputSurname(String text){//ввод фамилии
        driver.findElement(surnameField).sendKeys(text);
    }

    public void inputAddress(String text){//ввод адреса
        driver.findElement(addressField).sendKeys(text);
    }

   public void selectMetroStation(String metro){//выбор станции метро
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metro);
        driver.findElement(metroStationField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
   }

    public void inputPhoneNumber(String text){//ввод номера телефона
        driver.findElement(phoneNumberField).sendKeys(text);
    }

    public void clickDalee(){//кликнуть на кнопку "Далее"
        driver.findElement(daleeButton).click();
    }

    public void selectDeliveryDate(String text){//выбор даты доставки
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).sendKeys(text, Keys.ENTER);
    }
    public void selectRentalPeriod(String period){//выбор периода аренды
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='" +period+"']")).click();
    }

    public void clickColourOfScooter(String text){//выбор цвета самоката
        driver.findElement(By.id(text)).click();
    }

    public void inputComment(String text){//ввод комментария для курьера
        driver.findElement(comment).sendKeys(text);
    }

    public void clickFinalOrderButton(){//клик на кнопку "Заказать"
        driver.findElement(finalOrderButton).click();
    }

    public void clickYesButton(){//клик на "Да" в окне подтверждения заказа
        driver.findElement(yesButton).click();
    }

    public void checkOrderIsAccepted(){//удостоверимся, что заказ прошёл
        String textOfAccepted = driver.findElement(orderIsAccepted).getText();
        Assert.assertThat("Ошибка в оформлении заказа", textOfAccepted, startsWith("Заказ оформлен"));
    }
}
