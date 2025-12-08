<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!
double rupeesToUSD(int rs){
    return rs*0.013;
}

%>
<%
    String rs=(String)pageContext.getAttribute("rupess",pageContext.SESSION_SCOPE);
System.out.println(rs);
   int rupee= Integer.parseInt(rs);
%>
<h3> <%= rupee %> rs= <%=rupeesToUSD (rupee) %>USD</h3>

</body>
</html>