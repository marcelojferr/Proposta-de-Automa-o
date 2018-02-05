package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

import resource.webPage;

public class PageSacola extends webPage  {
	RemoteWebDriver paginaSacola = browser;

	public PageSacola() throws Exception{
		Thread.sleep(2000);
		if(paginaSacola.findElementsByXPath("//button[@class='button button-rounded button-flat buy-button-now']").get(0).isDisplayed())  
			System.out.println("Pagina sacola de compras carregada!");
	}
	
	public void pressionarCalcularFrete() throws Exception{
		paginaSacola.findElementById("calculate-shipping").click();
		Thread.sleep(2000);
	}

	public void pressionarConcluirCompra() throws Exception{
		paginaSacola.findElementsByXPath("//button[@class='button button-rounded button-flat buy-button-now']").get(0).click();
		Thread.sleep(2000);
	}
}
