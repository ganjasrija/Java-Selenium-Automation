package raju;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitExample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Open website
            driver.get("https://the-internet.herokuapp.com/login");

            // Create Fluent Wait
            FluentWait<WebDriver> wait =
                    new FluentWait<>(driver)

                            // Maximum wait time
                            .withTimeout(Duration.ofSeconds(15))

                            // Check every 500 milliseconds
                            .pollingEvery(Duration.ofMillis(500))

                            // Ignore exception
                            .ignoring(NoSuchElementException.class);

            // Wait for username field
            WebElement username =
                    wait.until(d -> {

                        WebElement element =
                                d.findElement(By.id("username"));

                        if (element.isDisplayed()) {
                            return element;
                        }

                        return null;
                    });

            // Enter username
            username.sendKeys("tomsmith");

            // Enter password
            driver.findElement(By.id("password"))
                    .sendKeys("SuperSecretPassword!");

            // Click login
            driver.findElement(
                    By.cssSelector("button[type='submit']")
            ).click();

            System.out.println("Fluent Wait login completed");

        } finally {
            driver.quit();
        }
    }
}