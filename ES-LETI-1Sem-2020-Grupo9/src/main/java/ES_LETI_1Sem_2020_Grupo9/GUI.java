package ES_LETI_1Sem_2020_Grupo9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.apache.poi.poifs.filesystem.FileMagic;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

/**
 * The Class GUI (MAIN CLASS)
 */
public class GUI extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The file path. */
	private JTextField filePath;

	/** The loaded file. */
	private JTable loadedFile;

	/** The threshold 1. */
	private JTextField threshold_1;

	/** The threshold 2. */
	private JTextField threshold_2;

	/** The threshold 3. */
	private JTextField threshold_3;

	/** The threshold 4. */
	private JTextField threshold_4;

	/** The signal 1. */
	private JComboBox signal_1;

	/** The signal 2. */
	private JComboBox signal_2;

	/** The signal 3. */
	private JComboBox signal_3;

	/** The signal 4. */
	private JComboBox signal_4;

	/** The logic op 1. */
	private JComboBox logicOp_1;

	/** The logic op 2. */
	private JComboBox logicOp_2;

	/** The results table. */
	private JTable resultsTable;

	/** The Default Table Model. */
	private DefaultTableModel dtm;

	/** The quality report table. */
	private JTable qualityReportTable;

	/** The long method rules ListModel. */
	private DefaultListModel<String> longMethodRules_dlmodel = new DefaultListModel<>();

	/** The long method rules list. */
	private JList<String> longMethodRulesList;

	/** The feature envy rules ListModel. */
	private DefaultListModel<String> featureEnvyRules_dlmodel = new DefaultListModel<>();

	/** The feature envy rules list. */
	private JList<String> featureEnvyRulesList;

	/** The selected file. */
	private File ficheiroSelecionado;

	/** The excel matrix. */
	private static Vector<Vector<Object>> matrizExcel;

	/** The defect by method boolean vector. */
	private static Vector<Vector<Boolean>> defeitosPorMetodo;

	/** The columns from excel. */
	private static Vector<Object> colunasExcel;

	/** The File Chooser for a given file. */
	final static JFileChooser selecionadorFicheiro = new JFileChooser();

	/** The table from excel tab.*/
	private static JTable jtable;

	/** The iplasma DCI. */
	private int iPlasma_DCI = 0;

	/** The iplasma DII. */
	private int iPlasma_DII = 0;

	/** The iplasma ADCI. */
	private int iPlasma_ADCI = 0;

	/** The iplasma ADII. */
	private int iPlasma_ADII = 0;

	/** The pmd dci. */
	private int PMD_DCI = 0;

	/** The pmd dii. */
	private int PMD_DII = 0;

	/** The pmd adci. */
	private int PMD_ADCI = 0;

	/** The pmd adii. */
	private int PMD_ADII = 0;

	/** The user DCI. */
	private int user_DCI = 0;

	/** The user DII. */
	private int user_DII = 0;

	/** The user ADCI. */
	private int user_ADCI = 0;

	/** The user ADII. */
	private int user_ADII = 0;

	/** The long method rules. */
	public ArrayList<String> longMethodRules = new ArrayList<String>();

	/** The feature envy rules. */
	public ArrayList<String> featureEnvyRules = new ArrayList<String>();

	/**
	 * Launch the application initializing all vectors required.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		matrizExcel = new Vector<Vector<Object>>();
		colunasExcel = new Vector<Object>();
		defeitosPorMetodo = new Vector<Vector<Boolean>>();
		selecionadorFicheiro.setCurrentDirectory(new File(System.getProperty("user.home")));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame with panels, buttons and grids.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel excel = new JPanel();
		tabbedPane.addTab("Excel", null, excel, null);
		GridBagLayout gbl_excel = new GridBagLayout();
		gbl_excel.rowWeights = new double[] { 1.0, 0.0 };
		gbl_excel.columnWeights = new double[] { 0.0, 1.0 };
		excel.setLayout(gbl_excel);

		GridBagConstraints gbc_fileDisplay = new GridBagConstraints();
		gbc_fileDisplay.fill = GridBagConstraints.BOTH;
		gbc_fileDisplay.gridx = 1;
		gbc_fileDisplay.gridy = 0;
		jtable = new JTable(matrizExcel, colunasExcel);
		JScrollPane scrollPane_1 = new JScrollPane(jtable);
		jtable.setFillsViewportHeight(true);
		excel.add(scrollPane_1, gbc_fileDisplay);

		loadedFile = new JTable();
		GridBagConstraints gbc_loadedFile = new GridBagConstraints();
		gbc_loadedFile.insets = new Insets(0, 0, 5, 0);
		gbc_loadedFile.fill = GridBagConstraints.BOTH;
		gbc_loadedFile.gridx = 1;
		gbc_loadedFile.gridy = 0;
		excel.add(loadedFile, gbc_loadedFile);

		JPanel fileSearchPanel = new JPanel();
		GridBagConstraints gbc_fileSearchPanel = new GridBagConstraints();
		gbc_fileSearchPanel.gridx = 1;
		gbc_fileSearchPanel.gridy = 1;
		excel.add(fileSearchPanel, gbc_fileSearchPanel);

		filePath = new JTextField();
		fileSearchPanel.add(filePath);
		filePath.setColumns(50);
		
		/**
		 * Searches for the excel file
		 */

		JButton searchFileButton = new JButton("Search File");
		searchFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = selecionadorFicheiro.showOpenDialog(contentPane);
				if (result == JFileChooser.APPROVE_OPTION) {
					ficheiroSelecionado = selecionadorFicheiro.getSelectedFile();
					filePath.setText(ficheiroSelecionado.getAbsolutePath());
					System.out.println("selecionou o ficheiro: " + ficheiroSelecionado.getAbsolutePath());
				}
			}
		});
		fileSearchPanel.add(searchFileButton);
		
		/**
		 * Loads the excel file to the window
		 */

		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (ficheiroSelecionado != null && FileMagic.valueOf(ficheiroSelecionado).equals(FileMagic.OOXML)) {
						Workbook workbook = new XSSFWorkbook(ficheiroSelecionado);
						Sheet sheet = workbook.getSheetAt(0);
						Iterator<Row> iterator = sheet.iterator();
						colunasExcel.clear();
						matrizExcel.clear();
						int iter = 0;
						while (iterator.hasNext()) {
							if (iter > 0) {
								matrizExcel.add(new Vector<Object>());
							}
							Row linha = iterator.next();
							Iterator<Cell> iteratorCelula = linha.iterator();
							while (iteratorCelula.hasNext()) {
								Cell celula = iteratorCelula.next();
								if (iter == 0) {
									if (celula.getCellType() == CellType.STRING) {
										colunasExcel.add(celula.getStringCellValue());
									} else if (celula.getCellType() == CellType.NUMERIC) {
										colunasExcel.add(celula.getNumericCellValue());
									} else if (celula.getCellType() == CellType.BOOLEAN) {
										colunasExcel.add(celula.getBooleanCellValue());
									}
								} else {
									if (celula.getCellType() == CellType.STRING) {
										matrizExcel.get(iter - 1).add(celula.getStringCellValue());
									} else if (celula.getCellType() == CellType.NUMERIC) {
										matrizExcel.get(iter - 1).add(celula.getNumericCellValue());
									} else if (celula.getCellType() == CellType.BOOLEAN) {
										matrizExcel.get(iter - 1).add(celula.getBooleanCellValue());
									}
								}
							}
							iter++;
						}
						workbook.close();
						((DefaultTableModel) jtable.getModel()).fireTableStructureChanged();
					}
					System.out.println("ESTA É A MATRIZ " + matrizExcel.toString());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		fileSearchPanel.add(applyButton);

		JPanel rules = new JPanel();
		tabbedPane.addTab("Rules", null, rules, null);
		GridBagLayout gbl_rules = new GridBagLayout();
		gbl_rules.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_rules.rowHeights = new int[] { 0, 0, 35, 35, 35, 35, 35, 0, 0, 0 };
		gbl_rules.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_rules.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		rules.setLayout(gbl_rules);

		JLabel longMethodRulesLabel = new JLabel("LONG_METHOD CODE SMELL RULES");
		GridBagConstraints gbc_longMethodRulesLabel = new GridBagConstraints();
		gbc_longMethodRulesLabel.gridwidth = 6;
		gbc_longMethodRulesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_longMethodRulesLabel.gridx = 0;
		gbc_longMethodRulesLabel.gridy = 0;
		rules.add(longMethodRulesLabel, gbc_longMethodRulesLabel);

		JLabel featureEnvyRulesLabel = new JLabel("FEATURE_ENVY CODE SMELL RULES");
		GridBagConstraints gbc_featureEnvyRulesLabel = new GridBagConstraints();
		gbc_featureEnvyRulesLabel.gridwidth = 4;
		gbc_featureEnvyRulesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_featureEnvyRulesLabel.gridx = 6;
		gbc_featureEnvyRulesLabel.gridy = 0;
		rules.add(featureEnvyRulesLabel, gbc_featureEnvyRulesLabel);

		longMethodRulesList = new JList<>(longMethodRules_dlmodel);
		GridBagConstraints gbc_longMethodRulesList = new GridBagConstraints();
		gbc_longMethodRulesList.gridwidth = 6;
		gbc_longMethodRulesList.insets = new Insets(0, 0, 5, 5);
		gbc_longMethodRulesList.fill = GridBagConstraints.BOTH;
		gbc_longMethodRulesList.gridx = 0;
		gbc_longMethodRulesList.gridy = 1;
		rules.add(longMethodRulesList, gbc_longMethodRulesList);

		featureEnvyRulesList = new JList<>(featureEnvyRules_dlmodel);
		GridBagConstraints gbc_featureEnvyRulesList = new GridBagConstraints();
		gbc_featureEnvyRulesList.gridwidth = 4;
		gbc_featureEnvyRulesList.insets = new Insets(0, 0, 5, 5);
		gbc_featureEnvyRulesList.fill = GridBagConstraints.BOTH;
		gbc_featureEnvyRulesList.gridx = 6;
		gbc_featureEnvyRulesList.gridy = 1;
		rules.add(featureEnvyRulesList, gbc_featureEnvyRulesList);

		JLabel metric_1 = new JLabel("LINES OF CODE - LOC");
		GridBagConstraints gbc_metric_1 = new GridBagConstraints();
		gbc_metric_1.gridwidth = 5;
		gbc_metric_1.insets = new Insets(0, 0, 5, 5);
		gbc_metric_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_1.gridx = 0;
		gbc_metric_1.gridy = 2;
		rules.add(metric_1, gbc_metric_1);

		signal_1 = new JComboBox(rules_list_operators.values());
		
		GridBagConstraints gbc_signal_1 = new GridBagConstraints();
		gbc_signal_1.insets = new Insets(0, 0, 5, 5);
		gbc_signal_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_signal_1.gridx = 6;
		gbc_signal_1.gridy = 2;
		rules.add(signal_1, gbc_signal_1);

		threshold_1 = new JTextField();
		GridBagConstraints gbc_threshold_1 = new GridBagConstraints();
		gbc_threshold_1.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_1.gridx = 7;
		gbc_threshold_1.gridy = 2;
		rules.add(threshold_1, gbc_threshold_1);
		threshold_1.setColumns(10);

		logicOp_1 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_1 = new GridBagConstraints();
		gbc_logicOp_1.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_1.gridx = 9;
		gbc_logicOp_1.gridy = 2;
		rules.add(logicOp_1, gbc_logicOp_1);

		JLabel metric_2 = new JLabel("CYCLOMATIC COMPLEXITY - CYCLO");
		GridBagConstraints gbc_metric_2 = new GridBagConstraints();
		gbc_metric_2.gridwidth = 5;
		gbc_metric_2.insets = new Insets(0, 0, 5, 5);
		gbc_metric_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_2.gridx = 0;
		gbc_metric_2.gridy = 3;
		rules.add(metric_2, gbc_metric_2);

		signal_2 = new JComboBox(rules_list_operators.values());
		GridBagConstraints gbc_signal_2 = new GridBagConstraints();
		gbc_signal_2.insets = new Insets(0, 0, 5, 5);
		gbc_signal_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_signal_2.gridx = 6;
		gbc_signal_2.gridy = 3;
		rules.add(signal_2, gbc_signal_2);
		rules_list_operators.values();

		threshold_2 = new JTextField();
		GridBagConstraints gbc_threshold_2 = new GridBagConstraints();
		gbc_threshold_2.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_2.gridx = 7;
		gbc_threshold_2.gridy = 3;
		rules.add(threshold_2, gbc_threshold_2);
		threshold_2.setColumns(10);

		JLabel metric_3 = new JLabel("ACCESS TO FOREIGN DATA - ATFD");
		GridBagConstraints gbc_metric_3 = new GridBagConstraints();
		gbc_metric_3.gridwidth = 5;
		gbc_metric_3.insets = new Insets(0, 0, 5, 5);
		gbc_metric_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_3.gridx = 0;
		gbc_metric_3.gridy = 4;
		rules.add(metric_3, gbc_metric_3);

		signal_3 = new JComboBox(rules_list_operators.values());
		GridBagConstraints gbc_signal_3 = new GridBagConstraints();
		gbc_signal_3.insets = new Insets(0, 0, 5, 5);
		gbc_signal_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_signal_3.gridx = 6;
		gbc_signal_3.gridy = 4;
		rules.add(signal_3, gbc_signal_3);

		threshold_3 = new JTextField();
		GridBagConstraints gbc_threshold_3 = new GridBagConstraints();
		gbc_threshold_3.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_3.gridx = 7;
		gbc_threshold_3.gridy = 4;
		rules.add(threshold_3, gbc_threshold_3);
		threshold_3.setColumns(10);

		logicOp_2 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_3 = new GridBagConstraints();
		gbc_logicOp_3.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_3.gridx = 9;
		gbc_logicOp_3.gridy = 4;
		rules.add(logicOp_2, gbc_logicOp_3);

		JLabel metric_4 = new JLabel("LOCALITY OF ATTRIBUTE ACCESSES - LAA");
		GridBagConstraints gbc_metric_4 = new GridBagConstraints();
		gbc_metric_4.gridwidth = 5;
		gbc_metric_4.insets = new Insets(0, 0, 5, 5);
		gbc_metric_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_4.gridx = 0;
		gbc_metric_4.gridy = 5;
		rules.add(metric_4, gbc_metric_4);

		signal_4 = new JComboBox(rules_list_operators.values());
		GridBagConstraints gbc_signal_4 = new GridBagConstraints();
		gbc_signal_4.insets = new Insets(0, 0, 5, 5);
		gbc_signal_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_signal_4.gridx = 6;
		gbc_signal_4.gridy = 5;
		rules.add(signal_4, gbc_signal_4);

		threshold_4 = new JTextField();
		GridBagConstraints gbc_threshold_4 = new GridBagConstraints();
		gbc_threshold_4.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_4.gridx = 7;
		gbc_threshold_4.gridy = 5;
		rules.add(threshold_4, gbc_threshold_4);
		threshold_4.setColumns(10);
		
		/**
		 * Apply user defined rules to search for code smells
		 */

		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (matrizExcel.size() > 0) {
					defeitosPorMetodo.clear();
					for (int x = 0; x < 420; x++) {
						Vector<Boolean> defeitosMetodoIDX = new Vector<Boolean>();
						int loc = (int) Double.parseDouble(matrizExcel.get(x).get(4).toString());
						int cyclo = (int) Double.parseDouble(matrizExcel.get(x).get(5).toString());
						int atfd = (int) Double.parseDouble(matrizExcel.get(x).get(6).toString());
						double laa = Double.parseDouble(matrizExcel.get(x).get(7).toString());
						if (longMethodRules_dlmodel.size() > 0) {
							defeitosMetodoIDX.add(isLongMethod(loc, cyclo));
						}
						if (featureEnvyRules_dlmodel.size() > 0) {
							defeitosMetodoIDX.add(hasFeatureEnvy(atfd, laa));
						}
						defeitosPorMetodo.add(defeitosMetodoIDX);
					}
					for (int i = 0; i < 420; i++) {
						int y = i + 1;
						dtm.setValueAt(y, i, 0);
						dtm.setValueAt(defeitosPorMetodo.get(i).get(0), i, 1);
						dtm.setValueAt(defeitosPorMetodo.get(i).get(1), i, 2);
						System.out.println(y + " isLongMethod,hasFeatureEnvy:" + defeitosPorMetodo.get(i));
					}
				} else {
					System.out.println(
							"Ficheiro Excel não foi carregado, por favor carrege o ficheiro e tente outra vez");
				}

			}
		});
		
		/**
		 * Button to save the user defined rules
		 */
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		
		/**
		 * Loads rules from a given file
		 */
		
		JButton loadButton = new JButton("Load");
		loadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadRulesfromFile();
			}
		});

		GridBagConstraints gbc_loadButton = new GridBagConstraints();
		gbc_loadButton.insets = new Insets(0, 0, 0, 5);
		gbc_loadButton.gridx = 0;
		gbc_loadButton.gridy = 8;
		rules.add(loadButton, gbc_loadButton);

		JButton editButton = new JButton("Edit");
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				edit();
			}
		});

		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.insets = new Insets(0, 0, 0, 5);
		gbc_editButton.gridx = 3;
		gbc_editButton.gridy = 8;
		rules.add(editButton, gbc_editButton);

		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 5;
		gbc_saveButton.gridy = 8;
		rules.add(saveButton, gbc_saveButton);
		GridBagConstraints gbc_runButton = new GridBagConstraints();
		gbc_runButton.fill = GridBagConstraints.BOTH;
		gbc_runButton.insets = new Insets(0, 0, 0, 5);
		gbc_runButton.gridx = 11;
		gbc_runButton.gridy = 8;
		rules.add(runButton, gbc_runButton);

		JPanel results = new JPanel();
		tabbedPane.addTab("Results", null, results, null);
		results.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane resultsScrollPane = new JScrollPane();
		results.add(resultsScrollPane);

		resultsTable = new JTable();
		dtm = (DefaultTableModel) resultsTable.getModel();
		dtm.setRowCount(420);
		dtm.addColumn("MethodID");
		dtm.addColumn("User_long");
		dtm.addColumn("User_feature");
		resultsTable.setModel(dtm);

		resultsScrollPane.setViewportView(resultsTable);

		JPanel quality_report = new JPanel();
		tabbedPane.addTab("Quality Report", null, quality_report, null);
		quality_report.setLayout(new BorderLayout(0, 0));
		
		/**
		 * Loads the quality classification
		 */

		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(filePath.getText());
				QualityChecker qc_iPlasma = new QualityChecker(9, filePath.getText());
				QualityChecker qc_PMD = new QualityChecker(10, filePath.getText());
				UserQualityChecker qc_User_Long = new UserQualityChecker("user_long", matrizExcel, dtm);
				UserQualityChecker qc_User_Feature = new UserQualityChecker("user_feature", matrizExcel, dtm);
				qc_iPlasma.start();
				qc_PMD.start();
				qc_User_Long.start();
				qc_User_Feature.start();
				try {
					qc_iPlasma.join();
					qc_PMD.join();
					qc_User_Long.join();
					qc_User_Feature.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				updateQualityValues(0, qc_iPlasma.getnDCI(), qc_iPlasma.getnDII(), qc_iPlasma.getnADCI(),
						qc_iPlasma.getnADII());
				updateQualityValues(1, qc_PMD.getnDCI(), qc_PMD.getnDII(), qc_PMD.getnADCI(), qc_PMD.getnADII());
				updateQualityValues(2, qc_User_Long.getnDCI(), qc_User_Long.getnDII(), qc_User_Long.getnADCI(),
						qc_User_Long.getnADII());
				updateQualityValues(3, qc_User_Feature.getnDCI(), qc_User_Feature.getnDII(), qc_User_Feature.getnADCI(),
						qc_User_Feature.getnADII());
			}

		});
		quality_report.add(updateButton, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		quality_report.add(scrollPane, BorderLayout.CENTER);

		qualityReportTable = new JTable();
		scrollPane.setViewportView(qualityReportTable);
		qualityReportTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		qualityReportTable
				.setModel(
						new DefaultTableModel(
								new Object[][] {
										{ "iPlasma", new Integer(0), new Integer(0), new Integer(0), new Integer(0) },
										{ "PMD", new Integer(0), new Integer(0), new Integer(0), new Integer(0) },
										{ "User_long", new Integer(0), new Integer(0), new Integer(0), new Integer(0) },
										{ "User_feature", new Integer(0), new Integer(0), new Integer(0),
												new Integer(0) }, },
								new String[] { "Tools", "DCI", "DII", "ADCI", "ADII" }) {
							Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class,
									Integer.class, Integer.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
	}
	
	/**
	 * Edits the user rule
	 */

	protected void edit() {
		boolean ruleSelected = false;
		boolean isLongMethodRule = true;
		if (longMethodRulesList.getSelectedValue() != null) {
			ruleSelected = true;
		} else if (featureEnvyRulesList.getSelectedValue() != null) {
			ruleSelected = true;
			isLongMethodRule = false;
		}
		if (ruleSelected != false) {
			if (isLongMethodRule) {
				if (textFieldIsEmpty(threshold_3) && textFieldIsEmpty(threshold_4)) {
					if (!textFieldIsEmpty(threshold_1) || !textFieldIsEmpty(threshold_2)) {
						save();
					} else {
						System.out.println(
								"Please insert at least one value for any metric of the rule you are editing!");
					}
				} else {
					System.out.println(
							"Please ensure all values except the ones you can and want to change for the rule you are editing are clear!");
				}
			} else {
				if (textFieldIsEmpty(threshold_1) && textFieldIsEmpty(threshold_2)) {
					if (!textFieldIsEmpty(threshold_3) || !textFieldIsEmpty(threshold_4)) {
						save();
					} else {
						System.out.println(
								"Please insert at least one value for any metric of the rule you are editing!");
					}
				} else {
					System.out.println(
							"Please ensure all values except the ones you can and want to change for the rule you are editing are clear!");
				}
			}
		} else {
			System.out.println("A rule must be selected for editing to be possible!");
		}
	}

	/**
	 * Given the number of lines of codes and the cyclomatic complexity of the
	 * method size checks if the method isLongMethod.
	 *
	 * @param loc   the number of lines of code
	 * @param cyclo the cyclomatic complexity of the method
	 * @return true, if is long method
	 */
	protected boolean isLongMethod(int loc, int cyclo) {
		// defined by LOC and CYCLO
		boolean isAND = false; // if rule contains an AND, this will be true, if false, rule contains an OR
		int rules = 0;
		int locTreshold = 0;
		int cycloTreshold = 0;
		int islocTreshold = -1; // if 1, the next number parsed will be the locTreshold, if 0, the next number
								// parsed will be the cyclo treshold
		boolean locBiggerThan = false;
		boolean cycloBiggerThan = false;
		for (int i = 0; i < longMethodRules.size(); i++) {
			try {
				Integer.parseInt(longMethodRules.get(i));
				if (islocTreshold == 1) {
					locTreshold = Integer.parseInt(longMethodRules.get(i));
				} else if (islocTreshold == 0) {
					cycloTreshold = Integer.parseInt(longMethodRules.get(i));
				}
			} catch (NumberFormatException e) {
				if (longMethodRules.get(i).equals("LOC")) {
					rules++;
					islocTreshold = 1;
				} else if (longMethodRules.get(i).equals("CYCLO")) {
					rules++;
					islocTreshold = 0;
				} else if (longMethodRules.get(i).equals("AND")) {
					isAND = true;
				} else if (longMethodRules.get(i).equals("BIGGER_THAN")) {
					if (islocTreshold == 1) {
						locBiggerThan = true;
					}
					if (islocTreshold == 0) {
						cycloBiggerThan = true;
					}
				}
			}
		}
		if (rules > 1 && cycloTreshold != 0 && locTreshold != 0) {
			if (isAND) {
				if (cycloBiggerThan && locBiggerThan) {
					return ((cyclo > cycloTreshold && loc > locTreshold));
				}
				if (cycloBiggerThan && !locBiggerThan) {
					return (cyclo > cycloTreshold && loc < locTreshold);
				}
				if (!cycloBiggerThan && !locBiggerThan) {
					return (cyclo < cycloTreshold && loc < locTreshold);
				}
				if (!cycloBiggerThan && locBiggerThan) {
					return (cyclo < cycloTreshold && loc > locTreshold);
				}
			}
			if (!isAND) {
				if (cycloBiggerThan && locBiggerThan) {
					return (cyclo > cycloTreshold || loc > locTreshold);
				}
				if (cycloBiggerThan && !locBiggerThan) {
					return (cyclo > cycloTreshold || loc < locTreshold);
				}
				if (!cycloBiggerThan && !locBiggerThan) {
					return (cyclo < cycloTreshold || loc < locTreshold);
				}
				if (!cycloBiggerThan && locBiggerThan) {
					return (cyclo < cycloTreshold || loc > locTreshold);
				}
			}
		} else if (rules > 0) {
			if (locTreshold != 0) {
				if (locBiggerThan) {
					return (loc > locTreshold);
				} else {
					return (loc < locTreshold);
				}
			} else {
				if (cycloBiggerThan) {
					return (cyclo > cycloTreshold);
				} else {
					return (cyclo < cycloTreshold);
				}
			}
		}
		return false;
	}

	/**
	 * given two parameters checks if the code has heature envy.
	 *
	 * @param atfd the acessos do método a métodos de outras classes
	 * @param laa  the acessos do método a atributos da própria classe
	 * @return true, if successful
	 */
	protected boolean hasFeatureEnvy(int atfd, double laa) {
		// defined by LOC and CYCLO
		boolean isAND = false; // if rule contains an AND, this will be true, if false, rule contains an OR
		int rules = 0;
		double laaTreshold = 0;
		int atfdTreshold = 0;
		int islaaTreshold = -1; // if 1, the next number parsed will be the laaTreshold, if 0, the next number
								// parsed will be the atfd treshold
		boolean atfdBiggerThan = false;
		boolean laaBiggerThan = false;
		for (int i = 0; i < featureEnvyRules.size(); i++) {
			try {
				Double.parseDouble(featureEnvyRules.get(i));
				if (islaaTreshold == 1) {
					laaTreshold = Double.parseDouble(featureEnvyRules.get(i));
				} else {
					atfdTreshold = Integer.parseInt(featureEnvyRules.get(i));
				}
			} catch (NumberFormatException e) {
				if (featureEnvyRules.get(i).equals("LAA")) {
					rules++;
					islaaTreshold = 1;
				} else if (featureEnvyRules.get(i).equals("ATFD")) {
					rules++;
					islaaTreshold = 0;
				} else if (featureEnvyRules.get(i).equals("AND")) {
					isAND = true;
				} else if (featureEnvyRules.get(i).equals("BIGGER_THAN")) {
					if (islaaTreshold == 1) {
						laaBiggerThan = true;
					}
					if (islaaTreshold == 0) {
						atfdBiggerThan = true;
					}
				}
			}
		}
		if (rules > 1 && atfdTreshold != 0 && laaTreshold != 0) {
			if (isAND) {
				if (atfdBiggerThan && laaBiggerThan) {
					return (atfd > atfdTreshold && laa > laaTreshold);
				}
				if (atfdBiggerThan && !laaBiggerThan) {
					return (atfd > atfdTreshold && laa < laaTreshold);
				}
				if (!atfdBiggerThan && !laaBiggerThan) {
					return (atfd < atfdTreshold && laa < laaTreshold);
				}
				if (!atfdBiggerThan && laaBiggerThan) {
					return (atfd < atfdTreshold && laa > laaTreshold);
				}
			}
			if (!isAND) {
				if (atfdBiggerThan && laaBiggerThan) {
					return (atfd > atfdTreshold || laa > laaTreshold);
				}
				if (atfdBiggerThan && !laaBiggerThan) {
					return (atfd > atfdTreshold || laa < laaTreshold);
				}
				if (!atfdBiggerThan && !laaBiggerThan) {
					return (atfd < atfdTreshold || laa < laaTreshold);
				}
				if (!atfdBiggerThan && laaBiggerThan) {
					return (atfd < atfdTreshold || laa > laaTreshold);
				}
			}
		} else if (rules > 0) {
			if (laaTreshold != 0) {
				if (laaBiggerThan) {
					return (laa > laaTreshold);
				} else {
					return (laa < laaTreshold);
				}
			} else {
				if (atfdBiggerThan) {
					return (atfd > atfdTreshold);
				} else {
					return (atfd < atfdTreshold);
				}
			}
		}
		return false;
	}

	/**
	 * updates values to excel file.
	 *
	 * @param index the index
	 * @param nDCI  the n DCI
	 * @param nDII  the n DII
	 * @param nADCI the n ADCI
	 * @param nADII the n ADII
	 */
	protected void updateQualityValues(int index, int nDCI, int nDII, int nADCI, int nADII) {
		qualityReportTable.setValueAt(nDCI, index, 1);
		qualityReportTable.setValueAt(nDII, index, 2);
		qualityReportTable.setValueAt(nADCI, index, 3);
		qualityReportTable.setValueAt(nADII, index, 4);
	}

	/**
	 * resets rules on the GUI.
	 */
	protected void clearRulesGUI() {
		threshold_1.setText("");
		threshold_2.setText("");
		threshold_3.setText("");
		threshold_4.setText("");
		signal_1.setSelectedIndex(0);
		signal_2.setSelectedIndex(0);
		signal_3.setSelectedIndex(0);
		signal_4.setSelectedIndex(0);
		logicOp_1.setSelectedIndex(0);
		logicOp_2.setSelectedIndex(0);
	}

	/**
	 * Loads rules from txt file.
	 */
	protected void loadRulesfromFile() {
		longMethodRules_dlmodel.clear();
		featureEnvyRules_dlmodel.clear();
		longMethodRules.clear();
		featureEnvyRules.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("long_method_rules.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitted = line.split(" ");
				for (int i = 0; i < splitted.length; i++) {
					longMethodRules.add(splitted[i]);
				}
				longMethodRules_dlmodel.addElement(line);
			}
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader("feature_envy_rules.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitted = line.split(" ");
				for (int i = 0; i < splitted.length; i++) {
					featureEnvyRules.add(splitted[i]);
				}
				featureEnvyRules_dlmodel.addElement(line);
			}
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * checks if text field is empty.
	 *
	 * @param tf the textfield
	 * @return true, if successful
	 */
	private boolean textFieldIsEmpty(JTextField tf) {
		try {
			tf.getText();
			if (tf.getText().isBlank()) {
				return true;
			}
		} catch (NullPointerException np) {
			return true;
		}
		return false;
	}

	/**
	 * saves the current configuration.
	 */
	protected void save() {
		boolean longMethodRulesDefined = true;
		boolean featureEnvyRulesDefined = true;
		try {
			Integer.parseInt(threshold_1.getText().toString());
			longMethodRules.clear();
			longMethodRules.add("LOC");
			longMethodRules.add(signal_1.getSelectedItem().toString());
			longMethodRules.add(threshold_1.getText().toString());
			if (logicOp_1.getSelectedItem().toString() != "END") {
				try {
					Integer.parseInt(threshold_2.getText().toString());
					longMethodRules.add(logicOp_1.getSelectedItem().toString());
					longMethodRules.add("CYCLO");
					longMethodRules.add(signal_2.getSelectedItem().toString());
					longMethodRules.add(threshold_2.getText().toString());
				} catch (NumberFormatException t2) {
					System.out.println("user defined a logical operator but did not define one of the conditions");
				}
			}
		} catch (NumberFormatException t1) {
			try {
				Integer.parseInt(threshold_2.getText().toString());
				longMethodRules.clear();
				longMethodRules.add("CYCLO");
				longMethodRules.add(signal_2.getSelectedItem().toString());
				longMethodRules.add(threshold_2.getText().toString());
			} catch (NumberFormatException t2) {
				longMethodRulesDefined = false;
			}
		}
		try {
			Integer.parseInt(threshold_3.getText().toString());
			featureEnvyRules.clear();
			featureEnvyRules.add("ATFD");
			featureEnvyRules.add(signal_3.getSelectedItem().toString());
			featureEnvyRules.add(threshold_3.getText().toString());
			if (logicOp_2.getSelectedItem().toString() != "END") {
				try {
					Double.parseDouble(threshold_4.getText().toString());
					featureEnvyRules.add(logicOp_2.getSelectedItem().toString());
					featureEnvyRules.add("LAA");
					featureEnvyRules.add(signal_4.getSelectedItem().toString());
					featureEnvyRules.add(threshold_4.getText().toString());
				} catch (NumberFormatException t4) {
					System.out.println("user defined a logical operator but did not define one of the conditions");
				}
			}
		} catch (NumberFormatException t3) {
			try {
				Double.parseDouble(threshold_4.getText().toString());
				featureEnvyRules.clear();
				featureEnvyRules.add("LAA");
				featureEnvyRules.add(signal_4.getSelectedItem().toString());
				featureEnvyRules.add(threshold_4.getText().toString());
			} catch (NumberFormatException t4) {
				featureEnvyRulesDefined = false;
			}
		}
		System.out.println(longMethodRules);
		System.out.println(featureEnvyRules);
		try {
			if (longMethodRulesDefined) {
				FileWriter writer1 = new FileWriter("long_method_rules.txt", false);
				BufferedWriter bw1 = new BufferedWriter(writer1);
				for (String str : longMethodRules) {
					bw1.write(str + " ");
				}
				bw1.write("\n");
				bw1.close();
				longMethodRules.clear();
			}
			if (featureEnvyRulesDefined) {
				FileWriter writer2 = new FileWriter("feature_envy_rules.txt", false);
				BufferedWriter bw2 = new BufferedWriter(writer2);
				for (String str : featureEnvyRules) {
					bw2.write(str + " ");
				}
				bw2.write("\n");
				bw2.close();
				featureEnvyRules.clear();
			}
			if (longMethodRulesDefined || featureEnvyRulesDefined) {
				loadRulesfromFile();
			}
		} catch (IOException e) {
		}
	}
	
	public void setLongMethodRules(ArrayList<String> longMethodRules) {
		this.longMethodRules = longMethodRules;
	}

	public void setFeatureEnvyRules(ArrayList<String> featureEnvyRules) {
		this.featureEnvyRules = featureEnvyRules;
	}

/////////////////////GETERS FOR TESTS ////////////////////
	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getFilePath() {
		return filePath;
	}

	public JTable getLoadedFile() {
		return loadedFile;
	}

	public JTextField getThreshold_1() {
		return threshold_1;
	}

	public JTextField getThreshold_2() {
		return threshold_2;
	}

	public JTextField getThreshold_3() {
		return threshold_3;
	}

	public JTextField getThreshold_4() {
		return threshold_4;
	}

	public JComboBox getSignal_1() {
		return signal_1;
	}

	public JComboBox getSignal_2() {
		return signal_2;
	}

	public JComboBox getSignal_3() {
		return signal_3;
	}

	public JComboBox getSignal_4() {
		return signal_4;
	}

	public JComboBox getLogicOp_1() {
		return logicOp_1;
	}

	public JComboBox getLogicOp_2() {
		return logicOp_2;
	}

	public JTable getResultsTable() {
		return resultsTable;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JTable getQualityReportTable() {
		return qualityReportTable;
	}

	public DefaultListModel<String> getLongMethodRules_dlmodel() {
		return longMethodRules_dlmodel;
	}

	public JList<String> getLongMethodRulesList() {
		return longMethodRulesList;
	}

	public DefaultListModel<String> getFeatureEnvyRules_dlmodel() {
		return featureEnvyRules_dlmodel;
	}

	public JList<String> getFeatureEnvyRulesList() {
		return featureEnvyRulesList;
	}

	public static JTable getJtable() {
		return jtable;
	}

	public int getiPlasma_DCI() {
		return iPlasma_DCI;
	}

	public int getiPlasma_DII() {
		return iPlasma_DII;
	}

	public int getiPlasma_ADCI() {
		return iPlasma_ADCI;
	}

	public int getiPlasma_ADII() {
		return iPlasma_ADII;
	}

	public int getPMD_DCI() {
		return PMD_DCI;
	}

	public int getPMD_DII() {
		return PMD_DII;
	}

	public int getPMD_ADCI() {
		return PMD_ADCI;
	}

	public int getPMD_ADII() {
		return PMD_ADII;
	}

	public int getUser_DCI() {
		return user_DCI;
	}

	public int getUser_DII() {
		return user_DII;
	}

	public int getUser_ADCI() {
		return user_ADCI;
	}

	public int getUser_ADII() {
		return user_ADII;
	}

	public ArrayList<String> getLongMethodRules() {
		return longMethodRules;
	}

	public ArrayList<String> getFeatureEnvyRules() {
		return featureEnvyRules;
	}

}