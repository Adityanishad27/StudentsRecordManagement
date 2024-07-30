package com.student.read;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.student.ApplicationContextConfig;
import com.student.student_Registration;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReadByID {

	public  JFrame frmGetStudentsDetails;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadByID window = new ReadByID();
					window.frmGetStudentsDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReadByID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGetStudentsDetails = new JFrame();
		frmGetStudentsDetails.setTitle("GET STUDENTS DETAILS\r\n");
		frmGetStudentsDetails.setResizable(false);
		frmGetStudentsDetails.setBounds(100, 100, 687, 527);
		frmGetStudentsDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGetStudentsDetails.getContentPane().setLayout(null);
		
		JButton btnGetDetail = new JButton("GET DETAIL");
		btnGetDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Valid Id ");
					
				}
				
				
				
				
				
				try {
					
					ApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
					
					JdbcTemplate   jdbcTemplate= context.getBean(JdbcTemplate.class);
					
					
					String Query ="SELECT * FROM students WHERE studentId=? ";
					
					List<students> studentList= jdbcTemplate.query(Query, new studentRowMapper(), textField.getText());
					
					
					for(students List : studentList) {
						
			//	int   studentid= List.getStudentId();
				String studentname = List.getStudentName();
				String studentcource=List.getStudentCourse();
				String studentphone =List.getStudentPhone();
				
				String studentaddress= List.getStudentAddress();
				
				
				
				textField_1.setText(textField.getText());
				textField_2.setText(studentname);
				textField_3.setText(studentcource);
				textField_4.setText(studentphone);
				textField_5.setText(studentaddress);
						
					}
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
		
				JOptionPane.showMessageDialog(null, e2);
		
				
				}
			}
		});
		btnGetDetail.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnGetDetail.setBounds(187, 341, 153, 32);
		frmGetStudentsDetails.getContentPane().add(btnGetDetail);
		
		textField = new JTextField();
		textField.setBounds(177, 299, 193, 32);
		frmGetStudentsDetails.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ENTER STUDENT ID TO GET DETAIL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(170, 266, 218, 22);
		frmGetStudentsDetails.getContentPane().add(lblNewLabel);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGetStudentsDetails.setVisible(false);
				student_Registration home = new student_Registration();
				
				home.frmHome.setVisible(true);
				
			}
		});
		btnHome.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnHome.setBounds(337, 418, 105, 32);
		frmGetStudentsDetails.getContentPane().add(btnHome);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnExit.setBounds(495, 418, 105, 32);
		frmGetStudentsDetails.getContentPane().add(btnExit);
		
		JLabel lblStudentid = new JLabel("studentID");
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentid.setBounds(44, 47, 72, 22);
		frmGetStudentsDetails.getContentPane().add(lblStudentid);
		
		JLabel lblStudentname = new JLabel("studentName");
		lblStudentname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentname.setBounds(44, 79, 88, 22);
		frmGetStudentsDetails.getContentPane().add(lblStudentname);
		
		JLabel lblStudentcourse = new JLabel("studentCourse");
		lblStudentcourse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentcourse.setBounds(38, 111, 94, 22);
		frmGetStudentsDetails.getContentPane().add(lblStudentcourse);
		
		JLabel lblStudentphone = new JLabel("studentPhone\r\n");
		lblStudentphone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentphone.setBounds(44, 153, 94, 22);
		frmGetStudentsDetails.getContentPane().add(lblStudentphone);
		
		JLabel lblStudentaddress = new JLabel("studentAddress\r\n");
		lblStudentaddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentaddress.setBounds(27, 186, 105, 22);
		frmGetStudentsDetails.getContentPane().add(lblStudentaddress);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(152, 49, 290, 22);
		frmGetStudentsDetails.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(152, 81, 290, 22);
		frmGetStudentsDetails.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(152, 114, 290, 22);
		frmGetStudentsDetails.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(152, 155, 290, 22);
		frmGetStudentsDetails.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(152, 188, 290, 22);
		frmGetStudentsDetails.getContentPane().add(textField_5);
	}
}
