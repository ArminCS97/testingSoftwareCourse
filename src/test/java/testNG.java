import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Test
    public void getElemetsUsingDifferentTechniques() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(systemUnderTestURL);

        try {
            WebElement webElement1 = webDriver.findElement(By.id("root"));
            System.out.println(webElement1.getText() + "\n\n");

            WebElement webElement2 = webElement1.findElement(By.xpath("//div//nav"));
            System.out.println(webElement2.getText() + "\n\n");

            WebElement webElement3 = webElement1.findElement(By.xpath("//div//nav//div"));
            webElement3.clear();

            // Element should not be found for this case
            WebElement webElement4 = webElement2.findElement(By.partialLinkText("Man..."));
            System.out.println(webElement4.getText() + "\n\n");

        } catch (Exception exception) {
            System.out.println("Element cannot be found");
        } finally {
            webDriver.quit();
        }
    }

    @Test
    public void sendKeys() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(systemUnderTestURL);
        webDriver.manage().window().maximize();
        try {
            webDriver.findElement(By.xpath("//div//nav")).isEnabled();
        } finally {
            webDriver.quit();
        }
    }
}
