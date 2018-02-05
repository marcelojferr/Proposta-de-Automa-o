package br.com.testeAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Clase que encapsula as operações com Excel
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public class ExcelUtils {
	private String fileName;
	private XSSFWorkbook wb;
	private XSSFSheet planilha;

	/**
	 * Construtor vazio da classe, permitindo que se escolha o arquivo a ser
	 * aberto através dos métodos setNomePlanilha
	 */
	public ExcelUtils() {
	}

	/**
	 * Construtor com parâmetro de nome do arquivo, permitindo a abertura de
	 * qualquer arquivo do excel
	 * 
	 * @param fileName
	 *            nome do arquivo a ser aberto
	 */
	public ExcelUtils(String fileName) {
		this.fileName = fileName;
		this.abrePlanilha();
	}

	/**
	 * Método que retorna o objeto manipulador de arquivos do excel
	 * 
	 * @return atributo do tipo XSSFSheet {@link XSSFSheet}
	 */
	public XSSFSheet getPlanilha() {
		return this.planilha;
	}

	/**
	 * Método que retorna o nome do arquivo
	 * 
	 * @return String com o caminho do arquivo aberto
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Método que retorna a planilha aberta
	 * 
	 * @return atributo do tipo XSSFWorkbook {@link XSSFWorkbook}
	 */
	public XSSFWorkbook getWorkBook() {
		return this.wb;
	}

	/**
	 * Método que abre a planilha
	 */
	public void abrePlanilha() {
		try {
			
			//FileInputStream fs = new FileInputStream(this.getFileName());
			//Workbook wb = Workbook.getWorkbook(fs);

			// TO get the access to the sheet
			//Sheet sh = wb.getSheet("Sheet1");

			// To get the number of rows present in sheet
			//int[] totalNoOfRows = sh.getRowBreaks();
			
			this.wb = new XSSFWorkbook(new FileInputStream(new File(this.getFileName())));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		this.planilha = this.getWorkBook().getSheetAt(0);
	}

	/**
	 * Método que grava as alterações efetuadas na planilha
	 */
	public void salvaPlanilha() {
		FileOutputStream arquivoSaida = null;
		try {
			arquivoSaida = new FileOutputStream(new File(this.getFileName()));
			this.getWorkBook().write(arquivoSaida);
			arquivoSaida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Método que pega o valor de uma célula em texto
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @return String com o texto contido na célula encontrada
	 */
	public String getTextoCelula(int linha, int coluna) {
		String textoCelula;
		try {
			textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();
		} catch (Exception ex) {
			textoCelula = Integer
					.toString((int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());
		}

		return textoCelula;
	}

	/**
	 * Método que pega o texto absoluto de uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @return String com o texto absoluto contido na célula encontrada
	 */
	public String getTextoSimplesCelula(int linha, int coluna) {
		String textoCelula;

		textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();

		String stringFormat = this.getPlanilha().getRow(linha).getCell(coluna).getCellStyle().getDataFormatString();
		CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
		textoCelula = fmt.format(this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());

		return textoCelula;
	}

	/**
	 * Método que pega o valor da célula em Double
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @return Double com o valor contido na célula encontrada
	 */
	public double getValorCelulaDouble(int linha, int coluna) {
		double valorCelula;
		try {
			valorCelula = this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Double.parseDouble(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}

		return valorCelula;

	}

	/**
	 * Método que pega o valor da célula em int
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @return inteiro com o valor contido na célula encontrada
	 */
	public int getValorCelulaInt(int linha, int coluna) {
		int valorCelula;
		try {
			valorCelula = (int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Integer.parseInt(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}

		return valorCelula;
	}

	/**
	 * Método que insere o valor em texto em uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @param value
	 *            String com o texto a ser inserido na célula
	 */
	public void setTextoCelula(int linha, int coluna, String value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}

	/**
	 * Método que insere o valor em Double em uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @param value
	 *            Double com o valor a ser inserido na célula
	 */
	public void setValorCelulaDouble(int linha, int coluna, double value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}

	/**
	 * Método que insere o valor em int em uma célula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da célula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da célula desejada, iniciando
	 *            em 0
	 * @param value
	 *            int ocm o valor a ser inserido na célula
	 */
	public void setValorCelulaInt(int linha, int coluna, int value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}

	/**
	 * Método que retorna lista com os itens de uma coluna
	 * 
	 * @param coluna
	 *            índice da coluna desejada
	 * @return List com os valores encontrados na coluna
	 */
	public List<String> itensColuna(Integer coluna) {
		List<String> valores = new ArrayList<String>();
		for (Row r : this.getWorkBook().getSheetAt(0)) {
			Cell c = r.getCell(coluna);
			if (c != null) {
				valores.add(c.getStringCellValue());
			}
		}

		return valores;
	}

	/**
	 * Método que procura um texto em uma planilha, e retorna o índice da linha
	 * onde o texto foi encontrado
	 * 
	 * @param textoCelula
	 *            valor a ser encontrado em uma célula
	 * @return número da linha onde o texto foi encontrado. Caso o texto não
	 *         tenha sido encontrado, retorna 1
	 */
	public int achaLinhaPorTexto(String textoCelula) {
		for (Row linha : this.getWorkBook().getSheetAt(0)) {
			for (Cell celula : linha) {
				if (celula.getCellType() == Cell.CELL_TYPE_STRING) {
					if (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
						return linha.getRowNum();
					}
				}
			}
		}
		return 1;
	}

	public int achaLinhaPorTextoR(String textoCelula) {
		for (Row linha : this.getWorkBook().getSheetAt(0)) {
			for (Cell celula : linha) {
				if (celula.getCellType() == Cell.CELL_TYPE_STRING) {
					if (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
						return linha.getRowNum();
					}
				}
			}
		}
		return -1;
	}
	/**
	 * Método retorna massa da planilha em um objeto HashTable
	 * 
	 * @return retorna HashTable
	 */
	public Hashtable<String, String> carregarMassaHash() {
		
		Hashtable<String, String> massa = new Hashtable<String, String>();
		int coluna=0;
		
		while (this.getPlanilha().getRow(0).getCell(coluna) != null) {
			massa.put(getTextoCelula(0, coluna),getTextoCelula(1, coluna));
			coluna++;
		}
		return massa;	
	}
}
