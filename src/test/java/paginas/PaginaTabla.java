package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaTabla {
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement celda2;
	
	@FindBy(xpath="//tbody/tr[2]/td[1]")
	WebElement celda4;
	
	@FindBy(xpath="//tbody/tr[4]/td[3]")
	WebElement celda8;
	
	public PaginaTabla(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String consultarCelda2() {
		return celda2.getText();
	}
	
	public String consultarCelda4() {
		return celda4.getText();
	}
	
	public String consultarCelda8() {
		return celda8.getText();
	}
}
