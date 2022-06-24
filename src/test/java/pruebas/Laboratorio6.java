package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContactUs;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio6 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo@micorreo.com");
		login.escribirContrasenia("1q2w3e4r5t");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@Test
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
		
		PaginaContactUs contactUs = new PaginaContactUs(driver);
		contactUs.seleccionarSubject("Webmaster");
		contactUs.escribirEmail("correo@micorreo.com");
		contactUs.escribirOrder("2C");
		contactUs.adjuntarArchivo("C:\\addIntegerData.txt");
		contactUs.escribirMensaje("Comentarios del contacto");
		contactUs.hacerClicEnSend();
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
