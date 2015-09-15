package rozetka;

/**
 * Created by Svetik on 05.07.2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/notebooks/c80004/filter/");
        String producerName = "Panasonic";
        Filter rozetkaFilter = PageFactory.initElements(driver, Filter.class);

        rozetkaFilter.setProducer();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        rozetkaFilter.chooseProducer(producerName);
        rozetkaFilter.countAmount(producerName);
    }
}