package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Elementos de la página web
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(id="passwd")
	WebElement txtPassword;
	
	@FindBy(name="SubmitLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSignOut;
	
	// Constructor
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirContrasenia(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void completarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void hacerClicEnSignOut() {
		lnkSignOut.click();
	}
}
