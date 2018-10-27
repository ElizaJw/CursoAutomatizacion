package paquete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameExamle {
	
  private WebDriver driver;
  
  By lknFrame = By.linkText("Frames Test");
  By lnkbreake = By.linkText("Break Frames");
  
  public void togoframe () throws InterruptedException {
	  
	  BaseTest test = new BaseTest();
	  test.setupBrowser();
	  driver = test.getDriver();
	  driver.get(ExampleWindows.URL_SAHI);
	  driver.findElement(lknFrame).click();
	  Thread.sleep(5000);
	  driver.switchTo().frame(1);
	  test.hacerHighlight(driver, driver.findElement(lnkbreake));
	  Thread.sleep(5000);
	  driver.findElement(lnkbreake).click();
	  Thread.sleep(5000);
	  driver.quit();
	  
	
  }

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		FrameExamle ejem = new FrameExamle();
		ejem.togoframe();
		
		

	}

}
