package com.student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateStudents {

	public JFrame frmUpdateStudents;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateStudents window = new updateStudents();
					window.frmUpdateStudents.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateStudents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateStudents = new JFrame();
		frmUpdateStudents.setTitle("UPDATE STUDENTS");
		frmUpdateStudents.setResizable(false);
		frmUpdateStudents.setBounds(100, 100, 720, 582);
		frmUpdateStudents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateStudents.getContentPane().setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("  STUDENT REGISTRATION");
		lblStudentRegistration.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentRegistration.setBounds(187, 10, 309, 30);
		frmUpdateStudents.getContentPane().add(lblStudentRegistration);
		
		JLabel lblEnterIdTo = new JLabel("ENTER ID TO UPDATE");
		lblEnterIdTo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblEnterIdTo.setBounds(10, 114, 165, 30);
		frmUpdateStudents.getContentPane().add(lblEnterIdTo);
		
		JLabel lblStudentName = new JLabel("STUDENT NAME ");
		lblStudentName.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentName.setBounds(25, 178, 150, 30);
		frmUpdateStudents.getContentPane().add(lblStudentName);
		
		JLabel lblStudentCourse = new JLabel("STUDENT COURSE");
		lblStudentCourse.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentCourse.setBounds(25, 239, 150, 30);
		frmUpdateStudents.getContentPane().add(lblStudentCourse);
		
		JLabel lblStudentPhone = new JLabel("STUDENT PHONE ");
		lblStudentPhone.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentPhone.setBounds(25, 303, 150, 30);
		frmUpdateStudents.getContentPane().add(lblStudentPhone);
		
		JLabel lblStudentAddress = new JLabel("STUDENT ADDRESS");
		lblStudentAddress.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentAddress.setBounds(25, 361, 150, 30);
		frmUpdateStudents.getContentPane().add(lblStudentAddress);
		
		textField = new JTextField();
		textField.setBounds(198, 118, 281, 30);
		frmUpdateStudents.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(198, 187, 281, 30);
		frmUpdateStudents.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 239, 281, 30);
		frmUpdateStudents.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 303, 281, 30);
		frmUpdateStudents.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(198, 361, 281, 30);
		frmUpdateStudents.getContentPane().add(textField_4);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("")) {
					
					
					JOptionPane.showMessageDialog(null, " Please fill your form carefully ");
					
					
				}
				else {
					
					
					
					
					ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
					
					JdbcTemplate jdbcTemplate=  context.getBean(JdbcTemplate.class);
					
					
					String Query="UPDATE students set studentName=?, studentCourse=?, studentPhone=? ,studentAddress=? WHERE studentId=? ";
					
					int count =jdbcTemplate.update(Query,textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),textField.getText());
					
					
					
					
					if(count >0) {
						JOptionPane.showMessageDialog(null, "Successfully Updated");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Not  Updated");
						
					}
					
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					
				
					
				}
				
				
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnUpdate.setBounds(205, 417, 189, 32);
		frmUpdateStudents.getContentPane().add(btnUpdate);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnExit.setBounds(566, 492, 100, 32);
		frmUpdateStudents.getContentPane().add(btnExit);
		
		JButton btnRegistrationPage = new JButton("REGISTRATION PAGE");
		btnRegistrationPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUpdateStudents.setVisible(false);
				student_Registration reg= new student_Registration();
				
				reg.frmHome.setVisible(true);
			}
		});
		btnRegistrationPage.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnRegistrationPage.setBounds(432, 420, 189, 32);
		frmUpdateStudents.getContentPane().add(btnRegistrationPage);
	}

}
