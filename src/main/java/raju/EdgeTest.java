
package raju;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Microsoft Edge...");

        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://maya.adityauniversity.in/");

            driver.manage().window().maximize();

            System.out.println("Website opened successfully!");
            System.out.println("Page title: " + driver.getTitle());

            Thread.sleep(5000);

        } finally {
            driver.quit();
            System.out.println("Browser closed successfully!");
        }
    }
}
