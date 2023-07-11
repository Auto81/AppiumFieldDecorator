package org.example.pageObjects.widgets;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LargeContentWidget extends Widget {
    protected LargeContentWidget(WebElement element) {
        super(element);
//        PageFactory.initElements(new AppiumFieldDecorator(element), this);
    }

    @FindBy(xpath = ".//p")
    WebElement paragraph;

    public String getParagraphText() {
        return paragraph.getText();
    }
}
