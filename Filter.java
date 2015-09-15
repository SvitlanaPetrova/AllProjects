package rozetka;

/**
 * Created by Svetik on 05.07.2015.
 */

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter extends Page {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public Filter(WebDriver driver) {
        super(driver);
    }

    private WebElement[] producer = new WebElement[11];

    public void setProducer() {
        for (int i = 0; i < producer.length; i++) {
            producer[i] = _driver.findElement(By.xpath(".//*[@id='sort_producer']/li[" + (i + 1) + "]/label/a/span"));
        }
    }

    public WebElement getProducer(int i) {
        return producer[i];
    }

    public String[] getAmountProducer(WebElement[] producer) {
        String[] temp = new String[100];
        for (int i = 0; i < producer.length; i++) {
            temp[i] = producer[i].getText().split(" ")[1];
        }
        return temp;
    }

    public String getProducerAmount(String producerName) {
        String element = "";
        boolean key = false;
        int i = 0;
        while (!key){
            if (producer[i].getText().indexOf(producerName) != -1) {
                element = producer[i].getText().split(" ")[1];
            }
            i++;
        }
        return element;
    }

    public void chooseProducer(String chsnProducer) {
        boolean key = false;
        int i = 0;
        while (!key) {
            if (producer[i].getText().indexOf(chsnProducer) != -1) {
                producer[i].click();
                key = true;
            }
            i++;
        }

    }

    public void checkAmount(String amount) {
        WebElement countTitle = _driver.findElement(By.xpath(".//*[@id='title_page']/div/div/div[3]/ul/li[3]"));
        Pattern pattern = Pattern.compile("[0-9]");
        System.out.println(amount + countTitle.getText());
        Matcher matcher = pattern.matcher(amount);
        if (matcher.matches()) {
            if (countTitle.getText().indexOf(matcher.group()) != -1) {
                System.out.println("Amount is right!");
            } else {
                System.out.println("Amount is wrong!");
            }
        }
    }

    private boolean isElementPresent(By by) {
        try {
            _driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void countAmount(String producerName) {
        boolean key = false;
        int i = 0;
        int amountOfNotebook = 0;
        int amountOfPages = 2;
        int errors = 0;
        while (!key) {

            if (isElementPresent(By.xpath(".//*[@id='block_with_goods']/div[1]/div[" + (i + 3) + "]/div[1]"))) {
                //System.out.println(amountOfNotebook + " -- HERE " + i + "    " + _driver.findElement(By.xpath(".//*[@id='block_with_goods']/div[1]/div[" + (i + 3) + "]/div[1]")).getText());
                if (_driver.findElement(By.xpath(".//*[@id='block_with_goods']/div[1]/div[" + (i + 3) + "]/div[1]")).getText().indexOf(producerName) != -1) {
                    amountOfNotebook++;
                } else {
                    errors++;
                    System.out.println("WARNING! Found not " + producerName + "'s notebook(or advertising)! ");
                    System.out.println("Page: " + (amountOfPages - 1) + " Product's number: " + (amountOfNotebook + 1));
                }
                i++;
            } else {
                if (isElementPresent(By.xpath(".//*[@id='page" + amountOfPages + "']/a"))) {
                    _driver.findElement(By.xpath(".//*[@id='page" + amountOfPages + "']/a")).click();
                    amountOfPages++;
                    i = 0;
                } else {
                    System.out.println("<<<<< Summary >>>>>");
                    System.out.println("Amount of " + producerName + "'s notebooks = " + amountOfNotebook);
                    System.out.println("Amount of not "+producerName+"'s notebooks(or advertising): "+errors);
                    key = true;
                }
            }

        }
        System.out.println("Proposed amount: " + _driver.findElement(By.xpath(".//*[@id='title_page']/div/div/div[3]/ul/li[3]")).getText().split(" ")[1]);
        if (_driver.findElement(By.xpath(".//*[@id='title_page']/div/div/div[3]/ul/li[3]")).getText().split(" ")[1].indexOf(Integer.toString(amountOfNotebook)) != -1){
            System.out.println(ANSI_GREEN + "Test passed!"+ANSI_YELLOW);
            System.out.println("So that error was advertising :D");
        }
        else {
            System.out.println(ANSI_RED+"Test failed!");
        }
    }
}


