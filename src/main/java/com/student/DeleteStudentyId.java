package com.student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteStudentyId {

	public JFrame frmDeleteStudents;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudentyId window = new DeleteStudentyId();
					window.frmDeleteStudents.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteStudentyId() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteStudents = new JFrame();
		frmDeleteStudents.setTitle("DELETE STUDENTS");
		frmDeleteStudents.setResizable(false);
		frmDeleteStudents.setBounds(100, 100, 554, 426);
		frmDeleteStudents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteStudents.getContentPane().setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("  STUDENT REGISTRATION");
		lblStudentRegistration.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblStudentRegistration.setBounds(140, 0, 309, 30);
		frmDeleteStudents.getContentPane().add(lblStudentRegistration);
		
		JLabel lblEnterIdTo = new JLabel("ENTER ID TO DELETE STUDENT");
		lblEnterIdTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterIdTo.setBounds(102, 105, 309, 30);
		frmDeleteStudents.getContentPane().add(lblEnterIdTo);
		
		textField = new JTextField();
		textField.setBounds(113, 158, 238, 30);
		frmDeleteStudents.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null,"Enter valid Id");
					
				}
				else {
					try {
						
						ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
						
						JdbcTemplate jdbcTemplate= context.getBean(JdbcTemplate.class);
						
						
						String Query="DELETE FROM students where studentId=?";
						
						
						jdbcTemplate.update(Query,textField.getText());
						
						textField.setText("");
						JOptionPane.showMessageDialog(null,"Deleted Succefully");
						
					} catch (Exception e2) {
						// TODO: handle exception
					}

					
				}
				
			}
		});
		btnDelete.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnDelete.setBounds(164, 213, 136, 32);
		frmDeleteStudents.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnExit.setBounds(380, 309, 108, 32);
		frmDeleteStudents.getContentPane().add(btnExit);
		
		JButton btnRegistrationPage = new JButton("REGISTRATION PAGE");
		btnRegistrationPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteStudents.setVisible(false);
				student_Registration registration= new student_Registration();
				
				registration.frmHome.setVisible(true);
			}
		});
		btnRegistrationPage.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnRegistrationPage.setBounds(140, 309, 189, 32);
		frmDeleteStudents.getContentPane().add(btnRegistrationPage);
	}
}
