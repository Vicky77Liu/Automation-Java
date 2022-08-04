import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.List;

public class test {
    public WebDriver driver;
    @Test
    public void  test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kurt/Desktop/study/seleniumTest/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.imooc.com");
        WebElement element = driver.findElement(By.className("menuContent"));
        WebElement front = element.findElements(By.className("item")).get(0);
        System.out.println(front.getText());
        Actions action = new Actions(driver);
        action.moveToElement(front).perform();
        Thread.sleep(2000);

    }

}
