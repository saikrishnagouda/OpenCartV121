package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfrmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement ClickPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ClickContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConfirmationMsg;
	
	public void FirstName(String Fname)
	{
		txt_FirstName.sendKeys(Fname);
	}
	public void LastName(String Lname)
	{
		txt_LastName.sendKeys(Lname);
	}
	public void Email(String Email)
	{
		txt_Email.sendKeys(Email);
	}
	public void Telephone(String number)
	{
		telphone.sendKeys(number);
	}
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void ConfirmPassword(String pwd)
	{
		cnfrmPwd.sendKeys(pwd);
	}
	public void Policy()
	{
		ClickPolicy.click();
	}
	public void Continue()
	{
		ClickContinue.click();
	}
	public String getConformationMsg()
	{
		try {
		return(ConfirmationMsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

}
