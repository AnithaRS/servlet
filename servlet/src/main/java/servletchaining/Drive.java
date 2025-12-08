package servletchaining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Drive")
public class Drive extends HttpServlet {
	
	
	

	Connection con;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	String url="jdbc:mysql://localhost:3307/jee";
	String username="root";
	String pwd="admin";
	@Override
	public void init() throws ServletException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
//		ServletConfig sc
//		url=sc.getInitParameter("url");
//		username=sc.getInitParameter("username");
//		pwd=sc.getInitParameter("pwd");
//		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, pwd);	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			
			String qurey2="select * from drive";
			Statement stmt = con.createStatement();
			ResultSet res2 = stmt.executeQuery(qurey2);
			 
			writer.println("<h3>drives condect tap acadamy:</h3>");
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
				int ten = res2.getInt(3);
				int twe = res2.getInt(4);
				int grad = res2.getInt(5);
				String profil = res2.getString(6);
				String pak = res2.getString(7);
				String skil = res2.getString(8);
				writer.println("<tr>\r\n"
						+ "		<td>"+ id + "</td>\r\n"
						+ "		<td>"+ name +"</td>\r\n"
						+ "		<td>"+ ten +"</td>\r\n"
						+ "		<td>"+ twe +"</td>\r\n"
						+ "		<td>"+ grad +"</td>\r\n"
						+ "		<td>"+ profil +"</td>\r\n"
						+ "		<td>"+ pak +"</td>\r\n"
						+ "		<td>"+skil+"</td>\r\n"
						+ "	</tr>");
				

			}
			writer.println("</table>\r\n");
			
			req.getRequestDispatcher("/eligible").include(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
