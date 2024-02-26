package Validation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/jyotikintali/Downloads/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		loginPage(driver);
		driver.findElement(By.className("css-sukebr")).click();
		driver.findElement(By.linkText("Orders")).click();
		driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root')]")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/jyotikintali/Downloads/demo-data.xlsx");
		driver.findElement(By.xpath("//input[@type='file']/../../following-sibling::button")).click();
		driver.findElement(By.xpath("//input[@type='file']/../../following-sibling::button")).click();
		driver.switchTo().alert().accept();
		
		 
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./Captures/Validate01.png");
		FileUtils.copyFile(src, trg);
		driver.close();
	}

	public static void loginPage(WebDriver driver) {
		driver.get("https://demo.dealsdray.com/");
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// TODO Auto-generated method stub

	}


}
