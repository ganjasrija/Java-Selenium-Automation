
package raju;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Open website
            driver.get("https://the-internet.herokuapp.com/windows");

            Thread.sleep(2000);

            // Get Parent Window ID
            String parentWindow = driver.getWindowHandle();

            // Click Click Here link
            driver.findElement(By.linkText("Click Here")).click();

            Thread.sleep(2000);

            // Get all Window IDs
            Set<String> allWindows = driver.getWindowHandles();

            // Switch to Child Window
            for (String window : allWindows) {

                if (!window.equals(parentWindow)) {

                    driver.switchTo().window(window);

                    System.out.println("Child Window Title: "
                            + driver.getTitle());

                    // Close Child Window
                    driver.close();

                    break;
                }
            }

            // Switch back to Parent Window
            driver.switchTo().window(parentWindow);

            System.out.println("Parent Window Title: "
                    + driver.getTitle());

        } finally {
            driver.quit();
        }
    }
}
