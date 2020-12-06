package ES_LETI_1Sem_2020_Grupo9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QualityChecker extends Thread {

	private int nColumn;
	private String filePath;
	private int nDCI;
	private int nDII;
	private int nADCI;
	private int nADII;
	
	public QualityChecker(int nColumn, String filePath) {
		this.nColumn = nColumn;
		this.filePath = filePath;
	}

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

	public int getnColumn() {
		return nColumn;
	}

	public void setnColumn(int nColumn) {
		this.nColumn = nColumn;
	}

	public int getnDCI() {
		return nDCI;
	}

	public void setnDCI(int nDCI) {
		this.nDCI = nDCI;
	}

	public int getnDII() {
		return nDII;
	}

	public void setnDII(int nDII) {
		this.nDII = nDII;
	}

	public int getnADCI() {
		return nADCI;
	}

	public void setnADCI(int nADCI) {
		this.nADCI = nADCI;
	}

	public int getnADII() {
		return nADII;
	}

	public void setnADII(int nADII) {
		this.nADII = nADII;
	}
	
	
}
