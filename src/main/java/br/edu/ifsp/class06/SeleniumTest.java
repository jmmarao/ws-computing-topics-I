package br.edu.ifsp.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        String userPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userPath + "/lib/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://scl.ifsp.edu.br");

        WebElement plateObj = driver.findElement(By.id("iptPlaca"));
        plateObj.sendKeys("ABC-9U34");

        WebElement brandObj = driver.findElement(By.id("iMarca"));
        brandObj.sendKeys("Fiat");

        WebElement modelObj = driver.findElement(By.xpath("/html/body/form/input[3]"));
        modelObj.sendKeys("Uno");

        WebElement showObj = driver.findElement(By.xpath("/html/body/button[1]"));
        showObj.click();

        WebElement linkObj = driver.findElement(By.partialLinkText("IFSP"));
        linkObj.click();

        Thread.sleep(10000);
        driver.quit();
    }
}
