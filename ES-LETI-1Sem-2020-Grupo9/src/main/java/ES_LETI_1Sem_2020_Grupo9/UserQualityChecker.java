package ES_LETI_1Sem_2020_Grupo9;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class UserQualityChecker extends Thread {
	
	private String type;
	private Vector<Vector<Object>> matriz;
	private DefaultTableModel results;
	private int nDCI;
	private int nDII;
	private int nADCI;
	private int nADII;
	
	public UserQualityChecker(String type, Vector<Vector<Object>> matriz, DefaultTableModel results) {
		this.type = type;
		this.matriz = matriz;
		this.results = results;
	}
	
	@Override
	public void run() {
		
		int excelColumn;
		int resultsColumn;
		
		if(type.equals("user_long")) {
			excelColumn = 8;
			resultsColumn = 1;
		}
		else {
			excelColumn = 11;
			resultsColumn = 2;
		}
		
		for (int i = 0; i < 420; i++) {
		
			if ((boolean) results.getValueAt(i, resultsColumn) == true && (boolean) matriz.get(i).get(excelColumn) == true) {
				nDCI = nDCI + 1;					
			}
			else if ((boolean) results.getValueAt(i, resultsColumn) == true && (boolean) matriz.get(i).get(excelColumn) == false) {
				nDII = nDII + 1;
			}
			else if ((boolean) results.getValueAt(i, resultsColumn) == false && (boolean) matriz.get(i).get(excelColumn) == false) {
				nADCI = nADCI + 1;
			}
			else if ((boolean) results.getValueAt(i, resultsColumn) == false && (boolean) matriz.get(i).get(excelColumn) == true) {
				nADII = nADII +1;
			}
        }
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DefaultTableModel getResults() {
		return results;
	}

	public void setResults(DefaultTableModel results) {
		this.results = results;
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
