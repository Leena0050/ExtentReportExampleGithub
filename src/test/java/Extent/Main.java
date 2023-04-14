package Extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Google search test one", "Sample description");

        WebDriver driver = new FirefoxDriver();

        // log(Status, details)
        test.log(Status.INFO, "Starting Test Case");
        driver.get("https://www.google.com/");
        test.pass("NAvigated to google.com");

        driver.findElement(By.name("q")).sendKeys("automation");
        test.pass("Entered text in searchbox");

       // driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
       // test.pass("Pressed keyboard - enter key");

        driver.close();
        driver.quit();
        test.pass("Closed the browser");

        test.info("Test completed");

        // calling flush writes everything to the log file
        extent.flush();
    }
}
