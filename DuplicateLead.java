package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuplicateLead extends MyBaseClass{
	@Test
	public void runDuplicateLead() throws InterruptedException {
		//5. Click on CRM/SFA Link		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6. Click Leads link		
		driver.findElement(By.linkText("Leads")).click();
		
		//7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//8. Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//9. Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("dhayaranjani@gmail.com");

		//10. Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//11. Capture name of First Resulting lead
		String FirstLeadId = driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).getText();				
		System.out.println("leadId is :" + FirstLeadId);
		
		//12. Click First Resulting lead
		driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).click();
		
		//13. Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		//14. Verify title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);
		
		if(driver.getTitle().contains("Duplicate Lead")){
			System.out.println("The title of the page is verified");
		}else {
			System.out.println("The title is null");
		} 

		//15. Click Create Lead 
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Create Lead']")).click();		
		
		Thread.sleep(5000);
		//16	Confirm the duplicated lead name is same as captured name
		//16. Close the browser
		//driver.close();
	}
}
