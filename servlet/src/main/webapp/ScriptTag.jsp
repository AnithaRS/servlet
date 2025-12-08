<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

int sum=0;
for(int i=1;i<=10;i++){
	sum=sum+i;
	out.println(sum+"");
}
%>


</body>
</html>