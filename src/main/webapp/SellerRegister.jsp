<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<%@page import="com.dao.SellerDao" %>
<jsp:useBean id="c" class="com.dao.bean.Seller"></jsp:useBean>>
<jsp:setProperty property="*" name="c"/>


<%

int i = SellerDao.save(c);



if(i>0){
	
	response.sendRedirect("Login.html");
	
}
else
{

	response.sendRedirect("SellerRegisterError1.html");
	

}

%>
</body>
</html>