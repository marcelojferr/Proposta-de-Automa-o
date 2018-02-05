package resource;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.imageio.ImageIO;

public class Evidencias {
	
	private static String extensao = "png";
	private static String evidenciaHome = "evidencias/";
	private static Path diretorio;
	private static int contadorAcao;
	
	
	public static void evidenciarAcao(RenderedImage print, String comentario) throws IOException {
		 contadorAcao++;
		 File img = new File(diretorioEvidencia() + "/" + contadorAcao + "_" + comentario + "." + extensao);
		 ImageIO.write(print, extensao , img);
	}
	
	public static void gerarLogExecucao() throws IOException {
		String conteudo = DadosExecucao.getNomeCenarioExecucao() + "\n\n"; 
		conteudo += DadosExecucao.getAllMassaHash();
		conteudo += DadosExecucao.getMsgErro();
		conteudo += DadosExecucao.getDadosFuncionalidade("STATUS");

		Path file = Paths.get(diretorioEvidencia() + "/" + DadosExecucao.getNomeCenarioExecucao() + ".log");
		Files.write(file, conteudo.getBytes(), StandardOpenOption.CREATE);
	}
	
	public static String diretorioEvidencia() throws IOException {
		diretorio = Paths.get(evidenciaHome + DadosExecucao.getNomeCenarioExecucao()+ "/" +  DadosExecucao.getIdExecucao());
		Files.createDirectories(diretorio);
		
		return diretorio.toString();	
	}
	
	public static void inicializaContadorAcao() {
		contadorAcao = 0;
	}
	
}
