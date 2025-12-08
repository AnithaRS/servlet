package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicResponse extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");    //one name
 		String desig = req.getParameter("desig");   ////one desig
		String[] pV = req.getParameterValues("techSkil");    //multiple teckshil like (java,python,c++) so use arry
		
		System.out.println("NAme:"+name);
		System.out.println("Dis:"+desig);
		System.out.println("teckskil:");
		
		if(pV!=null) {
			for(String d:pV) {
				System.out.println(d);
			}
		}else {
			System.out.println("not select");
		}
		
		
		
		//send response to client
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h3>Thank you for your response "+ name +" </h3>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
		
	}

}
