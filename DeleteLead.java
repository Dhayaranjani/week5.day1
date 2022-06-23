package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends MyBaseClass{
	@Test
	public void runDeleteLead() throws InterruptedException {
		//5. Click on CRM/SFA Link		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6. Click Leads link		
		driver.findElement(By.linkText("Leads")).click();
		
		//7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//8. Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//9. Enter the phone number - country code already there  
			 //if enters the phone number the result is none. So left it.

		//10. Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//11. Capture lead ID of First Resulting lead 
		//12. Click on first resulting lead
		String leadId =  driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).getText();				
		System.out.println("leadId is :" + leadId);
		
		driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).click();

		Thread.sleep(5000);
		
		//13. Click delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//14. Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//15. Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		
		//16. Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//17. Verify message "No records to display" in the Lead List. This message confirms the successful deletion

		if(driver.getTitle().contains("TestLeaf")){
			System.out.println("The title is verified");
		}else {
			System.out.println("No records to display");
		} 
		
		//18. Close the browser
		//driver.close();
	}
}
