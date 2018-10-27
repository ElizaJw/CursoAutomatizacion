package paquete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDressToCar {

	private WebDriver driver;

	private static final String URL_AUTOMATION ="http://automationpractice.com/index.php";

	//Object buy dress
	By lnkDresses = By.cssSelector("div>ul>li>a[title='Dresses']");
	By lnkCasualDresses = By.xpath("//ul[@class='tree dynamized']/li/a[contains(text(),'Casual Dresses')]");
	By rbtSize = By.id("layered_id_attribute_group_2");
	By imgDress = By.cssSelector("img[title='Printed Dress']");
	By btnAddToCar = By.cssSelector("a[class='button ajax_add_to_cart_button btn btn-default'][title='Add to cart']");
	By btnProceedToCheckout = By.cssSelector("a[class='btn btn-default button button-medium']");


	private void addDressTocarForMycat() throws InterruptedException {

		BaseTest baseTest = new BaseTest();
		baseTest.setupBrowser();
		driver = baseTest.getDriver();
		baseTest.openPage(URL_AUTOMATION);
		//Se instancia el objeto WebDriverWait
		WebDriverWait wait =  new WebDriverWait(driver, 30);
	    
		// Se interatua con los objetos de DOM
		driver.findElement(lnkDresses).click();;	
		wait.until(ExpectedConditions.elementToBeClickable(lnkDresses));
		driver.findElement(lnkCasualDresses).click();
		driver.findElement(rbtSize).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(imgDress)).build().perform();
		Thread.sleep(4000);
		driver.findElement(btnAddToCar).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnProceedToCheckout));
		driver.findElement(btnProceedToCheckout);
		
		baseTest.closeDriver();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		AddDressToCar Additem = new AddDressToCar();
		Additem.addDressTocarForMycat();

	}

}
