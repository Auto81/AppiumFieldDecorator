package org.example.pageObjects;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.pageObjects.widgets.LargeContentWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChallengingDomPage {

    WebDriverWait wait;
    ChromeDriver driver;

    public ChallengingDomPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".example")));

        //This is the line with java-client 8.5.1 that causing problems
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(css = ".example")
    LargeContentWidget content;

    public LargeContentWidget getLargeContentWidget() {
        return content;
    }

    public String getParagraphTextDirectlyAtPageLevel() {
        return driver.findElement(By.cssSelector(".example > p")).getText();
    }
}
