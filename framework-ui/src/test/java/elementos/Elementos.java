package elementos;

import org.openqa.selenium.By;

public class Elementos {

	// Elementos Web

	private By programacao = By.cssSelector("li:nth-child(3) > a > strong");
	private By btnFechar = By.cssSelector("#portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_YQcCxObpxg0J > div > div.portlet-content-container > div > div.clearfix.journal-content-article > div > div > div > div.modal-header.borderless > button > span");
	private By canais = By.cssSelector("a.btn.btn-title-no-background.pull-right > div > span.title-label > h2:nth-child(1)");
	
	public By getProgramacao() {
		return programacao;
	}


	public By getBtnFechar() {
		return btnFechar;
	}


	public By getCanais() {
		return canais;
	}
	
	
	
	
	

}
