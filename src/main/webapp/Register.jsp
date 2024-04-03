<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%@page import="com.dao.CustomerDao" %>
<jsp:useBean id="c" class="com.dao.bean.Customer"></jsp:useBean>>
<jsp:setProperty property="*" name="c"/>


<%

int i = CustomerDao.save(c);



if(i>0){

	response.sendRedirect("Login.html");

}
else
{

	response.sendRedirect("RegisterError1.html");


}

%>

</body>
</html>