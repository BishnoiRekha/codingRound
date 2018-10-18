package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

//import static Pages.Driver.driver;

public class FlightBookingPage extends BasePage {

    @FindBy(id = "OneWay")
    public WebElement oneWayRadioButton;

    @FindBy(id = "FromTag")
    private WebElement sourceEditBox;

    @FindBy(id = "ToTag")
    private WebElement destinantionEditBox;

    @FindBy(id = "SearchBtn")
    private WebElement searchButton;

    @FindBy(className = "SearchSummary")
    private WebElement searchSummary;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
    private WebElement datepicker;

    @FindBy(id="DepartDate")
    private WebElement date;


    public FlightBookingPage(WebDriver driver)
    {
        super(driver);
    }




    public void click_OneWay()
    {
        WebElement elem=oneWayRadioButton;
        System.out.println("x is "+elem.isDisplayed());
        wrapper.click(oneWayRadioButton);
    }

    public void enter_source(String source)
    {
        wrapper.enterValue(sourceEditBox,source,true);
       wrapper.waitForElemPresence(By.id("ui-id-1"));
     //   List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
     //   wrapper.click(originOptions.get(0));
    }

    public void enter_destination(String destination)
    {
        wrapper.enterValue(destinantionEditBox,destination,true);
        wrapper.waitForElemPresence(By.id("ui-id-2"));
     //   List<WebElement> originOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
       // wrapper.click(originOptions.get(0));
    }

    public void click_date()
    {
        wrapper.click(date);
        wrapper.click(datepicker);
    }

    public void click_search()
    {
        wrapper.click(searchButton);
    }

    public void validate_isDisplayedSearchResults(){
        wrapper.waitForPageToLoad();
        Assert.assertTrue(wrapper.isElementPresent(By.className("searchSummary")));

    }
}
