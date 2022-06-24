package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la página web que se van a utilizar
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(name="search_query")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	@FindBy(linkText="Contact us") 
	WebElement lnkContactUs;
	
	// Constructor: inicializar la página a utilizar
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer sobre los elementos de la página web
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabraABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
