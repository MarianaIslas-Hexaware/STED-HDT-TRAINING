package excercisesHdtTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PersonalInformation {
	
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1000075178\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//Filling in the section: "Personal information"
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		
		String email = "marianavives123@gmail.com";
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.cssSelector("i.icon-user")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 30); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'YOUR PERSONAL INFORMATION')]")));
		//System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'YOUR PERSONAL INFORMATION')]")));
		
		Thread.sleep(3000);
		WebElement radio = driver.findElement(By.id("id_gender2"));
		radio.click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Mariana");
		driver.findElement(By.id("customer_lastname")).sendKeys("Vives");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys("mariana123");
		driver.findElement(By.id("days")).click();

		
		//Select dropdown items
		WebElement dropdownDays = driver.findElement(By.id("days")) ;
		Select dropdown1 = new Select(dropdownDays);
		dropdown1.selectByIndex(28);
		dropdown1.getFirstSelectedOption();
		System.out.println(dropdown1.getFirstSelectedOption().getText());

		WebElement dropdownMonth = driver.findElement(By.id("months"));
		Select dropdown2 = new Select(dropdownMonth);
		dropdown2.selectByIndex(10);; ;
		dropdown2.getFirstSelectedOption();
		System.out.println(dropdown2.getFirstSelectedOption().getText());
		
		WebElement dropdownYear = driver.findElement(By.id("years"));
		Select dropdown3 = new Select(dropdownYear);
		dropdown3.selectByValue("1993"); ;
		dropdown3.getFirstSelectedOption();
		System.out.println(dropdown3.getFirstSelectedOption().getText());
		
		//Checkboxes
		Assert.assertFalse(driver.findElement(By.id("newsletter")).isSelected());
		driver.findElement(By.id("newsletter")).click();
		Assert.assertTrue(driver.findElement(By.id("newsletter")).isSelected());
		driver.findElement(By.id("newsletter")).click();

		
		Assert.assertFalse(driver.findElement(By.id("optin")).isSelected());
		driver.findElement(By.id("optin")).click();
		Assert.assertTrue(driver.findElement(By.id("optin")).isSelected());
		driver.findElement(By.id("optin")).click();
	}
}
