package raju;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Open login website
            driver.get("https://the-internet.herokuapp.com/login");

            // Create Explicit Wait
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for username field
            WebElement username =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("username")
                    ));

            username.sendKeys("tomsmith");

            // Wait for password field
            WebElement password =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("password")
                    ));

            password.sendKeys("SuperSecretPassword!");

            // Wait until login button is clickable
            WebElement loginButton =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.cssSelector("button[type='submit']")
                    ));

            loginButton.click();

            // Wait for success message
            WebElement message =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.id("flash")
                    ));

            System.out.println("Message: " + message.getText());

        } finally {
            driver.quit();
        }
    }
}