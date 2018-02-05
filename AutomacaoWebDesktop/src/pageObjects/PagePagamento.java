package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import resource.webPage;

public class PagePagamento extends webPage  {
	RemoteWebDriver paginaPagamento = browser;

	public PagePagamento() throws Exception{
		Thread.sleep(2000);
		if(paginaPagamento.findElementById("frete-0-NORMAL").isDisplayed())  
			System.out.println("Pagina pagamento carregada!");
	}
	
	
	public void selecionarFrete(String frete, String diaAgendamento, String periodo, String estado, String cidade, String bairro) throws Exception{
	
		switch (frete) {
		case "Normal":
			paginaPagamento.findElementById("frete-0-NORMAL").click();
			Thread.sleep(1000);
			break;
			
		case "Expressa":
			paginaPagamento.findElementById("frete-0-EXPRESS").click();
			Thread.sleep(1000);
			break;
			
		case "Super Expressa":
			paginaPagamento.findElementById("frete-0-SUPER_EXPRESS").click();
			Thread.sleep(1000);
			break;
			
		case "Agendada":
			paginaPagamento.findElementById("frete-0-SCHEDULED").click();
			Thread.sleep(2000);
			paginaPagamento.findElementByName("sheduled-delivery").click();
			Thread.sleep(2000);
			paginaPagamento.findElementByLinkText(diaAgendamento).click();
			if(periodo.equals("Manha")) paginaPagamento.findElementById("delivery-shift-5809078749da4a8275d06793").click();
			if(periodo.equals("Tarde")) paginaPagamento.findElementById("delivery-shift-5809078749da4a8275d06794").click();
			paginaPagamento.findElementsByXPath("//a[@class=' highlight-button button-close schedule-freight']").get(0).click();
			Thread.sleep(2000);
			break;
			
		case "Retirada":
			paginaPagamento.findElementById("frete-0-CLICK_AND_COLLECT").click();
			Thread.sleep(1000);
			paginaPagamento.findElementByXPath("//div[@class='choose-click-and-collect']").click();
			Thread.sleep(1000);
			Select SelEstado = new Select(paginaPagamento.findElementById("list-states-click-and-collect"));
			Select selCidade = new Select(paginaPagamento.findElementById("list-cities-click-and-collect"));
			Select selBairro = new Select(paginaPagamento.findElementById("list-districts-click-and-collect"));
			SelEstado.selectByValue(estado);
			Thread.sleep(2000);
			selCidade.selectByValue(cidade);
			Thread.sleep(2000);
			selBairro.selectByValue(bairro);
			Thread.sleep(2000);
			paginaPagamento.findElementsByXPath("//button[@class='postoffice-btn postoffice-select-option']").get(0).click();
			Thread.sleep(2000);
			paginaPagamento.findElementsByXPath("//button[@class='click-and-collect_btn-default button-break']").get(0).click();
			Thread.sleep(2000);
			break;
			
		default:
			System.out.println("Opção não é válida!");
		}
	}
	
	public void preencherNumeroCartao(String numeroCartao) throws Exception{
		paginaPagamento.findElementById("creditcard-number").sendKeys(numeroCartao);
		paginaPagamento.findElementById("creditcard-number").sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}
	
	public void preencherNomeCartao(String nomeCartao) throws Exception{
		paginaPagamento.findElementById("creditcard-owner").sendKeys(nomeCartao);
	}
	
	public void preencherMesCartao(String mesCartao) throws Exception{
		Select selecalMes = new Select(paginaPagamento.findElementById("creditcard-expiration-month"));
		selecalMes.selectByVisibleText(mesCartao);
	}
	
	public void preencherAnoCartao(String anoCartao) throws Exception{
		Select selecalAno = new Select(paginaPagamento.findElementById("creditcard-expiration-year"));
		selecalAno.selectByValue(anoCartao);
	}
	
	public void preencherCodigoCartao(String codigoCartao) throws Exception{
		paginaPagamento.findElementById("creditcard-securitycode").sendKeys(codigoCartao);
	}
	
	public void preencherParcelamento(int numParcelas) throws Exception{
		Select parcelas = new Select(paginaPagamento.findElementById("creditcard-installments-number"));
		parcelas.selectByIndex(numParcelas-1);
	}
	
	public void pressionarCartaoCredito() throws Exception{
		paginaPagamento.findElementById("creditcard-button").click();
	}

	public void pressionarBoleto() throws Exception{
		paginaPagamento.findElementById("slip-button").click();
	}

	public void pressionarAlterarEndereco() throws Exception{
		paginaPagamento.findElementsByXPath("//a[@class='btn-change-address']").get(0).click();
	
//	public void pressionarAlterarEndereco() throws Exception{
//		paginaPagamento.findElementsByXPath("//a[@class='btn-change-address']").get(0).click();
//		Thread.sleep(2000);
//	}
	}

	
}
