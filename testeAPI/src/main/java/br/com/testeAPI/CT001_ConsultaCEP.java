package br.com.testeAPI;


import org.junit.Before;
import org.junit.Test;


/**
 * Teste API - Consulta CEP
 */
public class CT001_ConsultaCEP 
{
	public String CEP;
	
	@Before
	public void preConditions() throws Exception {
		DadosExecucao dado = new DadosExecucao();  
		dado.beforeScenario(this.getClass().getSimpleName());
	}
	
	@Test
    public void main() throws Exception   {
		
		ApiTest apiTest = new ApiTest();
		apiTest.consultaCEP();
    }
}
