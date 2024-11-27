package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void Verify_LoginTest()
	{
		logger.info("***** Starting TC002_LoginTest *****");
		try 
		{
		//HomePage
	    HomePage hp=new HomePage(driver);
		hp.MyAccount();
		logger.info("*** Clicking MyAccount...");
		hp.Login();
		logger.info("*** Clicking Login...");
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.Email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.Login();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetpage=macc.getmsgconfirmation();
		Assert.assertTrue(targetpage);
		//Assert.assertEquals(targetpage, true,"Loginfailed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("\"***** Finished TC002_LoginTest *****\"");
	}
	

	

}
