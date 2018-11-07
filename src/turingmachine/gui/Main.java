package turingmachine.gui;

/**
 Copyright 2015 Kutay Bezci 
 This file is part of Turing Machine Simulation

 Turing machine simulation is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Turing machine simulation is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with  Turing machine simulation.  If not, see <http://www.gnu.org/licenses/>.
 */
import turingmachine.machine.Configuration;
import turingmachine.machine.State;
import turingmachine.machine.State.TapeOperation;
import turingmachine.machine.TuringMachine;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URI;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBlankSymbol;
	private JTable table;
	private JButton btnDelete;
	private JScrollPane scrollPane_1;
	private JButton btnRunMachine;
	private JButton btnCopyResult;
	private JLabel lblTapeInput;
	private JLabel lblOperationLog;
	private JLabel lblTapeOutput;
	private JScrollPane scrollPane_2;
	private JTextPane textPaneOutput;
	private JTextPane textPaneInput;
	private static JTextArea textArea;

	private static final String VERSION = "1.1";
	private static final String APPLICATION_NAME = "Turing Machine Simulation";
	private static final String ABOUT_CONTENT = "Version: " + VERSION + "\n"
			+ APPLICATION_NAME + " is a complete turing machine\n"
			+ "Programmed by Kutay Bezci kutay.bezci@gmail.com\n"
			+ "Feel free to send bug reports\n"
			+ "Licensed under GNU GPL. Open source\n"
			+ "Goto project home page for documentation\n";
	private static final String VERSION_FILE_URL = "http://sourceforge.net/projects/turingmachineinterpretor/files/LatestVersion.txt/download";
	private static final String PROJECT_URL = "https://sourceforge.net/projects/turingmachineinterpretor/";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PrintStream origOut = System.out;
		PrintStream interceptor = new Interceptor(origOut);
		System.setOut(interceptor);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VersionChecker versionChecker = new VersionChecker(VERSION,
							APPLICATION_NAME, VERSION_FILE_URL);
					versionChecker.start();
					Main frame = new Main();
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
	public Main() {//imgVslDirection = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/images/vslL.jpg"));>

		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("turing.png")));
		setTitle("Turing Machine Simulation");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 595);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnNewMenu = new JMenu("Save");
		mnFile.add(mnNewMenu);

		JMenuItem mntmSaveConfigration = new JMenuItem("Configration");
		mntmSaveConfigration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChoser = new JFileChooser();
				if (fileChoser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					save(fileChoser.getSelectedFile());

				}
			}
		});
		mnNewMenu.add(mntmSaveConfigration);

		JMenu mnLoad = new JMenu("Load");
		mnFile.add(mnLoad);

		JMenuItem mntmLoadConfigration = new JMenuItem("Configration");
		mntmLoadConfigration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChoser = new JFileChooser();
				if (fileChoser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					load(fileChoser.getSelectedFile());

				}
			}
		});
		mnLoad.add(mntmLoadConfigration);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								ABOUT_CONTENT,
								"Turing machine simulation",
								JOptionPane.OK_OPTION,
								new ImageIcon(Main.class
										.getResource("/gui/turing.png")));
			}
		});
		mnHelp.add(mntmAbout);

		JMenuItem mntmLatestRelease = new JMenuItem("Latest Release");
		mntmLatestRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(PROJECT_URL));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(Main.this, PROJECT_URL);
				}
			}
		});
		mnHelp.add(mntmLatestRelease);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Blank Symbol:");
		lblNewLabel_1.setBounds(12, 12, 123, 15);
		contentPane.add(lblNewLabel_1);

		textFieldBlankSymbol = new JTextField();
		textFieldBlankSymbol
				.setToolTipText("the blank symbol (the only symbol allowed to occur on the tape infinitely often at any step during the computation)");
		textFieldBlankSymbol.setBounds(125, 10, 40, 19);
		contentPane.add(textFieldBlankSymbol);
		textFieldBlankSymbol.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 47, 463, 212);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setToolTipText("Turing state table");
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null, null }, }, new String[] { "Turing State",
				"Tape Symbol", "Print Operation", "Tape Motion", "Next State" }) {
			Class[] columnTypes = new Class[] { String.class, String.class,
					String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setToolTipText("Insert row into turing state table");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel) (table.getModel())).addRow(new String[5]);
			}
		});
		btnInsert.setBounds(12, 273, 117, 25);
		contentPane.add(btnInsert);

		btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("Delete state from turing state table");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					((DefaultTableModel) (table.getModel())).removeRow(table
							.getSelectedRow());
				}
			}
		});
		btnDelete.setBounds(141, 273, 117, 25);
		contentPane.add(btnDelete);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 337, 463, 57);
		contentPane.add(scrollPane_1);

		textPaneInput = new JTextPane();
		textPaneInput
				.setToolTipText("Enter input for turing machine seperated by comma");
		scrollPane_1.setViewportView(textPaneInput);

		btnRunMachine = new JButton("Run Machine");
		btnRunMachine.setToolTipText("Start Turing machine");
		btnRunMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runMachine();
			}
		});
		btnRunMachine.setBounds(323, 271, 152, 25);
		contentPane.add(btnRunMachine);

		btnCopyResult = new JButton("Copy Result");
		btnCopyResult.setToolTipText("Copy output to clipport");
		btnCopyResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(
						textPaneOutput.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		btnCopyResult.setBounds(12, 500, 153, 25);
		contentPane.add(btnCopyResult);

		lblTapeInput = new JLabel("Tape Input:");
		lblTapeInput.setBounds(12, 310, 95, 15);
		contentPane.add(lblTapeInput);

		lblOperationLog = new JLabel("Console:");
		lblOperationLog.setBounds(501, 12, 146, 15);
		contentPane.add(lblOperationLog);

		lblTapeOutput = new JLabel("Tape Output:");
		lblTapeOutput.setBounds(12, 404, 95, 15);
		contentPane.add(lblTapeOutput);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 431, 468, 57);
		contentPane.add(scrollPane_2);

		textPaneOutput = new JTextPane();
		textPaneOutput.setToolTipText("Turing machine output screen");
		textPaneOutput.setEditable(false);
		scrollPane_2.setViewportView(textPaneOutput);

		JButton btnCopyLog = new JButton("Copy Log");
		btnCopyLog.setToolTipText("Copy Log");
		btnCopyLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(textArea
						.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		btnCopyLog.setBounds(501, 500, 153, 25);
		contentPane.add(btnCopyLog);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(511, 47, 453, 441);
		contentPane.add(scrollPane_3);
		textArea = new JTextArea();
		textArea.setToolTipText("clear turing machine log");
		textArea.setEditable(false);
		scrollPane_3.setViewportView(textArea);

		JButton btnClearLog = new JButton("Clear Log");
		btnClearLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		btnClearLog.setBounds(847, 500, 117, 25);
		contentPane.add(btnClearLog);
	}

	public static void log(String log) {
		textArea.setText(textArea.getText()
				+ new Timestamp(System.currentTimeMillis()).toString() + "->"
				+ log + "\n");
	}

	private void runMachine() {
		try {
			if (table.isEditing()) {
				table.getCellEditor().stopCellEditing();
			}
			log("*********Turing machine started*********");
			List<State> states = new ArrayList<State>();
			for (int r = 0; r < table.getModel().getRowCount(); r++) {
				State state = new State();
				state.setName(table.getValueAt(r, 0).toString());
				state.setNextState(table.getValueAt(r, 4) != null ? table
						.getValueAt(r, 4).toString() : null);
				state.setPrintValue(table.getValueAt(r, 2) != null ? table
						.getValueAt(r, 2).toString() : null);
				state.setReadValue(table.getValueAt(r, 1).toString());
				state.setTapeOperation(TapeOperation.valueOf(table.getValueAt(
						r, 3).toString()));
				states.add(state);
			}
			Configuration configuration = new Configuration(
					textFieldBlankSymbol.getText(), states);
			TuringMachine turing = new TuringMachine(configuration);
			List<String> inputs = new ArrayList<String>();
			String textInput = textPaneInput.getText();
			if (textInput != null && !"".equals(textInput)) {
				String[] inputArray = textInput.split(",");
				for (String in : inputArray) {
					inputs.add(in);
				}
			}
			textPaneOutput.setText(turing.run(inputs));
			log("*********Turing machine run ended!*********");
		} catch (Exception ex) {
			ex.printStackTrace();
			log("*********Turing machine run ended with error:"
					+ ex.getMessage() + "*********");
			JOptionPane.showMessageDialog(this, ex.getMessage(),
					"Error Turing Run", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void save(File file) {
		try {
			if (table.isEditing()) {
				table.getCellEditor().stopCellEditing();
			}
			StringBuffer sb = new StringBuffer();
			sb.append("BS:");
			sb.append(textFieldBlankSymbol.getText());
			sb.append("\n");
			for (int r = 0; r < table.getModel().getRowCount(); r++) {
				if (table.getModel().getValueAt(r, 0) != null
						&& !"".equals(table.getModel().getValueAt(r, 0))) {
					sb.append("ST:").append(table.getModel().getValueAt(r, 0))
							.append(" RI:")
							.append(table.getModel().getValueAt(r, 1))
							.append(" PO:")
							.append(table.getModel().getValueAt(r, 2))
							.append(" TM:")
							.append(table.getModel().getValueAt(r, 3))
							.append(" NS:")
							.append(table.getModel().getValueAt(r, 4))
							.append("\n");
				}
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(sb.toString().getBytes());
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(Main.this, ex.getMessage(),
					"Save error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void load(File file) {
		FileInputStream fis = null;
		BufferedReader br = null;
		try {
			if (table.isEditing()) {
				table.getCellEditor().stopCellEditing();
			}
			fis = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fis));
			String line = br.readLine();
			textFieldBlankSymbol.setText(line.split(":")[1]);
			((DefaultTableModel) (table.getModel())).setRowCount(0);
			line = br.readLine();
			while (line != null) {
				String[] l = line.split(" ");
				((DefaultTableModel) (table.getModel())).addRow(new String[] {
						l[0].split(":")[1],
						l[1].split(":")[1],
						l[2].split(":")[1],
						l[3].split(":")[1],
						"null".equals(l[4].split(":")[1]) ? null : l[4]
								.split(":")[1] });
				line = br.readLine();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(Main.this, ex.getMessage(),
					"Load error", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(Main.this, ex.getMessage(),
						"Load error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
