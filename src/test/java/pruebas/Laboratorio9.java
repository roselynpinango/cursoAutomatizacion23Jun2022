package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaTabla;

public class Laboratorio9 {
	String url = "https://demo.guru99.com/test/table.html";
	WebDriver driver;
	
	@BeforeSuite 
	public void abrirPagina() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void consultarValoresTabla() {
		PaginaTabla tabla = new PaginaTabla(driver);
		
		// Celda con el valor 2: Fila 1, Columna 2
		System.out.println("Fila 1 - Columna 2: " + tabla.consultarCelda2());
		
		// Celda con el valor 4: Fila 2, Columna 1
		System.out.println("Fila 2 - Columna 1: " + tabla.consultarCelda4());
		
		// Celda con el valor 8: Fila 4, Columna 3
		System.out.println("Fila 4 - Columna 3: " + tabla.consultarCelda8());
		
		/*
		String tr = "/tr[3]";
		String td = "/td[1]";
		driver.findElement(By.xpath("//tbody" + tr + td));
		*/
	}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
}
