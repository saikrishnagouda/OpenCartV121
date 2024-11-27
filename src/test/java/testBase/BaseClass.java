package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void Setup(String os,String br) throws IOException
	{
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		//Remote environment grid
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			//Remote environment
			if(os.equalsIgnoreCase("Windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching operating system..");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome");break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			case "firefox": cap.setBrowserName("firefox");break;
			default :System.out.println("no matching browser");return;
		    }
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
			//local environment
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(br.toLowerCase())
				{
				case "chrome":driver=new ChromeDriver();break;
				case "edge":driver=new EdgeDriver();break;
				default:System.out.println("Invalid Browser....");return;
				}
			}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString()
	   {
		  String generatedString= RandomStringUtils.randomAlphabetic(5);
		  return generatedString;	   
	   }
	   public String Numeric()
	   {
		   String generatedNumber=RandomStringUtils.randomNumeric(8);
		   return generatedNumber;
	   }
	   public String Alphanumeric()
	   {
		   String generatedString= RandomStringUtils.randomAlphabetic(5);
		   String generatedNumber=RandomStringUtils.randomNumeric(8);
		   return generatedString+"@"+generatedNumber;
	   }
	   
	   public String captureScreen(String tname)
	   {
		   String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		   
		   TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		   File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		   
		   String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp +".png";
		   File targetFile=new File(targetFilePath);
		   
		   sourceFile.renameTo(targetFile);
		   
		return targetFilePath;
		   
	   }

}