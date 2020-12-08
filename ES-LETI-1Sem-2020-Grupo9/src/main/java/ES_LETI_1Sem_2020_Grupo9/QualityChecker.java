package ES_LETI_1Sem_2020_Grupo9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * The Class QualityChecker.
 */
public class QualityChecker extends Thread {

	/** The n column. */
	private int nColumn;
	
	/** The file path. */
	private String filePath;
	
	/** The número de Ausências de Defeitos Corretamente
Identificadas */
	private int nDCI;
	
	/** The número de Ausências de Defeitos Incorretamente Identificadas */
	private int nDII;
	
	/** The número de Ausências de Defeitos Corretamente
Identificadas */
	private int nADCI;
	
	/** The número de Ausências de Defeitos Incorretamente Identificadas */
	private int nADII;
	
	/**
	 * receives two parameters and sets values.
	 *
	 * @param nColumn the n column
	 * @param filePath the file path
	 */
	public QualityChecker(int nColumn, String filePath) {
		this.nColumn = nColumn;
		this.filePath = filePath;
	}
	
	/**
	 * Reads excel file and sets variable values.
	 */
	@Override
	public void run() {
	
		try {
			InputStream ExcelFileToRead = new FileInputStream(filePath);
	        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
	        XSSFSheet sheet = wb.getSheetAt(0);
	        
	        int aux;
	        String auxS = sheet.getRow(0).getCell(nColumn).getStringCellValue();
	        if(auxS.equals("PMD") || auxS.equals("iPlasma") || auxS.equals("user_long"))
	        	aux = 8;
	        else
	        	aux = 11;
	        		
	        for (int i = 1; i < 421; i++) {
				if (sheet.getRow(i).getCell(nColumn).getBooleanCellValue() == true && sheet.getRow(i).getCell(aux).getBooleanCellValue() == true) {
					nDCI = nDCI + 1;					
				}
				else if (sheet.getRow(i).getCell(nColumn).getBooleanCellValue() == true && sheet.getRow(i).getCell(aux).getBooleanCellValue() == false) {
					nDII = nDII + 1;
				}
				else if (sheet.getRow(i).getCell(nColumn).getBooleanCellValue() == false && sheet.getRow(i).getCell(aux).getBooleanCellValue() == false) {
					nADCI = nADCI + 1;
				}
				else if (sheet.getRow(i).getCell(nColumn).getBooleanCellValue() == false && sheet.getRow(i).getCell(aux).getBooleanCellValue() == true) {
					nADII = nADII +1;
				}
	        }
	        
	        wb.close();
	        ExcelFileToRead.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file selected or wrong path to file !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the column.
	 *
	 * @return the column
	 */
	public int getnColumn() {
		return nColumn;
	}
	
	/**
	 * Sets the n column.
	 *
	 * @param nColumn the new n column
	 */
	public void setnColumn(int nColumn) {
		this.nColumn = nColumn;
	}

	/**
	 * Gets the número de Defeitos Corretamente Identificados
	 *
	 * @return the número de Defeitos Corretamente Identificados
	 */
	public int getnDCI() {
		return nDCI;
	}

	/**
	 * Sets the número de Defeitos Corretamente Identificados
	 *
	 * @param nDCI the new número de Defeitos Corretamente Identificados
	 */
	public void setnDCI(int nDCI) {
		this.nDCI = nDCI;
	}

	/**
	 * Gets the número de Defeitos Incorretamente Identificados
	 *
	 * @return the número de Defeitos Incorretamente Identificados
	 */
	public int getnDII() {
		return nDII;
	}

	/**
	 * Sets the número de Defeitos Incorretamente Identificados
	 *
	 * @param nDII the new número de Defeitos Incorretamente Identificados
	 */
	public void setnDII(int nDII) {
		this.nDII = nDII;
	}

	/**
	 * Gets the número de Ausências de Defeitos Corretamente
Identificadas
	 *
	 * @return the número de Ausências de Defeitos Corretamente
Identificadas
	 */
	public int getnADCI() {
		return nADCI;
	}

	/**
	 * Sets the número de Ausências de Defeitos Corretamente
Identificadas
	 *
	 * @param nADCI the new número de Ausências de Defeitos Corretamente
Identificadas
	 */
	public void setnADCI(int nADCI) {
		this.nADCI = nADCI;
	}

	/**
	 * Gets the número de Ausências de Defeitos Incorretamente Identificadas
	 *
	 * @return the número de Ausências de Defeitos Incorretamente Identificadas
	 */
	public int getnADII() {
		return nADII;
	}

	/**
	 * Sets the número de Ausências de Defeitos Incorretamente Identificadas
	 *
	 * @param nADII the new número de Ausências de Defeitos Incorretamente Identificadas
	 */
	public void setnADII(int nADII) {
		this.nADII = nADII;
	}
	
	
}
