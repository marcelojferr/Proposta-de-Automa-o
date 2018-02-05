package pageObjects;

import org.openqa.selenium.remote.RemoteWebDriver;

import resource.webPage;;

public class PageLogin extends webPage {
	RemoteWebDriver login = browser;

	public PageLogin() throws Exception{
		Thread.sleep(2000);
		if(login.findElementById("username").isDisplayed())  
			System.out.println("Pagina Login carregada!");
	}
	
	public void preencherUsuario(String usuario) throws Exception{
		login.findElementById("username").sendKeys(usuario);
	}

	public void preencherSenha(String senha) throws Exception{
		login.findElementById("password").sendKeys(senha);
	}
	
	public void pressionarLogin() throws Exception{
		login.findElementById("login-button").click();
	}
	
	public void preencherNovaConta(String usuario) throws Exception{
		login.findElementById("sign-up-username").sendKeys(usuario);
	}
	
	public void pressionarNovaConta() throws Exception{
		login.findElementById("verify-email-button").click();
	}
	
}
