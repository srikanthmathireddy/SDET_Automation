package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Results
{

    WebDriver driver;
    public Results(WebDriver driver)
    {
       this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@data-content=\"2023\"]")
    public static WebElement Year_2023;

    @FindBy(xpath="//*[contains(text(),'Las Vegas Grand Prix')]")
    public static WebElement Las_Vegas_GrandPrix_2023;

    @FindBy(xpath="//*[contains(text(),'Abu Dhabi Grand Prix')]")
    public static WebElement Abu_Dhabi_GrandPrix_2023;

    @FindBy(xpath="//*[@id=\"main-data\"]/div/div/div/section[2]/div/div/div[1]/div/div/table/tbody/tr[1]/td[2]/div/div/div[1]/span[1]")
    public static WebElement First_Place;

    @FindBy(xpath="//*[@id=\"main-data\"]/div/div/div/section[2]/div/div/div[1]/div/div/table/tbody/tr[2]/td[2]/div/div/div[1]/span[1]")
    public static WebElement Second_Place;

    @FindBy(xpath="//*[@id=\"main-data\"]/div/div/div/section[2]/div/div/div[1]/div/div/table/tbody/tr[3]/td[2]/div/div/div[1]/span[1]")
    public static WebElement Third_Place;

    @FindBy(xpath="//*[@id=\"global-navigation\"]/div[4]/div[2]/a")
    public static WebElement search;
    @FindBy(xpath="//*[@id=\"main-content\"]/div/div/div[1]/input")
    public static WebElement search_results;

    @FindBy(xpath="//*[@id=\"main-content\"]/div/div/div[1]/button[2]")
    public static WebElement search_results_icon;

    @FindBy(xpath="//*[@id=\"view-offer\"]/div[2]/article/button")
    public static WebElement Close_Ad;

    @FindBy(xpath="//*[@id=\"checkout-container\"]/iframe")
    public static WebElement iframe;
}
