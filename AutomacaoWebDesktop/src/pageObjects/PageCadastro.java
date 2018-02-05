package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import resource.webPage;;

public class PageCadastro extends webPage {
	RemoteWebDriver cadastro = browser;

	public PageCadastro() throws Exception{
		Thread.sleep(2000);
		if(cadastro.findElementById("person-name").isDisplayed())  
			System.out.println("Pagina cadastro carregada!");
	}
	
	public void preencherNome(String nome) throws Exception{
		cadastro.findElementById("person-name").sendKeys(nome);
	}

	public void preencherSobrenome(String sobrenome) throws Exception{
		cadastro.findElementById("person-last-name").sendKeys(sobrenome);
	}
	
	public void preencherSexo(String sexo) throws Exception{
		if(sexo.equals("Feminino")) cadastro.findElementById("label-female").click();
		if(sexo.equals("Masculino")) cadastro.findElementById("label-male").click();
	}
	
	public void preencherDiaNascimento(String dia) throws Exception{
		cadastro.findElementById("dateofbirth-day").sendKeys(dia);
	}
	
	public void preencherMesNascimento(String mes) throws Exception{
		 Select anoNascimento = new Select(cadastro.findElementById("dateofbirth-month"));
		 anoNascimento.selectByValue(mes);
	}
	
	public void preencherAnoNascimento(String ano) throws Exception{
		Select anoNascimento = new Select(cadastro.findElementById("dateofbirth-year"));
		anoNascimento.selectByValue(ano);
	}
	
	public void preencherCpf(String cpf) throws Exception{
		cadastro.findElementById("cpf").sendKeys(cpf);
	}
	
	public void preencherCep(String cep) throws Exception{
		cadastro.findElementById("address-zipcode").sendKeys(cep);
	}
	
	public void preencherTipoEndereco(String tipoEndereco) throws Exception{
		Select tipo= new Select(cadastro.findElementById("address-street-type"));
		tipo.selectByValue(tipoEndereco);
	}
	
	public void preencherRua(String rua) throws Exception{
		cadastro.findElementById("address-name").sendKeys(rua);
	}
	
	public void preencherNumero(String numero) throws Exception{
		cadastro.findElementById("address-number").sendKeys(numero);
	}
	
	public void preencherComplemento(String complemento) throws Exception{
		cadastro.findElementById("address-additional-info").sendKeys(complemento);
	}
	
	public void preencherBairro(String bairro) throws Exception{
		cadastro.findElementById("neighborhood").sendKeys(bairro);
	}
	
	public void preencherUf(String uf) throws Exception{
		Select estado = new Select(cadastro.findElementById("address-state"));
		estado.selectByValue(uf);
	}
	
	public void preencherCidade(String cidade) throws Exception{
		cadastro.findElementById("city").sendKeys(cidade);
	}
	
	public void preencherReferencia(String referencia) throws Exception{
		cadastro.findElementById("reference").sendKeys(referencia);
	}
	
	public void preencherEnderecoEntrega(String entrega) throws Exception{
		if(entrega.equals("Não")) cadastro.findElementById("shipping-address-customer").click();
	}
	
	public void preencherTelefone(String telefone) throws Exception{
		cadastro.findElementById("phones-home").sendKeys(telefone);
	}
	
	public void preencherOutroTelefone(String outroTelefone) throws Exception{
		cadastro.findElementById("phones-mobile").sendKeys(outroTelefone);
	}
	
	public void checarAndamentoPedido(String pedido) throws Exception{
		if(pedido.equals("Sim")) cadastro.findElementById("reference").click();
	}
	
	public void preencherSenha(String senha) throws Exception{
		cadastro.findElementById("password").sendKeys(senha);
	}
	
	public void checarReceberOferta(String oferta) throws Exception{
		if(oferta.equals("Não")) cadastro.findElementById("preferences-newsletter").click();
	}
	
	public void pressionarContinuar() throws Exception{
		cadastro.findElementById("save-register-natural").click();
	}
}
