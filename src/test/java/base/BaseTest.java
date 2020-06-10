package base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {

	public WebDriver driver;
	String url="https://www.molinahealthcare.com/members/ny/en-us/Pages/home.aspx";
	@BeforeMethod
	public void openBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(url);
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
