package paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAlerta {
	// Elementos
	@FindBy(id="alertButton")
	WebElement btnNotificacion;
	
	@FindBy(css="#timerAlertButton")
	WebElement btnEspera;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	WebElement btnConfirmacion;
	
	@FindBy(id="promtButton")
	WebElement btnEscribir;
	
	WebDriver driver;
	
	// Constructor
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	// Acciones
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnEspera() {
		btnEspera.click();
	}
	
	public void hacerClicEnConfirmacion() {
		btnConfirmacion.click();
	}
	
	public void hacerClicEnEscribir() {
		btnEscribir.click();
	}
	
	public Alert obtenerAlerta() {
		return driver.switchTo().alert();
	}
	
	public void aceptarEnlaAlerta() {
		obtenerAlerta().accept();
	}
	
	public void cancelarEnlaAlerta() {
		obtenerAlerta().dismiss();
	}
	
	public void escribirEnLaAlerta(String palabra) {
		obtenerAlerta().sendKeys(palabra);
	}
	
	public String obtenerTextoAlerta() {
		return obtenerAlerta().getText();
	}
}
