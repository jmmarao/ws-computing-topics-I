package br.edu.ifsp.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        String chromeDriverPath = projectPath + "\\lib\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/2022_02/03_TC1S5/s08e01_Selenium_Seletores.html");

        WebElement iptNome = driver.findElement(By.cssSelector("input[name='nome']"));
        iptNome.sendKeys("João");

        // Set the first elemented found
        WebElement inputDataNasc = driver.findElement(By.className("inputTextFormulario"));
        inputDataNasc.sendKeys("Smith");

        WebElement inputDiv = driver.findElement(By.tagName("div"));
        WebElement inputData = inputDiv.findElement(By.className("inputTextFormulario"));
        inputData.sendKeys("03/10/2022");

        WebElement inputColor = driver.findElement(By.id("selecionaCabelos"));
        inputColor.sendKeys("#0000FF");

        // Other way
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].value = '#0000FF'", inputColor);

        WebElement link1 = driver.findElement(By.linkText("Link para IFSP"));
        link1.click();
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        WebElement link2 = driver.findElement(By.name("linkParaIFSPSC"));
        link2.click();

        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        System.out.println(driver.getCurrentUrl());

        WebElement link3 = driver.findElement(By.name("linkParaPgTeste"));
        link3.click();
        System.out.println("Código fonte!!!!!!");
        System.out.println(driver.getPageSource());
    }
}
