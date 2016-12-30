package com.usst.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.usst.db.Dao;
import com.usst.domain.Person;

public class LogonCheck {

	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet res = null;

	List<Person> list = new ArrayList<Person>();

	public LogonCheck() {
		// TODO Auto-generated constructor stub
		Dao dao = new Dao();
		conn = dao.getConnection();
	}

	public String Check(String name) throws SQLException {
		String pw = null;
		// Dao dao = new Dao();
		// conn = dao.getConnection();
		stmt = conn.createStatement();
		res = stmt.executeQuery("select * from person_info where name like"
				+ "'" + name + "'");
		while (res.next()) {
			pw = res.getString(2);

		}
		return pw;
	}

	public void register(Person person) {

		String pname = person.getName();

		// Dao dao = new Dao();
		// conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			res = stmt
					.executeQuery("select * from person_info where name like");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] finClassicDvd() {
		// Dvd dvd = null;
		int i = 0;
		String array1[] = new String[10];

		// Dao dao = new Dao();
		// conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery("select dname from dvd_classic_info");
			while (res.next()) {
				String dname = res.getString(1);
				array1[i] = dname;
				i++;

				// System.out.println(dname);

				// dvd = new Dvd(dname, dintroduce, dactor, durl);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array1;

	}
	
	public String[] findHotDvd() {
		// Dvd dvd = null;
		int i = 0;
		String array2[] = new String[10];

		// Dao dao = new Dao();
		// conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery("select dname from dvd_hot_info");
			while (res.next()) {
				String dname = res.getString(1);
				array2[i] = dname;
				i++;

				// System.out.println(dname);

				// dvd = new Dvd(dname, dintroduce, dactor, durl);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array2;

	}

	public String[] finDvd(String dvdname) {
		// Dvd dvd = null;
		String array[] = new String[3];

		// Dao dao = new Dao();
		// conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery("select * from dvd_info where dname like"
					+ "'" + dvdname + "'");
			while (res.next()) {
				String drector = res.getString(2);
				String dactor = res.getString(3);
				String dintroduce = res.getString(4);
				array[0] = drector;
				array[1] = dactor;
				array[2] = dintroduce;
				// System.out.println(dintroduce);
				// System.out.println(dactor);
				// System.out.println(durl);

				// dvd = new Dvd(dname, dintroduce, dactor, durl);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;

	}

	public void rentDvd(String dvdname) {
		int i = 0;
		Dao dao = new Dao();
		conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			// res =
			// stmt.executeUpdate("delete * from dvd_info where dname like"+"'"+dvdname+"'");
			// stmt.executeUpdate("delete from dvd_info where dname like"+"'"+dvdname+"'");
			res = stmt.executeQuery("select dcount from dvd_info where dname like"+"'" + dvdname + "'");
			while (res.next()) {
			     i = res.getInt(1);
			     
				// System.out.println(dintroduce);

				// stmt.executeUpdate("insert into dvd_info(dname,dintroduce,dactor,durl,dcount) "
				// +
				// "values('"+dvdname+"','"+dintroduce+"'+'"+dactor+"','"+durl+"'+'"+i+"')");
			     }
			
		  System.out.println(dvdname + "该dvd已经被租借了");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 i = i-1;
		 System.out.println(i);
		 try {
			stmt.executeUpdate("UPDATE dvd_info SET dcount=" + i
				+ " WHERE dname='" + dvdname + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}
	
	public void addDvd(String dvdname) {
		int i = 0;
		Dao dao = new Dao();
		conn = dao.getConnection();
		try {
			stmt = conn.createStatement();
			// res =
			// stmt.executeUpdate("delete * from dvd_info where dname like"+"'"+dvdname+"'");
			// stmt.executeUpdate("delete from dvd_info where dname like"+"'"+dvdname+"'");
			res = stmt.executeQuery("select dcount from dvd_info where dname like"+"'" + dvdname + "'");
			while (res.next()) {
			     i = res.getInt(1);
			     
				// System.out.println(dintroduce);

				// stmt.executeUpdate("insert into dvd_info(dname,dintroduce,dactor,durl,dcount) "
				// +
				// "values('"+dvdname+"','"+dintroduce+"'+'"+dactor+"','"+durl+"'+'"+i+"')");
			     }
			
		  System.out.println(dvdname + "该dvd已经被租借了");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 i = i+1;
		 System.out.println(i);
		 try {
			stmt.executeUpdate("UPDATE dvd_info SET dcount=" + i
				+ " WHERE dname='" + dvdname + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

	public Boolean loginCheck(String name, String password) throws SQLException {
		String pw = Check(name);
		if (pw == null) {
			return false;
		} else if (pw.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	// register
	public void register(String name, String password) throws Exception {
		stmt = conn.createStatement();
		stmt.executeUpdate("insert into person_info(name,password) values('"
				+ name + "','" + password + "')");
		System.out.println("register had successed");
	}

	public String CheckSelect(String name) throws SQLException {
		String pw = null;
		// Dao dao = new Dao();
		// conn = dao.getConnection();
		stmt = conn.createStatement();
		res = stmt.executeQuery("select * from person_info where name like"
				+ "'" + name + "'");
		while (res.next()) {
			pw = res.getString(2);
			System.out.println(pw);

		}
		return pw;
	}
}
