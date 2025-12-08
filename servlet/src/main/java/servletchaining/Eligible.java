package servletchaining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Eligible extends HttpServlet {

	String url="jdbc:mysql://localhost:3307/jee";
	String username="root";
	String pwd="admin";
	
	Connection con;

	
	@Override
	public void init() throws ServletException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
//		ServletConfig sc
//		url=sc.getInitParameter("url");
//		username=sc.getInitParameter("username");
//		pwd=sc.getInitParameter("pwd");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, pwd);	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	PrintWriter writer = resp.getWriter();
	
	
	try {
		
		String qury="select * from tapstudent where un=? and pwd=?";
		PreparedStatement pstmt1 = con.prepareStatement(qury);
		pstmt1.setString(1, username);
		pstmt1.setString(2, password);
		ResultSet res1 = pstmt1.executeQuery();
	    
		res1.next();
		int ten=res1.getInt(3);
		int twe=res1.getInt(4);
		int grad=res1.getInt(5);
		
		String qurey2="select * from drive where 10th<=? and 12th<=? and grad<=? ";
		PreparedStatement pstmt2 = con.prepareStatement(qurey2);
		pstmt2.setInt(1, ten);
		pstmt2.setInt(2, twe);
		pstmt2.setInt(3, grad);
		ResultSet res2 = pstmt2.executeQuery();
		
		writer.println("<h3>"+ res1.getString(2) +  "  drives you are eliible !!!:</h3>");
		writer.println("\r\n"
				+ "<table border=1>\r\n"
				+ "	<tr>\r\n"
				+ "		<th>id</th>\r\n"
				+ "	     <th>name</th>\r\n"
				+ "	     <th>10th</th>\r\n"
				+ "	     <th>12th</th>\r\n"
				+ "	     <th>grad</th>\r\n"
				+ "	     <th>profil</th>\r\n"
				+ "	     <th>package</th>\r\n"
				+ "	     <th>skil</th>\r\n"
				+ "	</tr>");
	
		while(res2.next()==true) {
			int id = res2.getInt(1);
			String name = res2.getString(2);
			int ten1 = res2.getInt(3);
			int twe1 = res2.getInt(4);
			int grad1 = res2.getInt(5);
			String profil = res2.getString(6);
			String pak = res2.getString(7);
			String skil = res2.getString(8);
			writer.println("<tr>\r\n"
					+ "		<td>"+ id + "</td>\r\n"
					+ "		<td>"+ name +"</td>\r\n"
					+ "		<td>"+ ten1 +"</td>\r\n"
					+ "		<td>"+ twe1 +"</td>\r\n"
					+ "		<td>"+ grad1 +"</td>\r\n"
					+ "		<td>"+ profil +"</td>\r\n"
					+ "		<td>"+ pak +"</td>\r\n"
					+ "		<td>"+skil+"</td>\r\n"
					+ "	</tr>");
			

		}
		writer.println("</table>\r\n");
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	

}
