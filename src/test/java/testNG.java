import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class testNG {
    private String systemUnderTestURL = "https://lemonadefashion.com/";

    @Test
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(systemUnderTestURL);
    }

    @Test
    public void navigate() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(systemUnderTestURL + "women/all");
    }

    @Test
    public void findPElements() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get(systemUnderTestURL);
            List<WebElement> elements = webDriver.findElements(By.tagName("p"));
            for (WebElement element : elements) {
                System.out.println("Paragraph text:" + element.getText());
            }
        } finally {
            webDriver.quit();
        }
    }
}
