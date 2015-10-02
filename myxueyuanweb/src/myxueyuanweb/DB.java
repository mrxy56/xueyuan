package myxueyuanweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	public static Connection DbConnect() {
		Connection conn;
		String driver = "com.mysql.jdbc.Driver";
		String name = "51l1zz2x3x";
		String password = "0z4x15h20my45hkl002hk5x02lyky2yk33mhywzl";
		try {
			Class.forName(driver).newInstance();
			String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_mrxy562";
			conn = DriverManager.getConnection(url, name, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public static void DBClose(Connection conn) throws SQLException {
		conn.close();
	}
}
