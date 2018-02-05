package br.com.testeAPI;

import java.util.Enumeration;
import java.util.Hashtable;


public class DadosExecucao {
	
	private static String nomeCenarioExecucao;
	private static String nomeFeatureExecucao;
	private static String idExecucao;
	private static Hashtable<String, String> massaHash;
	private static Hashtable<String, String> dadosFuncionalidade = new Hashtable<String, String>();
	private static String msgErro;
	
	
	public static String getMsgErro() {
		return msgErro;
	}

	public static void setMsgErro(String msgErro) {
		DadosExecucao.msgErro = msgErro;
	}

	public static String getDadosFuncionalidade(String chave) {
		return dadosFuncionalidade.get(chave);
	}
	
	public static void setDadosFuncionalidade(String chave, String valor) {
		dadosFuncionalidade.put(chave,valor);
	}

	public static String getMassaHash(String chave) {
		return massaHash.get(chave);
	}
	
	public static String getAllMassaHash() {
		Enumeration<String>  keys = massaHash.keys();
		
		String conteudo = "";
		while (keys.hasMoreElements()) {
			String chave = keys.nextElement();
			conteudo += chave + ": " + massaHash.get(chave) + "\n" ;
		}
		
		return conteudo;
	}

	public static void setMassaHash(Hashtable<String, String> massaHash) {
		DadosExecucao.massaHash = massaHash;
	}

	public static String getNomeCenarioExecucao() {
		return nomeCenarioExecucao;
	}

	public static void setNomeCenarioExecucao(String nomeCenarioExecucao) {
		DadosExecucao.nomeCenarioExecucao = nomeCenarioExecucao;
	}

	public static String getNomeFeatureExecucao() {
		return nomeFeatureExecucao;
	}

	public static void setNomeFeatureExecucao(String nomeFeatureExecucao) {
		DadosExecucao.nomeFeatureExecucao = nomeFeatureExecucao;
	}

	public static String getIdExecucao() {
		return idExecucao;
	}

	public static void setIdExecucao(String idExecucao) {
		DadosExecucao.idExecucao = idExecucao;
	}

	public void beforeScenario(String string) throws Exception {
		Evidencias.inicializaContadorAcao();
		DadosExecucao.setNomeCenarioExecucao(string);
		
		ExcelUtils massa = new ExcelUtils("massaDados/" + DadosExecucao.getNomeCenarioExecucao() + ".xlsx");
		DadosExecucao.setMassaHash(massa.carregarMassaHash());
		
	}
}
