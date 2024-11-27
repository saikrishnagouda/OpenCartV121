package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{	
	@Test(groups= {"Regression","Master"})
	public void AccountRegistration()
	{
		logger.info("*****  Starting TC001_AccountRegistrationTest *****");
		HomePage hp=new HomePage(driver);
		hp.MyAccount();
		logger.info("*** Clicking MyAccount...");
		hp.Register();
		logger.info("*** Clicking Register...");
		
		logger.info("***** Providing Customer Details....");
		AccountRegistrationPage reg=new AccountRegistrationPage(driver);
		reg.FirstName(randomeString().toLowerCase());
		reg.LastName(randomeString().toLowerCase());
		reg.Email(randomeString()+"@gmail.com");
		reg.Telephone(Numeric());
		
		String pwd=Alphanumeric();
		
		reg.password(pwd);
		reg.ConfirmPassword(pwd);
		reg.Policy();
		reg.Continue();
		
		logger.info("**** Validating Expected Message...****");
		String confrmMsg=reg.getConformationMsg();
		Assert.assertEquals(confrmMsg, "Your Account Has Been Created!");
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	   
	   

}
