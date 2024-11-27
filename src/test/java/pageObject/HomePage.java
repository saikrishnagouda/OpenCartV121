package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement ClickMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement ClickRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement ClickLogin;
	
	public void MyAccount()
	{
		ClickMyAccount.click();
	}
	
	public void Register()
	{
		ClickRegister.click();
	}
	
	public void Login()
	{
		ClickLogin.click();
	}

}
