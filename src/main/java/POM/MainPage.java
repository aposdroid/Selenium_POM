package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //кнопка "Заказать" в верхнем правом углу:
    private final By orderTopButton = By.xpath(".//div[contains(@class,'Header_Nav')]/button[@class='Button_Button__ra12g']");

    //большая кнопка "Заказать" внизу:
    private final By orderBottomButton = By.xpath(".//div[contains(@class,'Home_FinishButton__1_cWm')]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка "да все привыкли" в уведомлении о куки:
    private final By cookieButton = By.id("rcc-confirm-button");



    //кнопка вопроса "Сколько это стоит? И как оплатить?":
    private final By priceQuestion = By.id("accordion__heading-0");

    //кнопка вопроса "Хочу сразу несколько самокатов! Так можно?":
    private final By amountQuestion = By.id("accordion__heading-1");

    //кнопка вопроса "Как рассчитывается время аренды?":
    private final By timeQuestion = By.id("accordion__heading-2");

    //кнопка вопроса "Можно ли заказать самокат прямо на сегодня?":
    private final By todayQuestion = By.id("accordion__heading-3");

    //кнопка вопроса "Можно ли продлить заказ или вернуть самокат раньше?":
    private final By extendQuestion = By.id("accordion__heading-4");

    //кнопка вопроса "Вы привозите зарядку вместе с самокатом?":
    private final By chargerQuestion = By.id("accordion__heading-5");

    //кнопка вопроса "Можно ли отменить заказ?":
    private final By cancellationQuestion = By.id("accordion__heading-6");

    //кнопка вопроса "Я жизу(тут опечатка) за МКАДом, привезёте?":
    private final By mkadQuestion = By.id("accordion__heading-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open(){    //открыть сайт Яндекс Самокат:

        driver.get(url);
    }

    public void clickOrderButton (int numberOfButton) { // выбрать кнопку для заказа: 1 - кнопка наверху справа, 2 - кнопка внизу
        if (numberOfButton == 0) {
            driver.findElement(orderTopButton).click();
        } else if (numberOfButton == 1) {
         WebElement element = driver.findElement(By.className("accordion"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
         driver.findElement(orderBottomButton).click();
        }
    }

    public void checkPriceQuestion(){    //кликнуть на вопрос "Сколько это стоит? И как оплатить?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(priceQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",answer);
        System.out.println("Ответ о цене соответствует требованиям.");
    }

    public void checkAmountQuestion(){    //кликнуть на вопрос "Хочу сразу несколько самокатов! Так можно?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(amountQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-1")).getText();
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",answer);
        System.out.println("Ответ о количестве соответствует требованиям.");
    }

    public void checkTimeQuestion(){    //кликнуть на вопрос "Как рассчитывается время аренды?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(timeQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-2")).getText();
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",answer);
        System.out.println("Ответ о расчёте времени соответствует требованиям.");
    }

    public void checkTodayQuestion(){    //кликнуть на вопрос "Можно ли заказать самокат прямо на сегодня?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(todayQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-3")).getText();
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",answer);
        System.out.println("Ответ о заказе сегодня соответствует требованиям.");
    }

    public void checkExtendQuestion(){    //кликнуть на вопрос "Можно ли продлить заказ или вернуть самокат раньше?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(extendQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-4")).getText();
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",answer);
        System.out.println("Ответ о продлении заказа соответствует требованиям.");
}

    public void checkChargerQuestion(){    //кликнуть на вопрос "Вы привозите зарядку вместе с самокатом?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(chargerQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-5")).getText();
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",answer);
        System.out.println("Ответ о зарядке соответствует требованиям.");
    }

    public void checkCancellationQuestion(){    //кликнуть на вопрос "Можно ли отменить заказ?", вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(cancellationQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-6")).getText();
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",answer);
        System.out.println("Ответ об отмене заказа соответствует требованиям.");
    }

    public void checkMkadQuestion(){    //кликнуть на вопрос "Я жизу(тут опечатка) за МКАДом, привезёте?", нажать на уведомление о куки, вытащить текст с открывшегося ответа на вопрос, сравнить с ожидаемым ответом, вывести сообщение в консоль:
        driver.findElement(cookieButton).click();
        driver.findElement(mkadQuestion).click();
        String answer = driver.findElement(By.id("accordion__panel-7")).getText();
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",answer);
        System.out.println("Ответ о заМКАДье соответствует требованиям.");
    }
}