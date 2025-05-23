package StepDefinitions;

import Page_Objects.Login;
import Page_Objects.Results;
import Utils.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.*;
import Utils.CommonUtil;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
public class FrontEnd_Automation_Scenario_1

{
    WebDriver driver;
    public ExtentTest test;
    CommonUtil CommonUtil;
    public ExtentReports report;
    public Results Results;
    @Given("I am on the BBC Sport results page")
    public void navigateToResultsPage()
    {
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        Results=new Results(driver);
        driver.get("https://www.bbc.com/sport/formula1/results");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String timestamp = new SimpleDateFormat("YYY.MM.dd.hh.mm.ss").format(new Date());
        report = new ExtentReports("ExtentReports/Assessment1_" + timestamp + ".html", false);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test=report.startTest("Assessment_1");
        CommonUtil=new CommonUtil(driver);
    }

    @When("I view the results table for the 2023 Las Vegas Grand Prix")
    public void viewLasVegasResultsTable()
    {
        Results.Year_2023.click();
        Results.Las_Vegas_GrandPrix_2023.click();
        Results.Abu_Dhabi_GrandPrix_2023.click();
    }

    @Then("Max Verstappen should be in 1st place")
    public void verifyVerstappenFirst()
    {
        if("Max Verstappen".equalsIgnoreCase(Results.First_Place.getText()))
        {
            test.log(LogStatus.PASS,"Max Verstappen is in 1st Place",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
        }
    }

    @Then("George Russell should be in 2nd place")
    public void verifyRussellSecond()
    {
       if("George Russell".equalsIgnoreCase(Results.Second_Place.getText()))
        {
            test.log(LogStatus.PASS,"George Russell is in 2nd Place",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
        }
        else
        {test.log(LogStatus.FAIL,"George Russell is not in 2nd Place",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
        }
    }

    @Then("Sergio Perez should be in 3rd place")
    public void verifyPerezThird()
    {
        if("Sergio Perez".equalsIgnoreCase(Results.Third_Place.getText()))
        {
            test.log(LogStatus.PASS,"Sergio Perez is in 3rd Place",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
        }
        else
        {test.log(LogStatus.FAIL,"Sergio Perez is not in 3rd Place",test.addBase64ScreenShot(CommonUtil.addScreenshots()));
        }

        report.endTest(test);
        report.flush();
        driver.quit();
    }
}
