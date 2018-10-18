package Pages;

import Pages.Wrapper;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBookingPage extends BasePage {

  public HotelBookingPage(WebDriver driver)
  {
      super(driver);
  }

    @FindBy(xpath = "//a[@href='/hotels' and contains(@title,'Find hotels')]")
    public WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "SearchHotelsButton")
    private WebElement hotelsList;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;


    public void click_hotelLink() {
        wrapper.click(hotelLink);
    }

    public void enter_locality(String locality) {
        wrapper.enterValue(localityTextBox, locality);
    }

    public void select_travellers(String text) {
        wrapper.selectByVisibleText(travellerSelection, text);
    }
    public void search_hotel() {
        wrapper.click(searchButton);
    }
    public void validate_hotelResults()
    {
        Assert.assertTrue(hotelsList.isDisplayed(),"validate hotels results are displayed");
    }


}