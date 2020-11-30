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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.poifs.filesystem.FileMagic;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel; 


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField filePath;
	private JTable loadedFile;
	private JTextField threshold_1;
	private JTextField threshold_2;
	private JTextField threshold_3;
	private JTextField threshold_4;
	private JTextField threshold_5;
	private JComboBox metric_1;
	private JComboBox signal_1;
	private JComboBox logicOp_1;
	private JComboBox metric_2;
	private JComboBox signal_2;
	private JComboBox logicOp_2;
	private JComboBox metric_3;
	private JComboBox signal_3;
	private JComboBox logicOp_3;
	private JComboBox metric_4;
	private JComboBox signal_4;
	private JComboBox logicOp_4;
	private JComboBox metric_5;
	private JComboBox signal_5;
	private JComboBox logicOp_5;
	private JComboBox<String> codeSmellCB;
	private JTable resultsTable;
	private JTable qualityReportTable;
	private DefaultListModel<String> longMethodRules_dlmodel = new DefaultListModel<>();
	private JList<String> longMethodRulesList;
	private DefaultListModel<String> featureEnvyRules_dlmodel = new DefaultListModel<>();
	private JList<String> featureEnvyRulesList;
	private File ficheiroSelecionado;
	private static Vector<Vector<Object>> matrizExcel;
	private static Vector<Object> colunasExcel;
	final static JFileChooser selecionadorFicheiro = new JFileChooser();
	private static JTable jtable;
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
	public ArrayList<String> rules_list = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		matrizExcel = new Vector<Vector<Object>>();
		colunasExcel = new Vector<Object>();
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
		
		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(ficheiroSelecionado != null && FileMagic.valueOf(ficheiroSelecionado).equals(FileMagic.OOXML)) {
						Workbook workbook = new XSSFWorkbook(ficheiroSelecionado);
			            Sheet sheet = workbook.getSheetAt(0);
			            Iterator<Row> iterator = sheet.iterator();
			            colunasExcel.clear();
			            matrizExcel.clear();
			            int iter = 0;
			            while (iterator.hasNext()) {
			            	if(iter > 0) {
			            		 matrizExcel.add(new Vector<Object>());
			            	}
			                Row linha = iterator.next();			               
			                Iterator<Cell> iteratorCelula = linha.iterator();
			                while (iteratorCelula.hasNext()) {
			                	Cell celula = iteratorCelula.next();
			                	if(iter == 0) {
			                		if (celula.getCellType()  == CellType.STRING) {
				                    	colunasExcel.add(celula.getStringCellValue());
				                    } else if (celula.getCellType() == CellType.NUMERIC) {
				                    	colunasExcel.add(celula.getNumericCellValue());
				                    }else if(celula.getCellType() == CellType.BOOLEAN) {
				                    	colunasExcel.add(celula.getBooleanCellValue());
				                    }
			                	}else {
			                		if (celula.getCellType()  == CellType.STRING) {
			                			matrizExcel.get(iter - 1).add(celula.getStringCellValue());
			                		}else if (celula.getCellType() == CellType.NUMERIC) {
			                			matrizExcel.get(iter - 1).add(celula.getNumericCellValue());
			                		}else if(celula.getCellType() == CellType.BOOLEAN) {
			                			matrizExcel.get(iter - 1).add(celula.getBooleanCellValue());
			                		}
			                	}	
			                }
			                iter++;
			            }
			            ((DefaultTableModel)jtable.getModel()).fireTableStructureChanged();
					}
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
		gbl_rules.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_rules.rowHeights = new int[]{0, 0, 35, 35, 35, 35, 35, 0, 0, 0};
		gbl_rules.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_rules.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		metric_1 = new JComboBox(rules_list_functions.values());
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
		
		metric_2 = new JComboBox(rules_list_functions.values());
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
		
		threshold_2 = new JTextField();
		GridBagConstraints gbc_threshold_2 = new GridBagConstraints();
		gbc_threshold_2.insets = new Insets(0, 0, 5, 5);
		gbc_threshold_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_threshold_2.gridx = 7;
		gbc_threshold_2.gridy = 3;
		rules.add(threshold_2, gbc_threshold_2);
		threshold_2.setColumns(10);
		
		logicOp_2 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_2 = new GridBagConstraints();
		gbc_logicOp_2.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_2.gridx = 9;
		gbc_logicOp_2.gridy = 3;
		rules.add(logicOp_2, gbc_logicOp_2);
		
		metric_3 = new JComboBox(rules_list_functions.values());
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
		
		logicOp_3 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_3 = new GridBagConstraints();
		gbc_logicOp_3.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_3.gridx = 9;
		gbc_logicOp_3.gridy = 4;
		rules.add(logicOp_3, gbc_logicOp_3);
		
		metric_4 = new JComboBox(rules_list_functions.values());
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
		
		logicOp_4 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_4 = new GridBagConstraints();
		gbc_logicOp_4.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_4.gridx = 9;
		gbc_logicOp_4.gridy = 5;
		rules.add(logicOp_4, gbc_logicOp_4);
		
		metric_5 = new JComboBox(rules_list_functions.values());
		GridBagConstraints gbc_metric_5 = new GridBagConstraints();
		gbc_metric_5.gridwidth = 5;
		gbc_metric_5.insets = new Insets(0, 0, 5, 5);
		gbc_metric_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_metric_5.gridx = 0;
		gbc_metric_5.gridy = 6;
		rules.add(metric_5, gbc_metric_5);
		
		signal_5 = new JComboBox(rules_list_operators.values());
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
		
		logicOp_5 = new JComboBox(rules_list_logical.values());
		GridBagConstraints gbc_logicOp_5 = new GridBagConstraints();
		gbc_logicOp_5.insets = new Insets(0, 0, 5, 5);
		gbc_logicOp_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_logicOp_5.gridx = 9;
		gbc_logicOp_5.gridy = 6;
		rules.add(logicOp_5, gbc_logicOp_5);
		
		codeSmellCB = new JComboBox();
		codeSmellCB.setModel(new DefaultComboBoxModel(new String[] {"LONG_METHOD", "FEATURE_ENVY"}));
		GridBagConstraints gbc_codeSmellCB = new GridBagConstraints();
		gbc_codeSmellCB.gridwidth = 5;
		gbc_codeSmellCB.insets = new Insets(0, 0, 5, 5);
		gbc_codeSmellCB.fill = GridBagConstraints.HORIZONTAL;
		gbc_codeSmellCB.gridx = 0;
		gbc_codeSmellCB.gridy = 7;
		rules.add(codeSmellCB, gbc_codeSmellCB);
		
		JButton runButton = new JButton("RUN");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rules_list.add(metric_1.getSelectedItem().toString());
				rules_list.add(signal_1.getSelectedItem().toString());
				rules_list.add(threshold_1.getText().toString());
				rules_list.add(logicOp_1.getSelectedItem().toString());
				
				if(logicOp_1.getSelectedItem().toString()!="END") {
				rules_list.add(metric_2.getSelectedItem().toString());
				rules_list.add(signal_2.getSelectedItem().toString());
				rules_list.add(threshold_2.getText().toString());
				rules_list.add(logicOp_2.getSelectedItem().toString());
				}
				
				if(logicOp_2.getSelectedItem().toString() !="END") {
				rules_list.add(metric_3.getSelectedItem().toString());
				rules_list.add(signal_3.getSelectedItem().toString());
				rules_list.add(threshold_3.getText().toString());
				rules_list.add(logicOp_3.getSelectedItem().toString());
				}
				
				if(logicOp_3.getSelectedItem().toString()!="END") {
				rules_list.add(metric_4.getSelectedItem().toString());
				rules_list.add(signal_4.getSelectedItem().toString());
				rules_list.add(threshold_4.getText().toString());
				rules_list.add(logicOp_4.getSelectedItem().toString());
				}									
				if(logicOp_4.getSelectedItem().toString()!="END") {
					rules_list.add(metric_5.getSelectedItem().toString());
					rules_list.add(signal_5.getSelectedItem().toString());
					rules_list.add(threshold_5.getText().toString());
					rules_list.add(logicOp_5.getSelectedItem().toString());
					}	
				rules_list.remove(rules_list.size()-1);
				System.out.println(rules_list);
				
				
				try {
					String aux;
					if(codeSmellCB.getSelectedItem().equals("LONG_METHOD"))
						aux = "long_method_rules.txt";
					else 
						aux = "feature_envy_rules.txt";
					FileWriter writer = new FileWriter(aux,true);
					BufferedWriter bw = new BufferedWriter(writer);
			    	for(String str: rules_list) {
					  bw.write(str +" ");
					}
			    	bw.write("\n");
					bw.close();
					rules_list.clear();
					loadRulesfromFile();

				}
				catch ( IOException e)
				{
				}
				
			}
			
		});
		
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
				
				clearRulesGUI();
				
				//GETS SELECTED RULE TO STRING ARRAY
				
				String a;
				if(longMethodRulesList.isSelectionEmpty())
					a = featureEnvyRulesList.getSelectedValue().toString();
				else
					a = longMethodRulesList.getSelectedValue().toString();
				String[] words = new String[20];
				String[] aux = a.split(" ");;
				
				for (int i = 0; i < aux.length; i++) {
					words[i] = aux[i];
				}
				
				words[aux.length] = "END";
				
				//DELETES RULE FROM FILE AND UPDATES GUI
				
				try {
					if(longMethodRulesList.isSelectionEmpty())
						removeLineFromFile(a, new File("feature_envy_rules.txt"));
					else
						removeLineFromFile(a, new File("long_method_rules.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				loadRulesfromFile();
				
				//SHOWS SELECTED RULE ON GUI
				
				metric_1.setSelectedItem(rules_list_functions.valueOf(words[0]));
				signal_1.setSelectedItem(rules_list_operators.valueOf(words[1]));
				threshold_1.setText(words[2]);
				logicOp_1.setSelectedItem(rules_list_logical.valueOf(words[3]));
				
				if(aux.length > 4) {
				metric_2.setSelectedItem(rules_list_functions.valueOf(words[4]));
				signal_2.setSelectedItem(rules_list_operators.valueOf(words[5]));
				threshold_2.setText(words[6]);
				logicOp_2.setSelectedItem(rules_list_logical.valueOf(words[7]));
				}
				
				if(aux.length > 8) {
				metric_3.setSelectedItem(rules_list_functions.valueOf(words[8]));
				signal_3.setSelectedItem(rules_list_operators.valueOf(words[9]));
				threshold_3.setText(words[10]);
				logicOp_3.setSelectedItem(rules_list_logical.valueOf(words[11]));
				}
				
				if(aux.length > 12) {
				metric_4.setSelectedItem(rules_list_functions.valueOf(words[12]));
				signal_4.setSelectedItem(rules_list_operators.valueOf(words[13]));
				threshold_4.setText(words[14]);
				logicOp_4.setSelectedItem(rules_list_logical.valueOf(words[15]));
				}
				
				if(aux.length > 16) {
				metric_5.setSelectedItem(rules_list_functions.valueOf(words[16]));
				signal_5.setSelectedItem(rules_list_operators.valueOf(words[17]));
				threshold_5.setText(words[18]);
				logicOp_5.setSelectedItem(rules_list_logical.valueOf(words[19]));
				}
				
						
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
		
		JButton deleteAllButton = new JButton("Delete all");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rules_list.clear();
				System.out.println("list deleted");
			}
		});
		GridBagConstraints gbc_deleteAllButton = new GridBagConstraints();
		gbc_deleteAllButton.anchor = GridBagConstraints.WEST;
		gbc_deleteAllButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteAllButton.gridx = 7;
		gbc_deleteAllButton.gridy = 8;
		rules.add(deleteAllButton, gbc_deleteAllButton);
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
				QualityChecker qc_iPlasma = new QualityChecker(9, filePath.getText());
				QualityChecker qc_PMD = new QualityChecker(10, filePath.getText());
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
	
	private void clearRulesGUI() {
		metric_1.setSelectedIndex(-1);
		signal_1.setSelectedIndex(-1);
		threshold_1.setText("");
		logicOp_1.setSelectedIndex(0);
		metric_2.setSelectedIndex(-1);
		signal_2.setSelectedIndex(-1);
		threshold_2.setText("");
		logicOp_2.setSelectedIndex(0);
		metric_3.setSelectedIndex(-1);
		signal_3.setSelectedIndex(-1);
		threshold_3.setText("");
		logicOp_3.setSelectedIndex(0);
		metric_4.setSelectedIndex(-1);
		signal_4.setSelectedIndex(-1);
		threshold_4.setText("");
		logicOp_4.setSelectedIndex(0);
		metric_5.setSelectedIndex(-1);
		signal_5.setSelectedIndex(-1);
		threshold_5.setText("");
		logicOp_5.setSelectedIndex(0);
	}
	
	private void loadRulesfromFile() {
		longMethodRules_dlmodel.clear();
		featureEnvyRules_dlmodel.clear();
		try { 
			BufferedReader br = new BufferedReader(new FileReader("long_method_rules.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				longMethodRules_dlmodel.addElement(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try { 
			BufferedReader br = new BufferedReader(new FileReader("feature_envy_rules.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				featureEnvyRules_dlmodel.addElement(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void removeLineFromFile(String lineToRemove, File f) throws FileNotFoundException, IOException{
	    //Reading File Content and storing it to a StringBuilder variable ( skips lineToRemove)
	    StringBuilder sb = new StringBuilder();
	    try (Scanner sc = new Scanner(f)) {
	        String currentLine;
	        while(sc.hasNext()){
	            currentLine = sc.nextLine();
	            if(currentLine.equals(lineToRemove)){
	                continue; //skips lineToRemove
	            }
	            sb.append(currentLine).append("\n");
	        }
	    }
	    //Delete File Content
	    PrintWriter pw = new PrintWriter(f);
	    pw.close();

	    BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
	    writer.append(sb.toString());
	    writer.close();
	}
	
}