package com.usst.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.usst.db.Dao;
import com.usst.domain.Dvd;
import com.usst.domain.Person;

public class LogonCheck {

	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet res = null;

	List<Person> list = new ArrayList<Person>();

	public Person Check(String name) throws SQLException {
		Person p = null;
		Dao dao = new Dao();
		conn = dao.getConnection();
		stmt = conn.createStatement();
		res = stmt.executeQuery("select * from person_info where name like"+"'"+name+"'");
		
		while(res.next()){
			String str = res.getString(2);
			//System.out.println(id);
			 p = new Person(name,str);
			
		}
      return p;
		
	}
	
	/*public static boolean check(String userStr,String passStr) throws SQLException {
		
		Dao dao = new Dao();
		conn = dao.getConnection();
		sql = conn.createStatement();
		res = sql.executeQuery("select * from person_info where name="+userStr+"and password="+passStr);
		if (res == null) {
			return false;
		}
		return true;
		
	}*/
	public Dvd finDvd(String dvdname){
		Dvd dvd = null;
		
		Dao dao = new Dao();
		conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			res =stmt.executeQuery("select * from dvd_info where dname like"+"'"+dvdname+"'");
			while(res.next()){
				String dname = res.getString(1);
				String dintroduce = res.getString(2);
				String dactor = res.getString(3);
				String durl = res.getString(4);
				
				dvd = new Dvd(dname, dintroduce, dactor, durl);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dvd;
		
	}
	public void rentDvd(String dvdname){
		Dao dao = new Dao();
		conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			//res = stmt.executeUpdate("delete * from dvd_info where dname like"+"'"+dvdname+"'");
		    stmt.executeUpdate("delete from dvd_info where dname like"+"'"+dvdname+"'");
		     
			 System.out.println(dvdname+"该dvd已经被租借了");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
