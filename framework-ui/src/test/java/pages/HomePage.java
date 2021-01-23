package pages;

import java.io.IOException;

import org.openqa.selenium.By;

public class HomePage extends Metodos {

	public void fecharModal(By elemento) throws IOException {

		if (driver.findElements(elemento).size() != 0) {

			click(elemento, "clicando no elemento presente na tela");
		} else {

			System.out.println("não apareceu modal na tela");
		}
	}

}
