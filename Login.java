package com.usst.service;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.usst.dao.LogonCheck;
import com.usst.domain.Person;

public class Login {
	Button LoginButton = new Button();
	
  
	 public void getLogin(){
		 
		 LoginButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				try{
					//String username = userFiled.getText();   //����û���
					String username = "admin";
					String passStr = "aa";
					
					//String passStr = new String(passwordFiled.getPassword);
					
					LogonCheck logonCheck = new LogonCheck();
					Person person =logonCheck.Check(username);
					String password = person.getPassword();
					
					if(!passStr.equalsIgnoreCase(password)){
						System.out.println("��¼ʧ�ܣ�������ȷ���û���������");
						/*JOptionPane.showMessageDialog(LoginDialog.this,
								"�û����������޷���¼",
								JOptionPane.ERROR_MESSAGE);*/
						return;
					}
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
	 }

	 
//unuse this test login
 public void testLogin(){
	 String username = "admin";
		String passStr = "bb";
		
		//String passStr = new String(passwordFiled.getPassword);
		
		LogonCheck logonCheck = new LogonCheck();
		Person person;
		try {
			person = logonCheck.Check(username);
			System.out.println(person);
			String password = person.getPassword();
			
			if(!passStr.equalsIgnoreCase(password)){
				System.out.println("��¼ʧ�ܣ�������ȷ���û���������");
				/*JOptionPane.showMessageDialog(LoginDialog.this,
						"�û����������޷���¼",
						JOptionPane.ERROR_MESSAGE);*/
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
 }

}
