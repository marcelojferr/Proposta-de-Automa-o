package br.com.testeAPI;

import org.junit.Before;
import org.junit.Test;


/**
 * Teste API - Consulta CEP
 */
public class CT002_ConsultaCEPInvalido 
{
	
	@Before
	public void preConditions() throws Exception {
		DadosExecucao dado = new DadosExecucao();  
		dado.beforeScenario(this.getClass().getSimpleName());
	}
	
	@Test
    public void main() throws Exception   {
		
		try{
			
			ApiTest apiTest = new ApiTest();
			apiTest.consultaCEP();
					
		}
		catch (Throwable e)	{
			System.out.println("CEP invalido! " + e.getMessage());
		
		}
	}
}
