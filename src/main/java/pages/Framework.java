package pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;
public class Framework {
	public static void mouseOver(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).build().perform();
	}
	
	public static void click(WebElement ele)
	{
		ele.click();
	}
	public static void selectElement(WebElement ele, String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	public static Properties readPropertyFile(String path) throws IOException
	{
		 Properties prop;
		 FileInputStream f;
	
		f=new FileInputStream(new File(path));
		prop=new Properties();
		prop.load(f);
		return prop;
		}
	  // The following method will give all the options in a dropdown
	  public static void getAlldropDownOptions(WebElement element)
	  {
		Select select= new Select(element);
		List<WebElement> allValue=select.getOptions();
		allValue.size();
		select.getFirstSelectedOption();
		
		for(int i=0;i<=allValue.size();i++) {
			 System.out.println(allValue.get(i).getText());
			 //Or
			 System.out.println(allValue.get(i).getAttribute("2011"));
			 //Or
			 System.out.println(allValue.get(i).getSize());
		}
       }
	    public static void dragAndDrop(WebDriver driver, WebElement sourceEle, WebElement targetEle) 
	   {
	  		Actions a= new Actions(driver);
	  		a.dragAndDrop(sourceEle, targetEle).build().perform();
	    }  
	   //this following method will perform right click

		public static void performRightClick(WebDriver driver, WebElement element) 
		{
			Actions a=new Actions(driver);
			a.contextClick(element).build().perform();
		}
		public static void alertHandling(WebDriver driver) {
			Alert a=driver.switchTo().alert();
			System.out.println(a.getText());
			
			if(a.getText().equals("Please enter a valid username")) 
			{
				System.out.println("Correct alert message");
			}
			else {
				System.out.println("incorrect alert message");
			}
			a.accept(); 
			
//			a.dismiss(); 
//			
//			a.sendKeys("md  ossain"); 
//
//	        a.getText();    
	     }
		public static void getWindowHandle(WebDriver driver) 
		{
			String currentTab=driver.getWindowHandle();
			System.out.println(driver.getTitle());
			System.out.println(currentTab);
		}
	    public static void getWindowHandles(WebDriver driver){	Set<String>allWindows=driver.getWindowHandles();
		ArrayList<String> tabs=new ArrayList<String>(allWindows);
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle());
		}
	    
	    public static void scroll (WebDriver driver,WebElement element)
	    {
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
		}
	    
		
		// this method can be used to get all the cookies
		public static Cookie[] getAllCookies(WebDriver driver)
		{		
			Set <Cookie> allCookie =driver.manage().getCookies();
			int sizeOfCookies=allCookie.size();
			
		// in following line we are converting Set into an Cookie type array  
			Cookie c[]=new Cookie[sizeOfCookies];
			int i=0;

			for(Cookie cookie:allCookie) {
				c[i]=cookie;
				i++;	
			}
			return c;
		}
		//this method can be used to delete all the cookies 
		public static void deleteAllCookies(WebDriver driver) 
		{
			driver.manage().deleteAllCookies();
		}		
		//this method can be used to delete a specific cookies
		public void deleteSpecificCookie(WebDriver driver) {
			Set <Cookie> allCookie =driver.manage().getCookies();
			for (Cookie cookie : allCookie) {
				String cookieName=cookie.getName();
				System.out.println(cookieName);
				
		if(cookieName.equals("give a cookie name here")) {
				driver.manage().deleteCookieNamed("give a cookie name here");
				}
			}
		}
		public static void getScreenShot(WebDriver driver) throws IOException
		{

			 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			 File file=new File("path of the folder where the screenshot will be stored");
			 Files.copy(f, file);	
		}
}
