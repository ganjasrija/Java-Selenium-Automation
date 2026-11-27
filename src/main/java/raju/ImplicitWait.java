package raju;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Set Implicit Wait - 10 seconds
            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            // Open login website
            driver.get("https://the-internet.herokuapp.com/login");

            // Enter username
            driver.findElement(By.id("username"))
                    .sendKeys("tomsmith");

            // Enter password
            driver.findElement(By.id("password"))
                    .sendKeys("SuperSecretPassword!");

            // Click login
            driver.findElement(By.cssSelector("button[type='submit']"))
                    .click();

            System.out.println("Login completed");

        } finally {
            driver.quit();
        }
    }
}