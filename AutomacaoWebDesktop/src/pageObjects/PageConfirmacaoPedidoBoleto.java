package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

import resource.webPage;

public class PageConfirmacaoPedidoBoleto extends webPage  {
	RemoteWebDriver paginaConfirmacaoPedido = browser;

	public PageConfirmacaoPedidoBoleto() throws Exception{
		Thread.sleep(2000);
		if(paginaConfirmacaoPedido.findElementsByXPath("//h2[@class='order-title is-slip-order']").get(0).isDisplayed())  
			System.out.println("Pagina confirmação de pedido carregada!");
	}
	
	public void veficarPedido(String usuario) throws Exception{
		 
		Assert.assertTrue(paginaConfirmacaoPedido.findElementByLinkText(usuario).isDisplayed());
		Assert.assertTrue(paginaConfirmacaoPedido.findElementsByXPath("//p[@class='order-number is-slip-order']").get(0).isDisplayed());
	}
	
	public void pressionarLinkHome() throws Exception{
		paginaConfirmacaoPedido.findElementsByXPath("//div[@class='logo-dimensions']").get(0).click();
	}
}
