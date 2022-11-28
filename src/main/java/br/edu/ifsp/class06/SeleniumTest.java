package br.edu.ifsp.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestAntigo {
    public static void main(String[] args) throws InterruptedException {
//        String projectPath = System.getProperty("user.dir");
//        String chromeDriverPath = projectPath + "\\lib\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", "src/main/java/br/edu/ifsp/class06/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:/home/jones/Documents/repository/ifsp/ws-computing-topics-I/src/main/java/br/edu/ifsp/class06/index.html");
        WebElement btnEnviar = driver.findElement(By.xpath("/html/body/form/input[2]"));
        btnEnviar.click();
        WebElement iptLogin = driver.findElement(By.id("idLogin"));
        WebElement par1 = driver.findElement(By.id("p1"));
        String textoParagrafo = par1.getText();
        String esperada = "Este campo é requerido";
        String login = iptLogin.getAttribute("value");
        String corAtual = par1.getCssValue("color");
        String corEsperada = "rgba(255, 0, 0, 1)";
        if(login.isEmpty()){
            if(esperada.compareTo(textoParagrafo)==0){
                System.out.println("A saída está conforme o esperado");
                if(corEsperada.compareTo(corAtual)==0)
                    System.out.println("A cor do parágrafo está correta");
                else
                    System.out.println("A cor do parágrafo não está correta");
            }else{
                System.out.println("Desenvolvedor, você cometeu um erro catastrófico...");
            }
        }
    }
}
