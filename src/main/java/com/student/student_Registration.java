package com.student;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.student.read.ReadByID;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JToolBar;
import javax.swing.plaf.OptionPaneUI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class student_Registration {

	public static final String frame = null;
	public JFrame frmHome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_Registration window = new student_Registration();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public student_Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("HOME");
		frmHome.setResizable(false);
		frmHome.setBounds(100, 100, 698, 606);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(127, 231, 33, 0);
		frmHome.getContentPane().add(desktopPane);
		
		JLabel lblStudentRegistration = new JLabel("  STUDENT REGISTRATION");
		lblStudentRegistration.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentRegistration.setBounds(231, 10, 309, 30);
		frmHome.getContentPane().add(lblStudentRegistration);
		
		textField = new JTextField();
		textField.setBounds(242, 141, 203, 27);
		frmHome.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(242, 190, 203, 27);
		frmHome.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(242, 239, 203, 27);
		frmHome.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(242, 288, 203, 27);
		frmHome.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnEdit = new JButton("UPDATE");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.setVisible(false);
				updateStudents update= new updateStudents();
				
				update.frmUpdateStudents.setVisible(true);
			}
		});
		btnEdit.setBounds(252, 411, 99, 32);
		frmHome.getContentPane().add(btnEdit);
		btnEdit.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHome.setVisible(false);
				
				DeleteStudentyId delete= new DeleteStudentyId();
				 delete.frmDeleteStudents.setVisible(true);
			}
		});
		btnDelete.setBounds(119, 411, 99, 32);
		frmHome.getContentPane().add(btnDelete);
		btnDelete.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(242, 353, 203, 32);
		frmHome.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
				
				
	if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("")) {
		
		
		
		
		 JOptionPane.showMessageDialog(null," Please Fill the form Carefully");
		

			
		
	} else {
		
		
		
		
		ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		
		JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
		
		
		String Query= "insert into students(studentName, studentCourse, studentPhone, studentAddress) values(?,?,?,?)";
		
       int count =	jdbcTemplate.update(Query,textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());



           textField.setText("");
           textField_1.setText("");
           textField_2.setText("");
           textField_3.setText("");


            if(count >0) {
	             JOptionPane.showMessageDialog(null,"RECORD INSERTED");
	  
	
            }
             else {
            	 
	        JOptionPane.showMessageDialog(null,"NOT  INSERTED DUE TO SOME PROBLEM TRY AGAIN AFTER SOMETIME !!");
	        
                    }

  } 
	
				
				
				
			
				
				
			} catch (Exception e2) {
				
				
				e2.printStackTrace();
				
				
				JOptionPane.showMessageDialog(null,e2);
			}
				
				
			}
				
					
		});
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		
		JLabel lblS = new JLabel("Student Name");
		lblS.setBounds(114, 143, 104, 19);
		frmHome.getContentPane().add(lblS);
		lblS.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		
		JLabel lblCourse = new JLabel("student Course");
		lblCourse.setBounds(114, 192, 104, 19);
		frmHome.getContentPane().add(lblCourse);
		lblCourse.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		
		JLabel lblStudentPhone = new JLabel("Student Phone");
		lblStudentPhone.setBounds(114, 241, 104, 19);
		frmHome.getContentPane().add(lblStudentPhone);
		lblStudentPhone.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(127, 290, 104, 19);
		frmHome.getContentPane().add(lblAddress);
		lblAddress.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnExit.setBounds(519, 491, 85, 32);
		frmHome.getContentPane().add(btnExit);
		
		JButton btnDetail = new JButton("DETAIL");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmHome.setVisible(false);
				
				ReadByID detail = new ReadByID();
				
				detail.frmGetStudentsDetails.setVisible(true);
				
			}
		});
		btnDetail.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnDetail.setBounds(403, 414, 99, 32);
		frmHome.getContentPane().add(btnDetail);
	}
}
