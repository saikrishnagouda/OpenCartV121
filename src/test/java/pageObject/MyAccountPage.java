package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgconfirmation;

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement ClickLogout;
	
	public boolean getmsgconfirmation()
	{
		try {
			return(msgconfirmation.isDisplayed());
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public void Logout()
	{
		ClickLogout.click();
	}
}
