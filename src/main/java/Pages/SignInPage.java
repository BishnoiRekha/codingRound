package Pages;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText ="Your trips")
    private WebElement yourTripsLink;

    @FindBy(id="SignIn")
    private WebElement signInLink;

    @FindBy(id="signInButton")
    private WebElement signInButton;

    @FindBy(id="errors1")
    private WebElement errorsText;

    @FindBy(id="modal_window")
    private WebElement signInWindow;

    public void click_yourTrips()
    {
        wrapper.click(yourTripsLink);
    }

    public void click_signInLink()
    {
        wrapper.click(signInLink);
        wrapper.switchToIFrame(signInWindow);
    }
    public void click_signInButton()
    {
        wrapper.click(signInButton);
    }
    private String get_errorsText()
    {
        return errorsText.getText();
    }
    public void validate_errorText()
    {
        Assert.assertTrue(get_errorsText().contains("There were errors in your submission"));
    }
}
