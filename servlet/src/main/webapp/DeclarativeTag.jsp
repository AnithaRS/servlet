<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="myerrorpage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
double rupeesToBitcoin(int rs){
    return rs*0.00000026781788;
}
double rupeesToDige(int rs){
    return rs*0.074;
}
%>
  
<%
    String rs=request.getParameter("rs");
pageContext.setAttribute("rupess", rs,pageContext.SESSION_SCOPE);
   int rupee= Integer.parseInt(rs);
   
  

%>

<h3> <%= rupee %> rs= <%=rupeesToBitcoin (rupee) %>BTC</h3>
<h3> <%= rupee %> rs= <%=rupeesToBitcoin (rupee) %>DOGE</h3>

<form action="usdconverter.jsp">
<input type="submit" value="USD">

</form>






</body>
</html>