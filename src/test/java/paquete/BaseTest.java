package paquete;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseTest {

	private WebDriver driver;


	public void setupBrowser() {


		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");	

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	}

	//Método para obtener la URL
	public void openPage(String url) {

		driver.get(url);
	}

	//Método para obtener el driver
	public WebDriver getDriver() {

		return driver;
	}


	public static void hacerHighlight(WebDriver driver, WebElement element) {

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='10px solid purple'", element);
		}

	}

	/**
	 * Método para cerrar el navegador
	 */
	
	public void closeDriver() {

		if (driver!=null) {
			driver.close();

		} else {
			System.out.println("No hay Driver abierto");

		}

	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
