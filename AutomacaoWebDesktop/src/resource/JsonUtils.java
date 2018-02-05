package resource;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.common.io.Files;

public class JsonUtils {
	private JSONObject json;
	
	public JsonUtils(){
		json = new JSONObject();
	}
	
	@SuppressWarnings("unchecked")
	public void adicionarChave(String chave, String valorChave) {
		json.put(chave, valorChave);
	}

	@SuppressWarnings("unchecked")
	public void adicionarChaveArray(String chave, String[] valorChave) {
		JSONArray conjunto = new JSONArray();

		for (String valor : valorChave) {
			conjunto.add(valor);
		}
		json.put(chave, conjunto);
	}

	public void gerarArquivoJson(String diretorio) throws IOException {
		Path file = Paths.get(diretorio + gerarNomeJson() + ".json");
		byte[] dados = json.toString().getBytes();
		Files.write(dados, file.toFile());
	}
	
	public String obterValorCampo(String chave) {
		if (json.containsKey(chave)) {
			return (String) json.get(chave);
		}
		return null;
	}

	public ArrayList<String> obterValorCampoArray( String chave) {
		if (json.containsKey(chave)) {

			JSONArray listaJSON = (JSONArray) json.get(chave);
			ArrayList<String> lista = new ArrayList<String>();

			for (int i = 0; i < listaJSON.size(); i++) {
				lista.add(listaJSON.get(i).toString());
			}
			return lista;
		}
		return null;
	}
	
	public String gerarNomeJson(){
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return formatter.format(today);
	}
	
	
}
