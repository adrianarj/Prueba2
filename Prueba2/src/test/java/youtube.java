import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class youtube {
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver(); //instancia
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		WebElement searchBox = driver.findElement(By.name("search_query")); //localizador by name
		searchBox.clear();
		searchBox.sendKeys("mi vida");
		searchBox.submit();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("mi vida - YouTube",driver.getTitle());
	}

}
