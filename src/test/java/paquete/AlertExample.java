package paquete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.internal.BaseClassFinder;

public class AlertExample {

	WebDriver driver;

	//Elementos del page sahi_demo
	By lnkAlerText = By.linkText("Alert Test");
	By btnClicAlert = By.name("b1");
	By lnkConfirmTest = By.linkText("Confirm Page");
	By lnkPromptPage = By.linkText("Prompt Page");

	
	//Aceptar la alerta
	public void alertAccept() throws InterruptedException {

		BaseTest test = new BaseTest();
		test.setupBrowser();
		driver = test.getDriver();
		driver.get(ExampleWindows.URL_SAHI);

		driver.findElement(lnkAlerText).click();
		driver.findElement(btnClicAlert).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.quit();

	}

	//capturar el texto del alert
	public void getAlertText() throws InterruptedException {

		BaseTest test = new BaseTest();
		test.setupBrowser();
		driver = test.getDriver();
		driver.get(ExampleWindows.URL_SAHI);

		driver.findElement(lnkAlerText).click();
		driver.findElement(btnClicAlert).click();
		Thread.sleep(3000);
		String textAlert = driver.switchTo().alert().getText();
		System.out.println("Texto del alert: "+textAlert);
		driver.switchTo().alert().accept();
		driver.quit();

	}

	
	/**
	 * Método para cancelar un alert
	 * @throws InterruptedException
	 */
	public void alertDissmis() throws InterruptedException {

		BaseTest test = new BaseTest();
		test.setupBrowser();
		driver = test.getDriver();
		driver.get(ExampleWindows.URL_SAHI);

		driver.findElement(lnkConfirmTest).click();
		driver.findElement(btnClicAlert).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();	
    	driver.quit();
	}
	
	/**
	 * Metodo para enviar un mensaje en un alert
	 * @throws InterruptedException
	 */
	public void SentAlertTest() throws InterruptedException {

		BaseTest test = new BaseTest();
		test.setupBrowser();
		driver = test.getDriver();
		driver.get(ExampleWindows.URL_SAHI);

		driver.findElement(lnkPromptPage).click();
		driver.findElement(btnClicAlert).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Yo tengo hambre");
		driver.switchTo().alert().accept();
//		driver.quit();

	}



	public static void main(String[] args) throws InterruptedException {

		AlertExample popups = new AlertExample();
		//		popups.alertAccept();
//		popups.getAlertText();
//		popups.alertDissmis();
		popups.SentAlertTest();
	}

}
