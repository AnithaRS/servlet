package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticResponse extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter writer = resp.getWriter();
//		
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
		RequestDispatcher rd = req.getRequestDispatcher("StaticRes.html");
		rd.forward(req, resp);
	
	
	}
}
