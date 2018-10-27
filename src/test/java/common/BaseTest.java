package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	
	
	/**
	 * 
	 */
	
	@Parameters({"browser"})
	@BeforeTest
	public void abrirNavegador(String browser) {
		
		if("chrome".equals(browser)) {
			
			//Se define la propiedad del sistema con el driver
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			
			ChromeOptions chromeOptions = new ChromeOptions();
			//Preferencias del navegador
			chromeOptions.addArguments("start-maximized","--incognito","disable-infobars");
			
			//Incia el navegador Chrome
			driver = new ChromeDriver(chromeOptions);	
			
		}
		else {
			
			System.err.println("El parametro no corresponde al nombre de un navegador");
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		
		//Incia el navegador Firefox
		//driver = new FirefoxDriver();
		
		//Incia el navegador Internet Explorer
		//driver = new InternetExplorerDriver();
	}
	
	
	/**
	 * 
	 */
	@AfterTest
	public void cerrarNavegador() {

		if (driver != null) {
			driver.quit();
			System.out.println("Se cierra el navegador");
		} else {
			System.out.println("No hay drivers con sesión activa");
		}

	}

}