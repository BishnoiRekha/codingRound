package Tests;
import Pages.Driver;
import Pages.FlightBookingPage;
import Pages.HotelBookingPage;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class CodingTest {


    @Test
    public void testThatResultsAppearForAOneWayJourney() {
        WebDriver driver=Driver.getDriver();
        FlightBookingPage flightBookingPage=PageFactory.initElements(driver,FlightBookingPage.class);
        flightBookingPage.loadPage("https://www.cleartrip.com");
        flightBookingPage.click_OneWay();
        flightBookingPage.enter_source("Bangalore");
        flightBookingPage.enter_destination("Delhi");
        flightBookingPage.click_date();
        flightBookingPage.click_search();
        flightBookingPage.validate_isDisplayedSearchResults();
        flightBookingPage.closeBrowser();
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        WebDriver driver=Driver.getDriver();
        HotelBookingPage hotelBookingPage=PageFactory.initElements(driver,HotelBookingPage.class);
        hotelBookingPage.loadPage("https://www.cleartrip.com");
        hotelBookingPage.click_hotelLink();
        hotelBookingPage.enter_locality("Indiranagar, Bangalore");
        hotelBookingPage.select_travellers("1 room, 2 adults");
        hotelBookingPage.search_hotel();
        hotelBookingPage.validate_hotelResults();
        hotelBookingPage.closeBrowser();
    }

    @Test(groups = "SignIn")
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        WebDriver driver=Driver.getDriver();
        SignInPage signInPage=PageFactory.initElements(driver,SignInPage.class);
        signInPage.loadPage("https://www.cleartrip.com");
        signInPage.click_yourTrips();
        signInPage.click_signInLink();
        signInPage.click_signInButton();
        signInPage.validate_errorText();

    }

}