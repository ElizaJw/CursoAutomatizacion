package paquete;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Practice {

	WebDriver driver;

	//Objetos del DOM
	By linkWindowOpen = By.linkText("Window Open Test");
	By lnkConfirmPage = By.linkText("Confirm Page");
	By btnConfirm = By.name("b1");
	By lnkAlertTest = By.linkText("Alert Test");


	/**
	 * Método para ejecutar el ejercicio de la clase
	 * @throws InterruptedException
	 */
	
	@Test
	public void MetodoPractica() throws InterruptedException{

		//Se sube el navegador
		BaseTest test1 = new BaseTest();
		test1.setupBrowser();
		driver = test1.getDriver();
		driver.get(ExampleWindows.URL_SAHI);

		driver.findElement(linkWindowOpen).click();	
		//Se obtiene la primera ventana
		String primeraVenta = driver.getWindowHandle();
		System.out.println("Ventana 1" +primeraVenta);

		//Se obtienen todas las ventanas
		Set<String> allWindows = driver.getWindowHandles();
		String segundaVentana = (String) allWindows.toArray()[1];		
		System.out.println("Esta es la segunda ventana: "+segundaVentana);
		//se navega de una ventana a otra
		driver.switchTo().window(segundaVentana);
		driver.switchTo().frame(0);			
		test1.hacerHighlight(driver, driver.findElement(lnkConfirmPage));
		Thread.sleep(1000);
		driver.findElement(lnkConfirmPage).click();

		driver.findElement(btnConfirm).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		//Se cierra la segunda ventana
		driver.close();
		driver.switchTo().window(primeraVenta);
		System.out.println("Este es el nombre de la primera ventana: " +primeraVenta);
		Thread.sleep(2000);
		driver.findElement(lnkAlertTest).click();
		Thread.sleep(1000);
		driver.findElement(btnConfirm).click();
		String mensaje = driver.switchTo().alert().getText();
		System.out.println("Este es el texto de la alerta. " +mensaje);
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {

		Practice practica = new Practice();
		practica.MetodoPractica();





	}

}
