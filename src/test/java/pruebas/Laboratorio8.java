package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
	String url = "http://automationpractice.com";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirContrasenia(password);
		login.hacerClicEnLogin();
		
		// Si el usuario logra iniciar sesion (Assertion)
		String tituloActual = driver.getTitle();
		String tituloEsperado = "My account - My Store";
		
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		// Tendría que desloguearse antes de que comience la siguiente
		login.hacerClicEnSignOut();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT26Mayo2022\\Datos\\DatosPruebLogin.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "abc@micorreo.com";
		datos[0][1] = "y65urut7i";
		
		datos[1][0] = "def@micorreo.com";
		datos[1][1] = "76u6tru6";
		
		datos[2][0] = "ghi@micorreo.com";
		datos[2][1] = "wesedaewe";
		
		return datos;
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
