import org.example.pageObjects.ChallengingDomPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppiumFieldDecoratorTests {

    ChromeDriver driver;
    public static List<ChallengingDomPage> pageList = new ArrayList<>();

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    private void test_contents() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        //Pages inited, time taken in seconds, and a crude average time per POM
        //Not Using Appium Field Decorator (Commented out in ChallengingDomPage)
        //| Iterations | 8.5.0               | 8.5.1               |
        //| 1000       | 10 (10.0ms per POM) | 10 (10.0ms per POM) |
        //| 2000       | 17 (08.5ms per POM) | 17 (08.5ms per POM) |
        //| 3000       | 22 (07.3ms per POM) | 22 (07.3ms per POM) |

        //Pages inited, time taken in seconds, and a crude average time per POM
        //Using Appium Field Decorator
        // | Iterations | 8.5.0               | 8.5.1                |
        // | 1000       | 11 (11.0ms per POM) | 19  (19.0ms per POM) |
        // | 2000       | 17 (08.5ms per POM) | 46  (23.0ms per POM) |
        // | 3000       | 22 (07.3ms per POM) | 106 (35.3ms per POM) |
        // | 4000       | 30 (07.5ms per POM) | 240 (60.0ms per POM) |
        // | 5000       | 38 (07.6ms per POM) | 457 (91.4ms per POM) |
        for (int i = 0; i < 4000; i++)
            pageList.add(new ChallengingDomPage(driver));

        // System.out.println(pageList.get(0).getParagraphTextDirectlyAtPageLevel());
        // System.out.println(pageList.get(0).getLargeContentWidget().getParagraphText());
    }

    @Test
    public void test_1() {
        test_contents();
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}