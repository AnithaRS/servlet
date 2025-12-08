package configContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exmp extends HttpServlet {

	 String URL = null;
	 String USER = null;
	 String PSWD = null;

	Connection con=null;
	
	
	
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
//		 URL = sc.getInitParameter("URL");
//		 USER = sc.getInitParameter("USER");
//		 PSWD = sc.getInitParameter("PSWD");
//		
		ServletContext sCon = sc.getServletContext();
		 URL = sCon.getInitParameter("URL");
		 USER = sCon.getInitParameter("USER");
		 PSWD = sCon.getInitParameter("PSWD");

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(URL, USER, PSWD);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String us=req.getParameter("username");
		String pd=req.getParameter("password");
		
		
		String q="select * from tapstudent where un=? and pwd=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, us);
			pstmt.setString(2, pd);
			
			
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				writer.println("<h3> welcome   "+  res.getString(2)+"</h3>");
			req.getRequestDispatcher("/drive").include(req, resp);
			}else {
				req.getRequestDispatcher("/InvalidLogin.html").forward(req, resp);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
