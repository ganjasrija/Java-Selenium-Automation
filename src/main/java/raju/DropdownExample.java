package raju;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Open website
            driver.get("https://the-internet.herokuapp.com/");

            Thread.sleep(3000);

            // Click Dropdown link
            driver.findElement(By.xpath("//a[.='Dropdown']")).click();

            Thread.sleep(3000);

            // Locate dropdown
            WebElement dropdown =
                    driver.findElement(By.id("dropdown"));

            // Create Select object
            Select course = new Select(dropdown);

            // Select using visible text
            course.selectByVisibleText("Option 1");
            Thread.sleep(2000);

            // Select using value
            course.selectByValue("2");
            Thread.sleep(2000);

            // Select using index
            course.selectByIndex(1);
            Thread.sleep(2000);

            System.out.println("Dropdown selection completed");

        } finally {
            driver.quit();
        }
    }
}