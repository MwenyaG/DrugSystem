<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%@ page import="com.dao.CustomerDao"%>
<jsp:useBean id="s" class="com.dao.bean.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="s"></jsp:setProperty>

<%
int i = CustomerDao.getLogin(s);
String email= request.getParameter("email");

int customerID=CustomerDao.getUid(email);
if(i!=0)
	response.sendRedirect("Homepage.jsp?uid="+customerID);
else
	response.sendRedirect("LoginError1.html");
%>



</body>
</html>