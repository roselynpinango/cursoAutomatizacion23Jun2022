package Edit.EducacionIT26Mayo2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	
	@Test
	public void registrarUsuario() {
		// 1) Indicar donde esta el driver
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Ejecución en incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		/*
		 * Otros argumentos
		 * 		start-maximized
		 * 		disable-infobars
		 * 		headless
		 * 		version
		 * */
		
		// 2) Abrir el navegador en la página que vamos a probar
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to(url); // Hace lo mismo que driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // borrar las cookies
		
		// 3) Escribir el correo y hacer en el clic
		driver.findElement(By.name("email_create")).sendKeys("correo" + Math.random() + "@micorreo.com");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		
		// 4) Completar el formulario
		driver.findElement(By.id("id_gender2")).click();
		
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Luz");
		driver.findElement(By.id("customer_lastname")).sendKeys("Torres");
		
		driver.findElement(By.name("passwd")).sendKeys("1q2w3e4r5t");
		
		Select days = new Select(driver.findElement(By.name("days")));
		days.selectByValue("18");
		
		Select months = new Select(driver.findElement(By.cssSelector("#months")));
		months.selectByVisibleText("June ");
		
		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByIndex(30);
		
		driver.findElement(By.cssSelector("#newsletter")).click();
		driver.findElement(By.id("optin")).click();
		
		driver.findElement(By.name("company")).sendKeys("ABC C.A.");
		driver.findElement(By.cssSelector("#address1")).sendKeys("MiCalle 123 4B");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Entre calles A y B");
		driver.findElement(By.id("city")).sendKeys("Miami");
		
		Select states = new Select(driver.findElement(By.name("id_state")));
		states.selectByVisibleText("California");
		
		/* 
		 * Otra forma de invocar a la lista es haciendo clics
				driver.findElement(By.name("id_state")).click(); // abriendo la lista 
				driver.findElement(By.xpath("//option[contains(text(),'California')]")).click();
		*/
		driver.findElement(By.cssSelector("#postcode")).sendKeys("90210");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Comentarios");
		driver.findElement(By.id("phone")).sendKeys("35456545667");
		driver.findElement(By.name("phone_mobile")).sendKeys("4565456545");
		
		WebElement txtAlias = driver.findElement(By.name("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Casa");
		
		// 5) Hacer clic en el botón Register
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}
	
}
