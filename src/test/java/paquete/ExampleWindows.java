package paquete;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import paquete.BaseTest;

public class ExampleWindows {
	
	
private WebDriver driver;
	
	public static final String URL_SAHI = "http://sahitest.com/demo/";
	
	By lnkWindowTest = By.linkText("Window Open Test");
	By lnkText = By.linkText("Link Test");
	
	public void irNuevaVentana() throws InterruptedException {
		
		BaseTest abrirVentana = new BaseTest();
		
		abrirVentana.setupBrowser();
		driver = abrirVentana.getDriver();
		driver.get(URL_SAHI);
		
		//Se identifica la primera ventana
		String windowParent = driver.getWindowHandle();	
		System.out.println("Esta es la ventana inicial: " +windowParent);		
		driver.findElement(lnkWindowTest).click();
		
		//Se obtiene todas la ventanas
		Set<String> allWindows = driver.getWindowHandles();
		
		//Se Identifica la segunda ventana
		String segundaVentana = (String) allWindows.toArray()[1];		
		System.out.println("Esta es la segunda ventana: "+segundaVentana);		
		
		//Ir a la segunda ventana
		driver.switchTo().window(segundaVentana);
		
		//Se cierra la segunda ventana
		driver.close();
		
		//Volver a la primera ventana
		driver.switchTo().window(windowParent);
		
		//String paginaInicial = "";		
		//driver.getCurrentUrl(paginaInicial);
		driver.findElement(lnkText).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
		
	
	public static void main (String[] args) throws InterruptedException {
		
		ExampleWindows ventana = new ExampleWindows();
		ventana.irNuevaVentana();	}

}
