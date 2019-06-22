/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author hp
 */
public class UnreadEmails {

    public static void main(String[] args) throws InterruptedException, IOException{
//        try{
            System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");
        
//        Thread.sleep(2000);
        driver.findElement(By.id("identifierId")).sendKeys("aman.teferi.80@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
//        Thread.sleep(2000);
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys(Utility.password);
        driver.findElement(By.id("passwordNext")).click();
        
        Thread.sleep(5000);
        
        File file = new File("./unreadEmails.txt");
        BufferedWriter wr = new BufferedWriter(new FileWriter(file));
        List<WebElement> emailList = driver.findElements(By.className("zE"));
        wr.write("YOU HAVE " + emailList.size() + " number of unread Email");
        for(WebElement x: emailList){
            wr.write("\n------------------------------\n");
            wr.write(x.findElement(By.className("yW")).getText());//Sender
            wr.write(" -> ");
            wr.write(x.findElement(By.className("y6")).getText());//Email
            wr.write("\n------------------------------\n");
        }
        driver.quit();
    }
    
}
