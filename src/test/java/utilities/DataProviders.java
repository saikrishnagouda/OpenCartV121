package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".//testData//Opencart_LoginData.xlsx"; //taking xl file from directory
		
		ExcelUtility xlutil=new ExcelUtility(path);  //creating an object for XLutility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getcellcount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) //1   //read the data from xl storing i
		{
			for(int j=0;j<totalcols;j++) //0   i is row  j is col
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);   //1,0
				
			}
		}
		return logindata;  //returning two dimension array
	
	}

	//DataProvider 2
	
	//DataProvider 3
	
}
