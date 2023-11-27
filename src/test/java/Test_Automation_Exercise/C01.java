package Test_Automation_Exercise;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class C01 extends TestBase {

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
       @Test
       public void test01() {


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

            //5. Verify 'New User Signup!' is visible

            WebElement newusertitle = driver.findElement(By.xpath("//div[@class='signup-form']"));
            if (newusertitle.isDisplayed()) {
                System.out.println("Passed");
            } else {
                System.out.println("failed");

            }
            //6-Enter name and email address
            WebElement name = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
            WebElement mail = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
            name.click();
            name.sendKeys("Nazime");
            mail.click();
            mail.sendKeys("kirkgoznazime7@gmail.com");

            //7. Click 'Signup' button

            driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
            // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            WebElement account = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
            if (account.isDisplayed()) {
                System.out.println("passt");

            } else {
                System.out.println("failed");
            }
            //9. Fill details: Title, Name, Email, Password, Date of birth
            WebElement title = driver.findElement(By.xpath("//div[@class='radio-inline'][2]")); //titlet
            title.click();
            WebElement password = driver.findElement(By.xpath("//input[@data-qa='password']"));//
            password.click();
            password.sendKeys("12345");
           password.sendKeys(Keys.PAGE_DOWN);


            WebElement dateddm = driver.findElement(By.xpath("//select[@data-qa='days']"));
            Select selectgun = new Select(dateddm);
            selectgun.selectByIndex(5);
            WebElement monthddm=driver.findElement(By.xpath("//select[@id='months']"));
            Select selectmonth=new Select(monthddm);
            selectmonth.selectByValue("4");
           WebElement yearddm = driver.findElement(By.xpath("//select[@id='years']"));
            Select selectyear = new Select(yearddm);
            selectyear.selectByValue("1990");
            // 10. Select checkbox 'Sign up for our newsletter!'
           driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
           //11. Select checkbox 'Receive special offers from our partners!'
           driver.findElement(By.xpath("//input[@id='optin']")).click();
          // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            WebElement firstname=driver.findElement(By.xpath("//input[@id='first_name']"));
            firstname.click();
            firstname.sendKeys("Nazime");

           WebElement lastname=driver.findElement(By.xpath("//input[@id='last_name']"));
           lastname.click();
           lastname.sendKeys("Kirkgoz");


           WebElement company=driver.findElement(By.xpath("//input[@id='company']"));
          company.click();
          company.sendKeys("A");

           WebElement adress1=driver.findElement(By.xpath("//input[@id='address1']"));
          adress1.click();
          adress1.sendKeys("serdar mahallesi");

          WebElement adress2=driver.findElement(By.xpath("//input[@id='address2']"));
         adress2.click();
         adress2.sendKeys("100.yil");
         adress2.sendKeys(Keys.PAGE_DOWN);

         WebElement countryddm=driver.findElement(By.xpath("//select[@id='country']"));
         Select select=new Select(countryddm);
         select.selectByValue("India");

        WebElement state= driver.findElement(By.xpath("//Input[@id='state']"));
        ReusableMethods.bekle(3);
        state.click();
        state.sendKeys("jfjjfj");

           WebElement city= driver.findElement(By.xpath("//input[@id='city']"));

          city.click();
          city.sendKeys("dert");


           WebElement zip=driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.click();
         zip.sendKeys("3435");
         WebElement mobile=driver.findElement(By.xpath("//input[@id='mobile_number']"));
         mobile.click();
         mobile.sendKeys("05513456778");
         //13. Click 'Create Account button'
         driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();
         ReusableMethods.bekle(3);
         //14. Verify that 'ACCOUNT CREATED!' is visible
           WebElement accaunt=driver.findElement(By.xpath("//h2[@class='title text-center']"));
           Assert.assertTrue(accaunt.isDisplayed());
           //15. Click 'Continue' button
           driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
           //16. Verify that 'Logged in as username' is visible
           WebElement log=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
           String expected="Logged in as Nazime Kirkgoz";
           String actuall= driver.getTitle();
          Assert.assertEquals(expected,actuall);
           //17. Click 'Delete Account' buttonf
           driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
           //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

           expected="ACCOUNT DELETED!";
           actuall= driver.getTitle();
           Assert.assertEquals(expected,actuall);
           driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();



        }





    }

