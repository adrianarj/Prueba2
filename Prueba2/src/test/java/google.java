import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class google {
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver(); //instancia
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@After
	public void tearDown() throws Exception {
			driver.quit();
			
	}

	@Test
	public void test() {
		WebElement searchBox = driver.findElement(By.name("q")); //localizador by name
		searchBox.clear();
		searchBox.sendKeys("test automation university");
		searchBox.submit();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("test automation university - Buscar con Google",driver.getTitle());
		}
		
	}


