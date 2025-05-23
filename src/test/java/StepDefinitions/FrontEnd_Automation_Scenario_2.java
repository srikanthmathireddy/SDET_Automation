package StepDefinitions;

import Page_Objects.Login;
import Page_Objects.Results;
import Utils.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.*;
import Utils.CommonUtil;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class FrontEnd_Automation_Scenario_2
{
    WebDriver driver;
    public ExtentTest test;
    CommonUtil CommonUtil;
    public ExtentReports report;
    public Results Results;
    @Given("I am on the BBC Sport search page")
    public void i_am_on_the_bbc_sport_search_page()
    {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        Results=new Results(driver);
        driver.get("https://www.bbc.com/sport");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String timestamp = new SimpleDateFormat("YYY.MM.dd.hh.mm.ss").format(new Date());
        report = new ExtentReports("ExtentReports/Assessment1_" + timestamp + ".html", false);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test=report.startTest("Assessment_2");
        CommonUtil=new CommonUtil(driver);

    }

    @When("I search for \"Sport in 2023\"")
    public void i_search_for() throws InterruptedException
    {
        Results.search.click();
        Results.search_results.sendKeys("Sport in 2023");
        Results.search_results_icon.click();
        test.log(LogStatus.PASS,"Search Results",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
      //  Thread.sleep(5000);
      //  driver.switchTo().frame(Results.iframe);
      //  Results.Close_Ad.click();


//        Set<String> allWindowHandles = driver.getWindowHandles();
//        for (String windowHandle : allWindowHandles)
//        {
//            //if (!windowHandle.equals(parentWindowHandle))
//            {
//                driver.switchTo().window(windowHandle); // Switch to the ad window
//                driver.close(); // Close the ad window
//                break; // Assuming only one ad window to close
//            }
//        }


        //Results.Close_Ad.click();

       // Results.search_results_icon.click();
    }

    @Then("I should see at least 4 relevant results")
    public void i_should_see_at_least_4_relevant_results()
    {
        report.endTest(test);
        report.flush();
    }

}
