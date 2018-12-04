package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.Canvas;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JavaToUML extends JFrame {

	private JPanel contentPane;
	private JTextField txtImportJavaFile;
	private JTextField textField;
	JLabel lblNewLabel_1 = new JLabel("");
	protected static String source;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaToUML frame = new JavaToUML();
					
					//frame.setSize(1500,900);
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setUndecorated(true);
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
	public JavaToUML() {
		setTitle("      Techsoft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setBounds(535, 27, 86, 37);
		contentPane.add(btnAbout);
		
		JButton btnHelp = new JButton("help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnHelp.setBounds(620, 27, 65, 37);
		contentPane.add(btnHelp);
		
		JLabel lblJavaToUml = new JLabel(" Java code to UML diagram generator");
		lblJavaToUml.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJavaToUml.setBounds(216, 0, 267, 37);
		contentPane.add(lblJavaToUml);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 46, 25);
		contentPane.add(label);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBackground(Color.RED);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogo.setBounds(0, 0, 46, 37);
		contentPane.add(lblLogo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 431, 685, -355);
		contentPane.add(separator);
		
		JLabel lblUploadJavaCode = new JLabel("Upload Java code");
		lblUploadJavaCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUploadJavaCode.setBounds(45, 75, 156, 23);
		contentPane.add(lblUploadJavaCode);
		
		txtImportJavaFile = new JTextField();
		txtImportJavaFile.setText("Import  java file");
		txtImportJavaFile.setBounds(45, 99, 86, 20);
		contentPane.add(txtImportJavaFile);
		txtImportJavaFile.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(45, 130, 267, 240);
		contentPane.add(textArea);
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          try {
		        	  String cl="Class Persion{\n int id;\n protected string name\n\n public string address \n public string getName()\n public void setName()\n private void setId() \n private int getId() \n}";
		        	  
		        	 int a=5;
		      
		        	 GenerateImageString callImageGenerator=new GenerateImageString();
		        	 source=callImageGenerator.UMLString(selectedFile.getAbsolutePath());
		        	  
		        	  textArea.setText(source);
		        	  
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        }
		      }
			
		});
		btnChooseFile.setBounds(131, 98, 117, 23);
		contentPane.add(btnChooseFile);
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(10, 381, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnGenerate = new JButton("Generate UML");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(false);
				ImageGenerator setImage=new ImageGenerator();
				try {
					
					System.setProperty("java.home", "C:\\Program Files\\Java\\jre1.8.0_121");
					
					setImage.imageConverter(source);
					lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Darshan\\Desktop\\image3.png"));
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGenerate.setBounds(131, 381, 146, 23);
		contentPane.add(btnGenerate);
		
		JButton btnSaveAsImage = new JButton("Save as Image");
		btnSaveAsImage.setBounds(400, 381, 132, 23);
		contentPane.add(btnSaveAsImage);
		
		JButton btnSaveAsPdf = new JButton("Save as pdf");
		btnSaveAsPdf.setBounds(566, 381, 109, 23);
		contentPane.add(btnSaveAsPdf);
		
		JLabel lblNewLabel = new JLabel("     UML Diagram");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(475, 96, 146, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(602, 130, 73, 64);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Darshan\\Desktop\\image3.png"));
		lblNewLabel_1.setBounds(410, 118, 275, 230);
		contentPane.add(lblNewLabel_1);
		
		
		
	
		
		
		
		
	}
}
