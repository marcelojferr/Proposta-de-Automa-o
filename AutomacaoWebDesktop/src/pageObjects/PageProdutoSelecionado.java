package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

import resource.webPage;

public class PageProdutoSelecionado extends webPage  {
	RemoteWebDriver paginaProdutoSelecionado = browser;

	public PageProdutoSelecionado() throws Exception{
		Thread.sleep(2000);
		if(paginaProdutoSelecionado.findElementById("buy-button-now").isDisplayed())  
			System.out.println("Pagina produto selecionado carregada!");
	}
	
	public void selecionarTamanho(String tamanho) throws Exception{
		paginaProdutoSelecionado.findElementByLinkText(tamanho).click();
	}
	
	public void pressionarCompra() throws Exception{
		paginaProdutoSelecionado.findElementById("buy-button-now").click();
	}

}
