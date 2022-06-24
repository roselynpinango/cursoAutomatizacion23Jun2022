package Edit.EducacionIT26Mayo2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio5b {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT26Mayo2022\\Drivers\\geckodriver.exe"; 
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void abrirPagina(String navegador) {
		if (navegador.equalsIgnoreCase("chrome")) {
			// si la condición se cumple
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else {
			// si la condición no se cumple
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver= new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("skirt");
		
		driver.findElement(By.name("submit_search")).click();
	}
}
