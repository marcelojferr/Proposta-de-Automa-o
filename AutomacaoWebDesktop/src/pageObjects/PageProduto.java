package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

import resource.webPage;

public class PageProduto extends webPage  {
	RemoteWebDriver paginaProdutos = browser;

	public PageProduto() throws Exception{
		Thread.sleep(2000);
		if(paginaProdutos.findElementById("title-aggregate-highlight").isDisplayed())  
			System.out.println("Pagina produtos carregada!");
	}
	
	public void selecionarProduto(String descProduto) throws Exception{
		paginaProdutos.findElementByLinkText(descProduto).click();
	}
	
}
