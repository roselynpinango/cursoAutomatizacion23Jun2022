package Edit.EducacionIT26Mayo2022;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Laboratorio5 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT26Mayo2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	File pantalla;
	String dirEvidencias = "..\\EducacionIT26Mayo2022\\Evidencias\\";
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP Ir a Contáctanos", priority=1)
	public void irAContactUs() throws InvalidFormatException, IOException, InterruptedException {
		String nombreDocumento = "Evidencias - AutomationPractice - " + obtenerFechaActual() + ".docx";
		
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias de Prueba", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Pantalla Principal");
		
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 1 - Luego de hacer clic en Contact us");
		
		// Completar el formulario
		Select list = new Select(driver.findElement(By.id("id_contact")));
		list.selectByVisibleText("Webmaster");
		
		driver.findElement(By.name("from")).sendKeys("correo@micorreo.com");
		driver.findElement(By.cssSelector("#id_order")).sendKeys("1A");
		
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.id("message")).sendKeys("Comentarios del Contacto");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 2 - Luego de completar el formulario");
		
		driver.findElement(By.name("submitMessage")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 3 - Luego de enviar el mensaje de contacto");
	}
	
	@Test(description="CP Buscar Palabra", priority=50)
	public void buscarPalabra() throws IOException {	
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "01_pantalla_principal_" + obtenerFechaActual() + ".jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "02_palabra_a_buscar_" + obtenerFechaActual() + ".jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "03_resultado_obtenido_" + obtenerFechaActual() + ".jpg"));
		
		// Comprobar el resultado esperado
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		String urlActual = driver.getCurrentUrl(); // Devuelve la URL actual de la página
		String tituloActual = driver.getTitle(); // Devuelve el título actual de la página
		
		Assert.assertEquals(urlActual, urlEsperada);
		Assert.assertEquals(tituloActual, tituloEsperado);
	}
	
	@AfterSuite
	public void cerrarPantalla() {
		driver.close();
	}
	
	public static String obtenerFechaActual() {
		Calendar cal = Calendar.getInstance();
		 
        SimpleDateFormat dateOnly = new SimpleDateFormat("yyyyMMddhhmmss");
        
        return dateOnly.format(cal.getTime());
	}
}
