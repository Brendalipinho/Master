package tests;

import java.io.IOException;

import elementos.Elementos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.Metodos;

public class Steps {

	Metodos metodos = new Metodos();
	Elementos elemento = new Elementos();
	HomePage h = new HomePage();

	@Given("que eu esteja no {string}")
	public void que_eu_esteja_no(String site) throws IOException {
		metodos.abrirNavegador(site, "acessando o google");
	}

	@When("acessar programacao atual")
	public void acessar_programacao_atual() throws InterruptedException, IOException {
		h.fecharModal(elemento.getBtnFechar());
		metodos.click(elemento.getProgramacao(), "acessar programação");
		metodos.horaAtual();

	}

	@When("acessar lista de canais")
	public void acessar_lista_de_canais() throws InterruptedException, IOException {
		Thread.sleep(5000);
		metodos.click(elemento.getCanais(), "Clicnado em canais");

	}

	@Then("valido {string} esta correta")
	public void valido_esta_correta(String titulo) throws IOException {
		metodos.validarTitle(titulo, "validando o titulo da pagina " + titulo);
		metodos.fecharNavegador(" Validar title lista de canais ");
	}
}
