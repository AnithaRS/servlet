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

public class Validate extends HttpServlet {
	

	Connection con;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	String url="jdbc:mysql://localhost:3307/jee";
	String user="root";
	String pswd="admin";
	
	
	@Override
	public void init() throws ServletException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pswd);	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
	resp.setContentType("text/html");
	PrintWriter writer = resp.getWriter();
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	
	try {
		//login
				String qury="select * from tapstudent where un= ? and pwd= ?";
				pstmt = con.prepareStatement(qury);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet res = pstmt.executeQuery();
				
				if(res.next()==true) {
					
			// req.getRequestDispatcher("/drive").forward(req, resp);
					
					writer.println("<h3>welcome  "+res.getString(2)  +"!!</h3>");
				}else {
//					RequestDispatcher rd = req.getRequestDispatcher("/InvalidLogin.html");
//					rd.forward(req, resp);
					writer.println("<h3>Invalid loing details .please try again</h3>");
				}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}
}
