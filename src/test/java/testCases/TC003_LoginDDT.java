package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass - logout
Data is valid  - login failed - test fail

Data is Invalid  - login success - test fail - logout
Data is Invalid  - login fail -test pass
*/

public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")  //getting data provider from different class
	public void verify_loginDDT(String email,String pwd ,String exp)
	{
		logger.info("***** Starting TC003_LoginDDT *****");
		try {
		//HomePage
	    HomePage hp=new HomePage(driver);
		hp.MyAccount();
		hp.Login();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.Email(email);
		lp.password(pwd);
		lp.Login();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetpage=macc.getmsgconfirmation();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				macc.Logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				macc.Logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		 }
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("***** Finished TC003_LoginDDT *****");
		
	}

}
