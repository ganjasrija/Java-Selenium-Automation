package raju;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSAttributeSelectors {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            // 1. Attribute exists
            WebElement search1 =
                    driver.findElement(By.cssSelector("[name]"));

            // 2. Exact value
            WebElement search2 =
                    driver.findElement(By.cssSelector("[name='q']"));

            // 3. Starts with
            WebElement search3 =
                    driver.findElement(By.cssSelector("[name^='q']"));

            // 4. Ends with
            WebElement search4 =
                    driver.findElement(By.cssSelector("[name$='q']"));

            // 5. Contains
            WebElement search5 =
                    driver.findElement(By.cssSelector("[name*='q']"));

            System.out.println("Attribute exists: " + search1.isDisplayed());
            System.out.println("Exact value: " + search2.isDisplayed());
            System.out.println("Starts with: " + search3.isDisplayed());
            System.out.println("Ends with: " + search4.isDisplayed());
            System.out.println("Contains: " + search5.isDisplayed());

            // Type text into the search box
            search2.sendKeys("Selenium Automation");

            Thread.sleep(5000);

            search2.clear();

            Thread.sleep(2000);

        } finally {
            driver.quit();
        }
    }
}