package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// ============================ Objects ======================================

	@FindBy(name = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(name = "login-button")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='error-message-container error']/h3")
	WebElement errorMsg;

	// ============================ Methods =======================================

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		// PageFactory.initElements(driver, ObjectPage.class);
		PageFactory.initElements(driver, this);
	}

	public void LoginFunction(String UserNameVal, String PwdVal) {

		userName.sendKeys(UserNameVal);
		password.sendKeys(PwdVal);
		loginBtn.click();

	}

	public String getErrorMsg() {

		return errorMsg.getText();
	}

}
