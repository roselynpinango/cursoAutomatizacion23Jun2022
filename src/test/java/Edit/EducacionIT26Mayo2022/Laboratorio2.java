package Edit.EducacionIT26Mayo2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	String url = "http://automationpractice.com/index.php";
	String chromeDriverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT26Mayo2022\\Drivers\\geckodriver.exe";
	
	@Test
	public void hacerBusquedaEnChrome() {
		// Paso 1: Indicar dónde está nuestro driver
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso 2: Abrir el navegador en la página que queremos probar
		WebDriver navegador = new ChromeDriver();
		navegador.get(url);
		navegador.manage().window().maximize(); // Maximizar la ventana del navegador
		navegador.manage().deleteAllCookies(); // Borrar las cookies
		
		System.out.println("Título: " + navegador.getTitle()); // Imprime el título de la página
		System.out.println("URL: " + navegador.getCurrentUrl()); // Imprime la URL actual
		
		// Paso 3: Escribir la palabra a buscar
		WebElement buscador = navegador.findElement(By.id("search_query_top"));
		buscador.sendKeys("skirt");
		
		// Paso 4: Hacer la búsqueda (simulando que presionamos la tecla ENTER)
		buscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		navegador.close();
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		// Paso 1: Indicar dónde está nuestro driver
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		// Paso 2: Abrir el navegador en la página que queremos probar
		WebDriver navegador = new FirefoxDriver();
		navegador.get(url);
		
		// Paso 3: Escribir la palabra a buscar
		WebElement buscador = navegador.findElement(By.id("search_query_top"));
		buscador.sendKeys("skirt");
		
		// Paso 4: Hacer la búsqueda (simulando que presionamos la tecla ENTER)
		buscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		
	}
}
