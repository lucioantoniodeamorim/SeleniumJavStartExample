package consultaCep.test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ConsultaCep {
	public static void main(String[] args) throws InterruptedException {
        
		//Seta a localização do chromedriver
		System.setProperty("webdriver.chrome.driver", "D://driver/chromedriver.exe");
		
		//Cria uma instância do driver
		WebDriver driver=new ChromeDriver();
		
		//Maximiza a tela
		driver.manage().window().maximize();
		
		//Visita a url 
		driver.get("https://buscacepinter.correios.com.br/app/endereco/index.php");
		
		//Digita no camo de busca o cep 89209674
		driver.findElement(By.id("endereco")).sendKeys("89209674");
		
		//Clica no botão de pesquisa
		driver.findElement(By.id("btn_pesquisar")).click();

		//Tempo de espera para ver o resultado - O teste não deve ter sleep, foi inserido neste código apenas por didática, a maneira correta é usar um Explicit wait
		Thread.sleep(5000);
		
		//Pega o texto do campo de resposta da pesquis
		String resultado = driver.findElement(By.xpath("//*[@id='resultado-DNEC']/tbody/tr/td[1]")).getText();
		
		//Printa o conteúdo do campo - Aqui deveria estar a validação de que o conteúdo exibido é o conteúdo esperado, para isso usaríamos um framework de testes como TestNG ou Junit
		System.out.println(resultado);

		driver.close();

		}

}
