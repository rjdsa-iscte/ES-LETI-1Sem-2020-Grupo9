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

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTable table_2;
	private File ficheiroSelecionado;
	final static JFileChooser selecionadorFicheiro = new JFileChooser();

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
		
		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 0);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 1;
		gbc_table_1.gridy = 0;
		excel.add(table_1, gbc_table_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		excel.add(panel, gbc_panel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		JButton search = new JButton("Search File");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = selecionadorFicheiro.showOpenDialog(contentPane);
				if (result == JFileChooser.APPROVE_OPTION) {
				    ficheiroSelecionado = selecionadorFicheiro.getSelectedFile();
				    System.out.println("selecionou o ficheiro: " + ficheiroSelecionado.getAbsolutePath());
				}
			}
		});
		panel.add(search);
		
		JButton Apply = new JButton("Apply");
		panel.add(Apply);
		
		JPanel rules = new JPanel();
		tabbedPane.addTab("Rules", null, rules, null);
		GridBagLayout gbl_rules = new GridBagLayout();
		gbl_rules.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_rules.rowHeights = new int[]{0, 0, 35, 35, 35, 35, 35, 0, 0, 0};
		gbl_rules.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_rules.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		rules.setLayout(gbl_rules);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 2;
		gbc_list.gridwidth = 13;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		rules.add(list, gbc_list);
		
		JComboBox comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 5;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 0;
		gbc_comboBox_2.gridy = 2;
		rules.add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox_4 = new JComboBox();
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 6;
		gbc_comboBox_4.gridy = 2;
		rules.add(comboBox_4, gbc_comboBox_4);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 7;
		gbc_textField_2.gridy = 2;
		rules.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_5 = new JComboBox();
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_5.gridx = 9;
		gbc_comboBox_5.gridy = 2;
		rules.add(comboBox_5, gbc_comboBox_5);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 5;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		rules.add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 6;
		gbc_comboBox_1.gridy = 3;
		rules.add(comboBox_1, gbc_comboBox_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 3;
		rules.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 9;
		gbc_comboBox_3.gridy = 3;
		rules.add(comboBox_3, gbc_comboBox_3);
		
		JComboBox comboBox_6 = new JComboBox();
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.gridwidth = 5;
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_6.gridx = 0;
		gbc_comboBox_6.gridy = 4;
		rules.add(comboBox_6, gbc_comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		GridBagConstraints gbc_comboBox_7 = new GridBagConstraints();
		gbc_comboBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_7.gridx = 6;
		gbc_comboBox_7.gridy = 4;
		rules.add(comboBox_7, gbc_comboBox_7);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 7;
		gbc_textField_4.gridy = 4;
		rules.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_8 = new JComboBox();
		GridBagConstraints gbc_comboBox_8 = new GridBagConstraints();
		gbc_comboBox_8.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_8.gridx = 9;
		gbc_comboBox_8.gridy = 4;
		rules.add(comboBox_8, gbc_comboBox_8);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_save = new GridBagConstraints();
		gbc_save.insets = new Insets(0, 0, 5, 5);
		gbc_save.gridx = 11;
		gbc_save.gridy = 4;
		rules.add(save, gbc_save);
		
		JComboBox comboBox_9 = new JComboBox();
		GridBagConstraints gbc_comboBox_9 = new GridBagConstraints();
		gbc_comboBox_9.gridwidth = 5;
		gbc_comboBox_9.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_9.gridx = 0;
		gbc_comboBox_9.gridy = 5;
		rules.add(comboBox_9, gbc_comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		GridBagConstraints gbc_comboBox_10 = new GridBagConstraints();
		gbc_comboBox_10.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_10.gridx = 6;
		gbc_comboBox_10.gridy = 5;
		rules.add(comboBox_10, gbc_comboBox_10);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 7;
		gbc_textField_5.gridy = 5;
		rules.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox_11 = new JComboBox();
		GridBagConstraints gbc_comboBox_11 = new GridBagConstraints();
		gbc_comboBox_11.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_11.gridx = 9;
		gbc_comboBox_11.gridy = 5;
		rules.add(comboBox_11, gbc_comboBox_11);
		
		JButton btnNewButton = new JButton("Delete all");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 5;
		rules.add(btnNewButton, gbc_btnNewButton);
		
		JComboBox comboBox_12 = new JComboBox();
		GridBagConstraints gbc_comboBox_12 = new GridBagConstraints();
		gbc_comboBox_12.gridwidth = 5;
		gbc_comboBox_12.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_12.gridx = 0;
		gbc_comboBox_12.gridy = 6;
		rules.add(comboBox_12, gbc_comboBox_12);
		
		JComboBox comboBox_13 = new JComboBox();
		GridBagConstraints gbc_comboBox_13 = new GridBagConstraints();
		gbc_comboBox_13.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_13.gridx = 6;
		gbc_comboBox_13.gridy = 6;
		rules.add(comboBox_13, gbc_comboBox_13);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 7;
		gbc_textField_6.gridy = 6;
		rules.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox_14 = new JComboBox();
		GridBagConstraints gbc_comboBox_14 = new GridBagConstraints();
		gbc_comboBox_14.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_14.gridx = 9;
		gbc_comboBox_14.gridy = 6;
		rules.add(comboBox_14, gbc_comboBox_14);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 5;
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 8;
		rules.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton run = new JButton("RUN");
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton load = new JButton("Load");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_load = new GridBagConstraints();
		gbc_load.insets = new Insets(0, 0, 0, 5);
		gbc_load.gridx = 8;
		gbc_load.gridy = 8;
		rules.add(load, gbc_load);
		GridBagConstraints gbc_run = new GridBagConstraints();
		gbc_run.fill = GridBagConstraints.BOTH;
		gbc_run.insets = new Insets(0, 0, 0, 5);
		gbc_run.gridx = 11;
		gbc_run.gridy = 8;
		rules.add(run, gbc_run);
		
		JPanel results = new JPanel();
		tabbedPane.addTab("Results", null, results, null);
		results.setLayout(new GridLayout(0, 1, 0, 0));
		
		table = new JTable();
		results.add(table);
		
		JPanel quality_report = new JPanel();
		tabbedPane.addTab("Quality Report", null, quality_report, null);
		quality_report.setLayout(new GridLayout(1, 0, 0, 0));
		
		table_2 = new JTable();
		quality_report.add(table_2);
	}

}
