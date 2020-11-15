package GUI;

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
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField filePath;
	private JTable loadedFile;
	private JTextField threshold_2;
	private JTextField threshold_1;
	private JTextField rulesFilePath;
	private JTextField threshold_3;
	private JTextField threshold_4;
	private JTextField threshold_5;
	private JTable resultsTable;
	private JTable qualityReportTable;
	private File ficheiroSelecionado;
	final static JFileChooser selecionadorFicheiro = new JFileChooser();
	private int iPlasma_DCI = 0;
	private int iPlasma_DII = 0;
	private int iPlasma_ADCI = 0;
	private int iPlasma_ADII = 0;
	private int PMD_DCI = 0;
	private int PMD_DII = 0;
	private int PMD_ADCI = 0;
	private int PMD_ADII = 0;
	private int user_DCI = 0;
	private int user_DII = 0;
	private int user_ADCI = 0;
	private int user_ADII = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 * Create the frame.
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
		gbl_excel.rowWeights = new double[]{1.0, 0.0};
		gbl_excel.columnWeights = new double[]{0.0, 1.0};
		excel.setLayout(gbl_excel);
		
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
		filePath.setColumns(20);
		
		JButton searchFileButton = new JButton("Search File");
		searchFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = selecionadorFicheiro.showOpenDialog(contentPane);
				if (result == JFileChooser.APPROVE_OPTION) {
				    ficheiroSelecionado = selecionadorFicheiro.getSelectedFile();
				    System.out.println("selecionou o ficheiro: " + ficheiroSelecionado.getAbsolutePath());
				}
			}
		});
		fileSearchPanel.add(searchFileButton);
		
		JButton applyButton = new JButton("Apply");
		fileSearchPanel.add(applyButton);
		
		JPanel rules = new JPanel();
		tabbedPane.addTab("Rules", null, rules, null);
		GridBagLayout gbl_rules = new GridBagLayout();
		gbl_rules.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_rules.rowHeights = new int[]{0, 0, 35, 35, 35, 35, 35, 0, 0, 0};
		gbl_rules.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_rules.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		rules.setLayout(gbl_rules);
		
		JList rulesList = new JList();
		GridBagConstraints gbc_rulesList = new GridBagConstraints();
		gbc_rulesList.gridheight = 2;
		gbc_rulesList.gridwidth = 13;
		gbc_rulesList.insets = new Insets(0, 0, 5, 0);
		gbc_rulesList.fill = GridBagConstraints.BOTH;
		gbc_rulesList.gridx = 0;
		gbc_rulesList.gridy = 0;
		rules.add(rulesList, gbc_rulesList);
		
		JComboBox metric_1 = new JComboBox(rules_list_functions.values());
		GridBagConstraints gbc_metric_1 = new GridBagConstraints();
		gbc_metric_1.gridwidth = 5;
		gbc_metric_1.insets = new Insets(0, 0, 5, 5);
		gbc_metric_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_1.gridx = 0;
		gbc_metric_1.gridy = 2;
		rules.add(metric_1, gbc_metric_1);
		
		JComboBox signal_1 = new JComboBox(rules_list_operators.values());
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
		
		JComboBox logicOp_1 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_1 = new GridBagConstraints();
		gbc_logicOp_1.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_1.gridx = 9;
		gbc_logicOp_1.gridy = 2;
		rules.add(logicOp_1, gbc_logicOp_1);
		
		JComboBox metric_2 = new JComboBox(rules_list_functions.values());
		GridBagConstraints gbc_metric_2 = new GridBagConstraints();
		gbc_metric_2.gridwidth = 5;
		gbc_metric_2.insets = new Insets(0, 0, 5, 5);
		gbc_metric_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_2.gridx = 0;
		gbc_metric_2.gridy = 3;
		rules.add(metric_2, gbc_metric_2);
		
		JComboBox signal_2 = new JComboBox(rules_list_operators.values());
		GridBagConstraints gbc_signal_2 = new GridBagConstraints();
		gbc_signal_2.insets = new Insets(0, 0, 5, 5);
		gbc_signal_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_signal_2.gridx = 6;
		gbc_signal_2.gridy = 3;
		rules.add(signal_2, gbc_signal_2);
		
		threshold_2 = new JTextField();
		GridBagConstraints gbc_threshold_2 = new GridBagConstraints();
		gbc_threshold_2.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_2.gridx = 7;
		gbc_threshold_2.gridy = 3;
		rules.add(threshold_2, gbc_threshold_2);
		threshold_2.setColumns(10);
		
		JComboBox logicOp_2 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_2 = new GridBagConstraints();
		gbc_logicOp_2.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_2.gridx = 9;
		gbc_logicOp_2.gridy = 3;
		rules.add(logicOp_2, gbc_logicOp_2);
		
		JComboBox metric_3 = new JComboBox(rules_list_functions.values());
		GridBagConstraints gbc_metric_3 = new GridBagConstraints();
		gbc_metric_3.gridwidth = 5;
		gbc_metric_3.insets = new Insets(0, 0, 5, 5);
		gbc_metric_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_3.gridx = 0;
		gbc_metric_3.gridy = 4;
		rules.add(metric_3, gbc_metric_3);
		
		JComboBox signal_3 = new JComboBox(rules_list_operators.values());
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
		
		JComboBox logicOp_3 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_3 = new GridBagConstraints();
		gbc_logicOp_3.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_3.gridx = 9;
		gbc_logicOp_3.gridy = 4;
		rules.add(logicOp_3, gbc_logicOp_3);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 5, 5);
		gbc_saveButton.gridx = 11;
		gbc_saveButton.gridy = 4;
		rules.add(saveButton, gbc_saveButton);
		
		JComboBox metric_4 = new JComboBox(rules_list_functions.values());
		GridBagConstraints gbc_metric_4 = new GridBagConstraints();
		gbc_metric_4.gridwidth = 5;
		gbc_metric_4.insets = new Insets(0, 0, 5, 5);
		gbc_metric_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_4.gridx = 0;
		gbc_metric_4.gridy = 5;
		rules.add(metric_4, gbc_metric_4);
		
		JComboBox signal_4 = new JComboBox(rules_list_operators.values());
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
		
		JComboBox logicOp_4 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_4 = new GridBagConstraints();
		gbc_logicOp_4.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_4.gridx = 9;
		gbc_logicOp_4.gridy = 5;
		rules.add(logicOp_4, gbc_logicOp_4);
		
		JButton deleteAllButton = new JButton("Delete all");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_deleteAllButton = new GridBagConstraints();
		gbc_deleteAllButton.anchor = GridBagConstraints.WEST;
		gbc_deleteAllButton.insets = new Insets(0, 0, 5, 5);
		gbc_deleteAllButton.gridx = 11;
		gbc_deleteAllButton.gridy = 5;
		rules.add(deleteAllButton, gbc_deleteAllButton);
		
		JComboBox metric_5 = new JComboBox(rules_list_functions.values());
		GridBagConstraints gbc_metric_5 = new GridBagConstraints();
		gbc_metric_5.gridwidth = 5;
		gbc_metric_5.insets = new Insets(0, 0, 5, 5);
		gbc_metric_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_5.gridx = 0;
		gbc_metric_5.gridy = 6;
		rules.add(metric_5, gbc_metric_5);
		
		JComboBox signal_5 = new JComboBox(rules_list_operators.values());
		GridBagConstraints gbc_signal_5 = new GridBagConstraints();
		gbc_signal_5.insets = new Insets(0, 0, 5, 5);
		gbc_signal_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_signal_5.gridx = 6;
		gbc_signal_5.gridy = 6;
		rules.add(signal_5, gbc_signal_5);
		
		threshold_5 = new JTextField();
		GridBagConstraints gbc_threshold_5 = new GridBagConstraints();
		gbc_threshold_5.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_5.gridx = 7;
		gbc_threshold_5.gridy = 6;
		rules.add(threshold_5, gbc_threshold_5);
		threshold_5.setColumns(10);
		
		JComboBox logicOp_5 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_5 = new GridBagConstraints();
		gbc_logicOp_5.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_5.gridx = 9;
		gbc_logicOp_5.gridy = 6;
		rules.add(logicOp_5, gbc_logicOp_5);
		
		rulesFilePath = new JTextField();
		GridBagConstraints gbc_rulesFilePath = new GridBagConstraints();
		gbc_rulesFilePath.gridwidth = 5;
		gbc_rulesFilePath.insets = new Insets(0, 0, 0, 5);
		gbc_rulesFilePath.fill = GridBagConstraints.HORIZONTAL;
		gbc_rulesFilePath.gridx = 3;
		gbc_rulesFilePath.gridy = 8;
		rules.add(rulesFilePath, gbc_rulesFilePath);
		rulesFilePath.setColumns(10);
		
		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Rule_file_handler.load_file();
			}
		});
		GridBagConstraints gbc_loadButton = new GridBagConstraints();
		gbc_loadButton.insets = new Insets(0, 0, 0, 5);
		gbc_loadButton.gridx = 8;
		gbc_loadButton.gridy = 8;
		rules.add(loadButton, gbc_loadButton);
		
		JButton newFile_rules = new JButton("New");
		newFile_rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rule_file_handler.create_new();
				}
		});
		GridBagConstraints gbc_newFile_rules = new GridBagConstraints();
		gbc_newFile_rules.insets = new Insets(0, 0, 0, 5);
		gbc_newFile_rules.gridx = 9;
		gbc_newFile_rules.gridy = 8;
		rules.add(newFile_rules, gbc_newFile_rules);
		GridBagConstraints gbc_runButton = new GridBagConstraints();
		gbc_runButton.fill = GridBagConstraints.BOTH;
		gbc_runButton.insets = new Insets(0, 0, 0, 5);
		gbc_runButton.gridx = 11;
		gbc_runButton.gridy = 8;
		rules.add(runButton, gbc_runButton);
		
		JPanel results = new JPanel();
		tabbedPane.addTab("Results", null, results, null);
		results.setLayout(new GridLayout(0, 1, 0, 0));
		
		resultsTable = new JTable();
		results.add(resultsTable);
		
		JPanel quality_report = new JPanel();
		tabbedPane.addTab("Quality Report", null, quality_report, null);
		quality_report.setLayout(new BorderLayout(0, 0));
		
		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QualityChecker qc_iPlasma = new QualityChecker(9);
				QualityChecker qc_PMD = new QualityChecker(10);
				qc_iPlasma.start();
				qc_PMD.start();
				try {
					qc_iPlasma.join();
					qc_PMD.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				updateiPlasmaValues(qc_iPlasma.getnDCI(), qc_iPlasma.getnDII(), qc_iPlasma.getnADCI(), qc_iPlasma.getnADII());
				updatePMDValues(qc_PMD.getnDCI(), qc_PMD.getnDII(), qc_PMD.getnADCI(), qc_PMD.getnADII());
			}

		});
		quality_report.add(updateButton, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		quality_report.add(scrollPane, BorderLayout.CENTER);
		
		qualityReportTable = new JTable();
		scrollPane.setViewportView(qualityReportTable);
		qualityReportTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		qualityReportTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"iPlasma", iPlasma_DCI , iPlasma_DII, iPlasma_ADCI, iPlasma_ADII},
				{"PMD", PMD_DCI, PMD_DII, PMD_ADCI, PMD_ADII},
				{"User", user_DCI, user_DII, user_ADCI, user_ADII},
			},
			new String[] {
				"Tools", "DCI", "DII", "ADCI", "ADII"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
	
	private void updateiPlasmaValues(int nDCI, int nDII, int nADCI, int nADII) {
		qualityReportTable.setValueAt(nDCI, 0, 1);
		qualityReportTable.setValueAt(nDII, 0, 2);
		qualityReportTable.setValueAt(nADCI, 0, 3);
		qualityReportTable.setValueAt(nADII, 0, 4);
	}
	
	private void updatePMDValues(int nDCI, int nDII, int nADCI, int nADII) {
		qualityReportTable.setValueAt(nDCI, 1, 1);
		qualityReportTable.setValueAt(nDII, 1, 2);
		qualityReportTable.setValueAt(nADCI, 1, 3);
		qualityReportTable.setValueAt(nADII, 1, 4);
	}

}
