package Edit.EducacionIT26Mayo2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio4 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP Ir a Contáctanos", priority=1)
	public void irAContactUs() {
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		// Completar el formulario
		Select list = new Select(driver.findElement(By.id("id_contact")));
		list.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("correo@micorreo.com");
		driver.findElement(By.cssSelector("#id_order")).sendKeys("1A");
		
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.id("message")).sendKeys("Comentarios del Contacto");
		
		driver.findElement(By.name("submitMessage")).click();
	}
	
	@Test(description="CP Buscar Palabra", priority=50)
	public void buscarPalabra() {	
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@AfterSuite
	public void cerrarPantalla() {
		driver.close();
	}
}
