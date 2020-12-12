package ES_LETI_1Sem_2020_Grupo9;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * The Class UserQualityChecker.
 */
public class UserQualityChecker extends Thread {

	/** The type. */
	private String type;

	/** The matrix. */
	private Vector<Vector<Object>> matriz;

	/** The results. */
	private DefaultTableModel results;

	/** The n Defeitos Corretamente Identificados. */
	private int nDCI;

	/** The n Defeitos Incorretamente Identificados . */
	private int nDII;

	/**
	 * The n Ausências de Defeitos Corretamente Identificadas.
	 */
	private int nADCI;

	/** The n Ausências de Defeitos Incorretamente Identificadas. */
	private int nADII;

	/**
	 * Instantiates a new user quality checker.
	 *
	 * @param type    the type
	 * @param matriz  the matriz
	 * @param results the results
	 */
	public UserQualityChecker(String type, Vector<Vector<Object>> matriz, DefaultTableModel results) {
		this.type = type;
		this.matriz = matriz;
		this.results = results;
	}

	/**
	 * function to sum the numbers on a given file.
	 */
	@Override
	public void run() {

		int excelColumn;
		int resultsColumn;

		if (type.equals("user_long")) {
			excelColumn = 8;
			resultsColumn = 1;
		} else {
			excelColumn = 11;
			resultsColumn = 2;
		}

		for (int i = 0; i < 420; i++) {

			if ((boolean) results.getValueAt(i, resultsColumn) == true
					&& (boolean) matriz.get(i).get(excelColumn) == true) {
				nDCI = nDCI + 1;
			} else if ((boolean) results.getValueAt(i, resultsColumn) == true
					&& (boolean) matriz.get(i).get(excelColumn) == false) {
				nDII = nDII + 1;
			} else if ((boolean) results.getValueAt(i, resultsColumn) == false
					&& (boolean) matriz.get(i).get(excelColumn) == false) {
				nADCI = nADCI + 1;
			} else if ((boolean) results.getValueAt(i, resultsColumn) == false
					&& (boolean) matriz.get(i).get(excelColumn) == true) {
				nADII = nADII + 1;
			}
		}
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public DefaultTableModel getResults() {
		return results;
	}

	/**
	 * Sets the results.
	 *
	 * @param results the new results
	 */
	public void setResults(DefaultTableModel results) {
		this.results = results;
	}

	/**
	 * Gets the number of Defeitos Corretamente Identificados.
	 *
	 * @return the numer of Defeitos Corretamente Identificados
	 */
	public int getnDCI() {
		return nDCI;
	}

	/**
	 * Sets the number of Defeitos Corretamente Identificados.
	 *
	 * @param nDCI the new n Defeitos Corretamente Identificados
	 */
	public void setnDCI(int nDCI) {
		this.nDCI = nDCI;
	}

	/**
	 * Gets the number of Defeitos Incorretamente Identificados.
	 *
	 * @return the number of Defeitos Incorretamente Identificados
	 */
	public int getnDII() {
		return nDII;
	}

	/**
	 * Sets the number of Defeitos Incorretamente Identificados.
	 *
	 * @param nDII the new number of Defeitos Incorretamente Identificados
	 */
	public void setnDII(int nDII) {
		this.nDII = nDII;
	}

	/**
	 * Gets the number of Ausências de Defeitos Corretamente Identificadas.
	 *
	 * @return the number of Ausências de Defeitos Corretamente Identificadas
	 */
	public int getnADCI() {
		return nADCI;
	}

	/**
	 * Sets the number of Ausências de Defeitos Corretamente Identificadas.
	 *
	 * @param nADCI the new number of Ausências de Defeitos Corretamente
	 *              Identificadas
	 */
	public void setnADCI(int nADCI) {
		this.nADCI = nADCI;
	}

	/**
	 * Gets the number of Ausências de Defeitos Corretamente Identificadas.
	 *
	 * @return the number of Ausências de Defeitos Corretamente Identificadas
	 */
	public int getnADII() {
		return nADII;
	}

	/**
	 * Sets the number of Ausências de Defeitos Corretamente Identificadas.
	 *
	 * @param nADII the new number of Ausências de Defeitos Corretamente
	 *              Identificadas
	 */
	public void setnADII(int nADII) {
		this.nADII = nADII;
	}

}
