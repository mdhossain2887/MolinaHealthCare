package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage 
{
	WebDriver driver;
	public FirstPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void numberOfLinksInThePage() 
	{
		List<WebElement> elements=driver.findElements(By.tagName("a"));
		System.out.println(elements.size());
	}
	public void numberOfFrames() 
	{
		List<WebElement> frames =driver.findElements(By.tagName("iframe"));
		System.out.println("the number of frames : "+frames);
	}
	public void handleWindow()
	{
		Framework.getWindowHandle(driver);
	}
	public void getCookies()
	{
		Cookie[] cookie=Framework.getAllCookies(driver);
		System.out.println(cookie);
    }
	public void verifyLogo() 
	{
		WebElement ele=driver.findElement(By.xpath(""));
		String logo=ele.getText();
		if(logo.equals("Molina healthcare")) {
			System.out.println("logo is correct");
		}
		else {
			System.out.println("logo is not correct");
		}
	}
	public void mouseOverOnAboutMolina()
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"ctl00_headerUC_globalNavigationMain_ctl05_globalMainMenu\"]"));
		Framework.mouseOver(driver,ele );
	}
	public void clickOnWhyMolina() 
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"s4-bodyContainer\"]/div/div[2]/div[2]/ul/li[6]/div/span/ul/li[1]/a"));
		Framework.click(ele);
	}
	public void clickOnBecomeAMember() 
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"ctl00_headerUC_globalNavigationMain_ctl00_globalMainMenu\"]"));
		Framework.click(ele);
	}
	public void clickOnArrowButton1() 
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderDialogBodyMainSection_stateChangeID_ddlState_msdd\"]/div[1]/span[2]"));
		Framework.click(ele);
	}	
	public void selectCity()
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderDialogBodyMainSection_stateChangeID_ddlState_child\"]/ul/li[9]/span"));
		Framework.selectElement(ele, "New York");
	}	
	public void clickOnArrowButton2()
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderDialogBodyMainSection_stateChangeID_ddlLanguage_msdd\"]/div[1]/span[2]"));
		Framework.click(ele);
	}
	public void selectLanguage()
	{
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"ctl00_PlaceHolderDialogBodyMainSection_stateChangeID_ddlLanguage_child\"]/ul/li[1]"));
		Framework.selectElement(ele, "English");
	}
	public void clickOnSubmit() 
	{
		WebElement ele=driver.findElement(By.xpath(""));
		Framework.click(ele);
	}
}
