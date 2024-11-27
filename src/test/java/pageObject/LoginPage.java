package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement ClickLogin;
	
	public void Email(String email)
	{
		txtemail.sendKeys(email);
	}
	public void password(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void Login()
	{
		ClickLogin.click();
	}

}
