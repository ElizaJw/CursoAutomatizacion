package test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import common.DataPropertiesManagement;
import constantes.ConstantesPruebas;

public class LoginMyStoreTest extends BaseTest {
	
	By txtemail = By.id("email");
	By txtpassword = By.id("passwd");
	By btnlogin = By.id("SubmitLogin");
	By lnkSing = By.cssSelector("a.login"); 
	By lnkUsuario = By.cssSelector("a[tittle='View my customer account']");
	
	@Test
	public void HacerLoguin() throws IOException, InterruptedException {
		
		driver.get(ConstantesPruebas.URL_STORE);
		DataPropertiesManagement datosLogin = new DataPropertiesManagement();
		Properties properties = datosLogin.getProperties();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lnkSing));
		
		
		driver.findElement(lnkSing).click();
		driver.findElement(txtemail).sendKeys(properties.getProperty("user"));
		driver.findElement(txtpassword).sendKeys(properties.getProperty("password"));
		driver.findElement(btnlogin).click();
		Assert.assertEquals(driver.findElement(lnkUsuario).getText(),"Cristian Mira");
		
		Thread.sleep(5000);
		
		
	}

}
