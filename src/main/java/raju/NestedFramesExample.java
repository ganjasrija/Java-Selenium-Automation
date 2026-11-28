package raju;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Open website
            driver.get("https://the-internet.herokuapp.com/nested_frames");

            Thread.sleep(3000);

            // Switch to top frame
            driver.switchTo().frame("frame-top");

            Thread.sleep(2000);

            // Switch to left frame
            driver.switchTo().frame("frame-left");

            // Get left frame text
            String text = driver.findElement(By.tagName("body")).getText();

            System.out.println("Left Frame Text: " + text);

            Thread.sleep(2000);

            // Return to parent frame (top)
            driver.switchTo().parentFrame();

            // Switch to middle frame
            driver.switchTo().frame("frame-middle");

            String middleText =
                    driver.findElement(By.id("content")).getText();

            System.out.println("Middle Frame: " + middleText);

            Thread.sleep(2000);

            // Return to main webpage
            driver.switchTo().defaultContent();

        } finally {
            driver.quit();
        }
    }
}