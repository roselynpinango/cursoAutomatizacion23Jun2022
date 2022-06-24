package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContactUs {
	@FindBy(id="id_contact")
	WebElement selSubject;
	
	@FindBy(name="from")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='id_order']")
	WebElement txtOrder;
	
	@FindBy(css="#fileUpload")
	WebElement filAttach;
	
	@FindBy(id="message")
	WebElement txtMessage;
	
	@FindBy(xpath="//button[@id='submitMessage']")
	WebElement btnSend;
	
	public PaginaContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void seleccionarSubject(String textoVisible) {
		Select subject = new Select(selSubject);
		subject.selectByVisibleText(textoVisible);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrder(String order) {
		txtOrder.sendKeys(order);
	}
	
	public void adjuntarArchivo(String rutaArchivo) {
		filAttach.sendKeys(rutaArchivo);
	}
	
	public void escribirMensaje(String message) {
		txtMessage.sendKeys(message);
	}
	
	public void hacerClicEnSend() {
		btnSend.click();
	}
}
