package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

import resource.webPage;

public class PagePrincipal extends webPage  {
	RemoteWebDriver paginaPrincipal = browser;

	public PagePrincipal() throws Exception{
		Thread.sleep(2000);
		if(paginaPrincipal.findElementById("search-input").isDisplayed())  
			System.out.println("Pagina principal carregada!");
	}
	
	public void buscarProduto(String produto) throws Exception{
		paginaPrincipal.findElementById("search-input").sendKeys(produto);
		paginaPrincipal.findElementById("search-input").submit();
	}
	
	public void pressionarLogoff() throws Exception{
		paginaPrincipal.findElementsByXPath("//a[@rel='nofollow']").get(1).click();
		paginaPrincipal.findElementsByXPath("//a[@rel='nofollow']").get(5).click();
	}
}
