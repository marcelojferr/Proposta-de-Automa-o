package br.com.testeAPI;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.equalTo; 

/**
 * Unit test for simple App.
 */
public class ApiTest {
	
	public String CEP;
	
    /**
     * Create the test case
     */
    public ApiTest()    {
    	CEP 	= DadosExecucao.getMassaHash("CEP");
    	baseURI = "https://viacep.com.br/ws/" + CEP + "/json/";
    }

    public void consultaCEP() throws Throwable {
    	
    	RequestSpecification httpRequest = RestAssured.given();
	    	Response response = httpRequest.get();
	    	response.then()
	    		.statusCode(equalTo(200))
	    		.body("cep", equalTo(DadosExecucao.getMassaHash("CEP_RETORNADO")))
		        .body("logradouro", equalTo(DadosExecucao.getMassaHash("LOGRADOURO")))
		        .body("complemento", equalTo(DadosExecucao.getMassaHash("COMPLEMENTO")))
		        .body("bairro", equalTo(DadosExecucao.getMassaHash("BAIRRO")))
		        .body("localidade", equalTo(DadosExecucao.getMassaHash("LOCALIDADE")))
		        .body("uf", equalTo(DadosExecucao.getMassaHash("UF")))
		        .body("unidade", equalTo(""))
				.body("ibge", equalTo(DadosExecucao.getMassaHash("IBGE")))
				.body("gia", equalTo(""));
	    	
	    	System.out.println("CEP válido! " + response.getBody().asString());
	}
}
