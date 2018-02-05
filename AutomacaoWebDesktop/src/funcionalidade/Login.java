package funcionalidade;

import pageObjects.PageLogin;
import pageObjects.PagePrincipal;
import resource.DadosExecucao;

public class Login {


	public void logon() throws Exception {
		PageLogin pageLogin = new PageLogin();
		pageLogin.preencherUsuario(DadosExecucao.getMassaHash("USUARIO"));
		pageLogin.preencherSenha(DadosExecucao.getMassaHash("SENHA"));
		pageLogin.pressionarLogin();
		
	}

	public void novaConta() throws Exception {
		PageLogin pageLogin = new PageLogin();
		pageLogin.preencherNovaConta(DadosExecucao.getMassaHash("USUARIO"));
		pageLogin.pressionarNovaConta();
		
	}
	
	public void logoff() throws Exception {
		PagePrincipal pagePrincipal = new PagePrincipal();
		pagePrincipal.pressionarLogoff();
		
	}

}
