
package raju;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            // Find an element using its name attribute
            WebElement searchBox = driver.findElement(By.name("q"));

            // Enter text
            searchBox.sendKeys("Selenium Java");

            // Read the entered value
            System.out.println(searchBox.getAttribute("value"));

            // Clear the textbox
            searchBox.clear();

            // Enter text again
            searchBox.sendKeys("Java Automation");

            // Check element properties
            System.out.println("Displayed: " + searchBox.isDisplayed());
            System.out.println("Enabled: " + searchBox.isEnabled());

            Thread.sleep(3000);

        } finally {
            driver.quit();
        }
    }
}
