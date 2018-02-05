package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import resource.webPage;

public class PageEnderecos extends webPage  {
	RemoteWebDriver paginaEnderecos = browser;

	public PageEnderecos() throws Exception{
		Thread.sleep(2000);
		if(paginaEnderecos.findElementById("address-create-link").isDisplayed())  
			System.out.println("Pagina pagamento carregada!");
	}
	
	public void pressionarCadastrarEndereco() throws Exception{
		paginaEnderecos.findElementById("address-create-link").click();
		Thread.sleep(2000);
	}
	
	public void preencherTituloEndereco(String tituloEndereco) throws Exception{
		paginaEnderecos.findElementById("address-title").sendKeys(tituloEndereco);
	}
	
	public void preencherDestinatario(String destinatario) throws Exception{
		paginaEnderecos.findElementById("recipient-name").sendKeys(destinatario);
	}
	
	public void preencherCep(String cep) throws Exception{
		paginaEnderecos.findElementById("address-zipcode").sendKeys(cep);
	}
	
	public void preencherTipoEndereco(String tipoEndereco) throws Exception{
		Select tipo= new Select(paginaEnderecos.findElementById("address-street-type"));
		tipo.selectByValue(tipoEndereco);
	}
	
	public void preencherRua(String rua) throws Exception{
		paginaEnderecos.findElementById("address-name").sendKeys(rua);
	}
	
	public void preencherNumero(String numero) throws Exception{
		paginaEnderecos.findElementById("address-number").sendKeys(numero);
	}
	
	public void preencherComplemento(String complemento) throws Exception{
		paginaEnderecos.findElementById("address-additional-info").sendKeys(complemento);
	}
	
	public void preencherBairro(String bairro) throws Exception{
		paginaEnderecos.findElementById("neighborhood").sendKeys(bairro);
	}
	
	public void preencherUf(String uf) throws Exception{
		Select estado = new Select(paginaEnderecos.findElementById("address-state"));
		estado.selectByValue(uf);
	}
	
	public void preencherCidade(String cidade) throws Exception{
		paginaEnderecos.findElementById("city").sendKeys(cidade);
	}
	
	public void preencherReferencia(String referencia) throws Exception{
		paginaEnderecos.findElementById("reference").sendKeys(referencia);
	}

	public void selecionarEndereco(String endereco) throws Exception{
		paginaEnderecos.findElementsByXPath("//div[@class='address-select column-" + endereco +"']").get(0).click();

	}
	
	public void pressionarSalvar() throws Exception{
		paginaEnderecos.findElementById("save-address-button").click();
		Thread.sleep(2000);
	}
	
	
}
