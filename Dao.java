package com.usst.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.usst.domain.Person;



//ͨ��jdbc���������ݿ�
public class Dao {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://192.168.8.100:3306/test";
	protected static String name = "root";
	protected static String password = "root";
	public static Connection conn = null;
	public static Statement sql = null;
	public static ResultSet res = null;
	static List<Person> list = new ArrayList<Person>();

	public Connection getConnection() {
		try {
			if (conn == null) {

				Class.forName(dbClassName);
				System.out.println("���ݿ���سɹ�");
				conn = DriverManager.getConnection(dbUrl, name, password);
				//conn = DriverManager.getConnection( dbUrl);
				System.out.println("���ݿ����ӳɹ�");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
public static boolean check(String userStr,String passStr) throws SQLException {
		
		Dao dao = new Dao();
		conn = dao.getConnection();
		sql = conn.createStatement();
		res = sql.executeQuery("select * from person_info where name="+userStr+"and password="+passStr);
		if (res == null) {
			return false;
		}
		return true;
		
	}
	
}


