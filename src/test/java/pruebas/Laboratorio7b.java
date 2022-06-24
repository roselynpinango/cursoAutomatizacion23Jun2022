package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;

public class Laboratorio7b {
	WebDriver driver;
	String url = "http://automationpractice.com/";
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup(); // se auto-configura el driver necesario para la ejecución
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("skirt");
		inicio.hacerClicEnBuscar();
	}
}
