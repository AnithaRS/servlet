package servletchaining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletChaining extends HttpServlet {
	Connection con;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	String URL="jdbc:mysql://localhost:3307/jee";
	String USER="root";
	String PSWD="admin";
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(URL, USER, PSWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");  
		PrintWriter writer = resp.getWriter();

		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		try {
			String query="select * from tapstudent where un=? and pwd=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, username);
			pstm.setString(2, password);
			
			ResultSet res = pstm.executeQuery();
			if(res.next()) {
				writer.println("<h3>welcome "+res.getString(2) +"<h3>");
			       req.getRequestDispatcher("/drive").include(req, resp);  //("/drive")=not .java file its url of web.xml

			}else {
				req.getRequestDispatcher("/InvalidLogin.html").forward(req, resp);
			}
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
