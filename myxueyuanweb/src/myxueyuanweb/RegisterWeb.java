package myxueyuanweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterWeb extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn;
		PreparedStatement sql;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String msg = null;
		if (username != null && password != null) {
            msg="success";
			try {
				// ����Mysql����
				conn = DB.DbConnect();

				String insertSql = "insert into user values(?,?)";
				sql = conn.prepareStatement(insertSql);
				sql.setString(1, username);
				sql.setString(2, password);
				int status = sql.executeUpdate();
				if (status != 0) {
					System.out.println("�������ݳɹ�");
				} else {
					System.out.println("��������ʧ��");
				}
				conn.close();
			} catch (Exception e) {
				System.out.print(e);
			}
		} else {
			msg = "failed";
		}
		out.print(msg);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}