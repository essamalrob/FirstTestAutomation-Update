package newPackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.net.URLConnection;
import java.net.URI;
import java.util.*;
import com.google.common.collect.Iterators;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.URL;




public class MyFirstClass {
	

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
  String Expected_PayPal_Title="سجّل الدخول إلى حسابك على PayPal";
  String Customer_Service_Expected_Title= "Customer Service | Frontgate";
	HttpURLConnection huc=null;
	int StatusCode=200;
	String url="";
	
    
    
   
    
  System.setProperty("webdriver.gecko.driver","C:\\Chrome and firefox driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
	        driver.get("https://devwcs.frontgate.com/UserLogonView?storeId=10053&catalogId=10053&langId=-1");
	        
	        String  CurrentTitle= driver.getTitle();
	        
	      WebElement login = driver.findElement(By.id("logonId"));
	      login.sendKeys("username");
	      WebElement logonPassword =driver.findElement(By.id("logonPassword"));
	     logonPassword.sendKeys("Test@123");
	     //logonButton
	     driver.findElement(By.id("logonButton")).click();
	     
	     String ExpectedTitle ="Sign In | Frontgate";
	     
	     if(ExpectedTitle.equals(CurrentTitle))
	     {
	    	 System.out.println("  Test Pass ");
	    	 
	     }
	     else
	     {
	    	 System.out.println("Test Fail"); 
	     }
	     
	     
	     
	     
	 ///////////////////////  Test Search Functionality ///////////  
	    //  test Product :  Angelina Bar 
	     
    driver.findElement(By.name("searchTerm")).sendKeys("Angelina Bar");
	    driver.findElement(By.id("searchButton")).click();
	     
	     
	     
	     ///////////////check Payment Functionality/////////////////
	    WebDriverWait webdriverwair =new WebDriverWait(driver,Duration.ofSeconds(20));
	    
	           
	            WebElement Open_product =webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"unbxd-index-0\"]/div/div[1]/a")));
	            Open_product.click();
	            
	            
	            
	           WebElement Select_Choice1 =webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//div[@id='gwt-option-panel']//div[@class='gwt-selection-chip-picker']/div[@role='group']/div[1]//span[@class='gwt-selection-chip-display']")));
	            Select_Choice1.click();

	            
	            WebElement Select_Choice2 =webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gwt-option-panel\"]/div[2]/div[4]/div/div[1]/div[1]/img")));
	            Select_Choice2.click();
	            
	         
	          //*[@id="gwt-add-to-cart-btn"]

	            WebElement Add_to_Card1 =webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='gwt-add-to-cart-btn']/span[text()='Add To My Cart']")));
	            Add_to_Card1.click();
	            
	          
	           // WebElement Add_to_Card_2 =webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[2]")));
	            //Add_to_Card_2.click();
	            
	            
	           
//	            WebElement Check_PayPal =webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout-with-paypal-button\"]")));
//	            Check_PayPal.click();
//	         String Check_PayPal_Name = driver.getWindowHandle();
//	         
//	            driver.switchTo().window(Check_PayPal_Name);
//                 
//	           
//	           if(driver.getTitle().equalsIgnoreCase(Expected_PayPal_Title))
//	           {
//	        	   System.out.println("Test Passed");
//	           }
//	           else
//	           {
//	        	   System.out.println("Test Faild");
//	        	   
//	           }
	           
	     /////////////Check Home Page behavior   for returning customers  //////////////////////
	     
	            driver.findElement(By.xpath("//*[@id=\"logo1\"]/a")).click();
	   	     if(driver.getCurrentUrl().equalsIgnoreCase("https://devwcs.frontgate.com/"))
	   	     System.out.println(" Pass  To Return To Home Page");
	   	     else
	   	    	  System.out.println("FailedTo Return  To Home Page");
	     
	     /////////Check Customer Service/Contact Pages/////////////////
	     
	     WebElement  Customer_Serveice= webdriverwair.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/div[2]/div[2]/div/div/div[2]/ul/li[3]/a")) );
	    		// driver.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/div[2]/div/div/div[2]/ul/li[3]/a"))) ;
	     
	     Customer_Serveice.click();
	     
	     String Current_Customer_Service=driver.getTitle();
	     
	     if(Current_Customer_Service.equals(Customer_Service_Expected_Title))
	     {
	    	 
	     System.out.println( " Customer Service :Test Pased");
	     }
	     else
	     {
	    	 System.out.println("Customer Service  : Test Faild");
	     }
	     
	     
	     ////////////////////////////////////////
	     
	     driver.findElement(By.xpath("//*[@id=\"logo1\"]/a")).click();
	     if(driver.getCurrentUrl().equalsIgnoreCase("https://devwcs.frontgate.com/"))
	     System.out.println(" Pass  To Return To Home Page");
	     else
	    	  System.out.println("FailedTo Return  To Home Page");
	     
	     
	     /////////////Test Broken Links/////////////////
	     
	     
	     
	     List<WebElement> linkElements = driver.findElements(By.tagName("a"));							
	        String[] linkTexts = new String[linkElements.size()];							
				int					i = 0;					
				String href="";
				//extract the link texts of each link element		
				for (WebElement e : linkElements) {	
					href=e.getAttribute("href") ;
					
					if(href !=null )
					{
				linkTexts[i] = e.getText();							
				i++;
					}
	        }		

				//test each link		
				for (String t : linkTexts) {	
					
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					try {
						
						System.out.println(t);
						
						js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText(t)));
						if (driver.getTitle().equals("Under Construction")) {							
			                System.out.println("\"" + t + "\""								
			                        + " is under construction.");			
			            } else {			
			                System.out.println("\"" + t + "\""								
			                        + " is working.");			
			            }		
						driver.navigate().back();
						
					} catch(StaleElementReferenceException e)
					{
						System.out.println(t);
						
						js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText(t)));
						if (driver.getTitle().equals("Under Construction")) {							
			                System.out.println("\"" + t + "\""								
			                        + " is under construction.");			
			            } else {			
			                System.out.println("\"" + t + "\""								
			                        + " is working.");			
			            }		
						driver.navigate().back();
					}
					
					
					
				
						
	        }		 
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     List<WebElement> LinksElement = driver.findElements(By.tagName("a"));
	     String[] LinkText=new String[LinksElement.size()];
	     
	     
	  i=0;
		  for(WebElement e:LinksElement)
		  {
			  
			 LinkText[i]=e.getText() ;
			
			 
			 System.out.println(e.getText()+"\n");
			 
			// verifyLink(e.getAttribute("href"));
			   url= e.getAttribute("href");
			   if(url== null || url.isEmpty())
			   {
				   System.out.println(" Url Is Empty OR Null ");
			   }
			   else
			   { 
				   verifyLink(url);
			     
			     i++;
			   }
			 
		  }
		  
		
		   
		    
	         
	      
	      

	     
	     
	     
	     
	     
	     
	// driver.quit();
	     
		 
		    	
		    	    
	       
    }

    public static void verifyLink(String url) {
    	try {
    	URL link = new URL(url);
    	//URI link=new URI(url).toURL(url);
    	HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
    	httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
    	httpURLConnection.setRequestMethod("HEAD");
    	httpURLConnection.connect();


    	if (httpURLConnection.getResponseCode() == 200) {
    	System.out.println(url + " - " + httpURLConnection.getResponseMessage());
    	} else
    	{
    	System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
    	}
    	} catch (Exception e) {
    	System.out.println(url + "  inside Exception - " + "is a broken link   :  "  + e.getMessage());
    	}
    
}
}