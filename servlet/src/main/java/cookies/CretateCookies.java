package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CretateCookies")
public class CretateCookies extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	resp.setContentType("type/html");
	PrintWriter writer = resp.getWriter();
    
	
	
	    Cookie ck = new Cookie("browser","chrome");  //name , value
        ck.setMaxAge(90);
        resp.addCookie(ck);
        writer.println("<h3>Cookiee has been created</h3>");
        
	    
	    
	    
}

}
