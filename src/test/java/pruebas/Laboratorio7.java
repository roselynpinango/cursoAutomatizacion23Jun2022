package pruebas;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaAlerta;

public class Laboratorio7 {
	String url = "https://demoqa.com/alerts";
	String driverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	PaginaAlerta alerta;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		alerta = new PaginaAlerta(driver);
	}
	
	@Test
	public void alertaNotificacion() throws InvalidFormatException, IOException, InterruptedException {
		alerta.hacerClicEnNotificacion(); // Hacer clic en el botón
		
		Thread.sleep(5000); // espera propia de java (no es buen práctica, sólo mientras programas)
		
		System.out.println("Texto de la alerta: " + alerta.obtenerTextoAlerta());
		
		alerta.aceptarEnlaAlerta(); // hacer clic en OK del popup/alerta
	}
	
	@Test
	public void alertaEspera() {
		alerta.hacerClicEnEspera(); // hacer clic en el boton (segundo)
		
		// Esperar que la alerta aparezca
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
		espera.until(ExpectedConditions.alertIsPresent());
		
		alerta.aceptarEnlaAlerta(); // hacer clic en OK del popup/alerta
	}
	
	@Test
	public void alertaConfirmacion() {
		alerta.hacerClicEnConfirmacion(); // hacer clic en el boton (tercero)
		alerta.cancelarEnlaAlerta(); // hacer clic en Cancel del popup/alerta
	}
	
	@Test
	public void alertaEscribir() {
		alerta.hacerClicEnEscribir(); // hacer clic en el boton (cuarto)
		alerta.escribirEnLaAlerta("Clase de Automatización"); // escribe en el campo del popup
		alerta.aceptarEnlaAlerta(); // hacer clic en OK del popup/alerta
	}
}
