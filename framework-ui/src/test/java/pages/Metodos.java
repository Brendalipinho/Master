package pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Metodos {

	static WebDriver driver;

	public void abrirNavegador(String site, String passo) throws IOException {
		try {

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(site);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- " + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}

	}

	public void escrever(String texto, By elemento, String passo) throws IOException {

		try {

			driver.findElement(elemento).sendKeys(texto);

		} catch (Exception e) {

			System.out.println("--- erro ao tentar executar o passo -- " + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}

	}

	public void submit(By elemento, String passo) throws IOException {

		try {
			driver.findElement(elemento).submit();
		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- " + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}

	}

	public void fecharNavegador(String teste) throws IOException {

		screenshot(teste);
		driver.quit();
	}

	public void validarTexto(String textoEsperado, By elemento, String passo) throws IOException {

		try {
			String texto = driver.findElement(elemento).getText();
			assertEquals(textoEsperado, texto);

		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- " + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}

	}

	public void screenshot(String nome) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/evidencias/" + nome + "teste.png");
		FileUtils.copyFile(srcFile, destFile);

	}

	public void pesquisarValidarText(String text, String passo) throws IOException {
		
		try {

		driver.findElements(By.linkText(text)).contains(text);
		
		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- "  + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}
	}

	public void click(By elemento, String passo) throws IOException {

		try {
		driver.findElement(elemento).click();
		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- "  + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}
	}

	public void validarPorTexto(String palavra, String passo) throws IOException {

		try {
		String texto = driver.findElement(By.xpath("//span[text()='" + palavra + "']")).getText();
		assertEquals(palavra, texto);
		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- "  + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}

	}

	public void horaAtual() {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);
		System.out.println(dataFormatada);

	}


	public void validarTitle(String tituloEspero, String passo) throws IOException {

		try {
		String titulo = driver.getTitle();
		assertEquals(tituloEspero, titulo);
		} catch (Exception e) {
			System.out.println("--- error ao tentar executar o passo --- "  + passo + " " + LocalDateTime.now());
			screenshot("error/" + passo);
		}

	}

}
