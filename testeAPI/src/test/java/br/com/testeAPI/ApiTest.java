package br.com.testeAPI;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;


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

    public void consultaCEP() throws Exception {
       
    	given()
        .when()
           .get()
        .then()
           .statusCode(200)
           .body("cep", is(DadosExecucao.getMassaHash("CEP_RETORNADO")))
           .body("Logradouro", is(DadosExecucao.getMassaHash("LOGRADOURO")))
           .body("Complemento", is(DadosExecucao.getMassaHash("COMPLEMENTO")))
           .body("bairro", is(DadosExecucao.getMassaHash("BAIRRO")))
           .body("Localidade", is(DadosExecucao.getMassaHash("LOCALIDADE")))
           .body("uf", is(DadosExecucao.getMassaHash("UF")))
           .body("unidade", is(""))
		   .body("ibge", is(DadosExecucao.getMassaHash("IBGE")))
		   .body("gia", is(""))
           .assertThat()
           .body(matchesJsonSchemaInClasspath("schema_consulta_cep.json"));
    }

    public void consultaCEPInvalido() throws Exception {
        
    	given()
        .when()
           .get()
        .then()
           .statusCode(400);
    }
  
}
