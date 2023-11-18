package Test_Automation_Exercise;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
               /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         */
        // 1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("URL testi PASSED");
        } else {
            System.out.println("URL testi FAILED");
            System.out.println("Actual URL : " + actualUrl);
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        Thread.sleep(1000);
        //5. Verify 'New User Signup!' is visible

        WebElement newusertitle= driver.findElement(By.xpath("//div[@class='signup-form']"));
        if (newusertitle.isDisplayed()){
            System.out.println("Passed");
        }else{
            System.out.println("failed");

        }
        //6-Enter name and email address
        WebElement name= driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        WebElement mail= driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        name.click();
        name.sendKeys("Nazime");
        mail.click();
        mail.sendKeys("kirkgoznazime@gmail.com");

        //7. Click 'Signup' button

        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement account= driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        if (account.isDisplayed()){
            System.out.println("passt");

        }else {
            System.out.println("failed");
        }
        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title=driver.findElement(By.xpath("//div[@class='radio-inline'][2]")); //titlet
        title.click();
        WebElement password= driver.findElement(By.xpath("//input[@data-qa='password']"));//
        password.click();
        password.sendKeys("12345");


        driver.quit();

    }
}
