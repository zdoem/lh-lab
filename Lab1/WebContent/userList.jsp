<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.bean.*" %>
<html:html>
<head>
<title>userList</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="GENERATOR" content="Rational Application Developer">
</head>
<%
List userList = (ArrayList)session.getAttribute("userList");

 %>
<body>
<form  name="UserListForm" action="<%=request.getContextPath() %>/UserList.do">
<table border="1" cellpadding="0" cellspacing="1" bordercolor="green">
	<tbody>
		<tr >
		   <td width="15%" bgcolor="#00EEFF">No</td> 
			<td width="15%" bgcolor="#00EEFF">User Name</td>
			<td width="15%" bgcolor="#00EEFF">First Name</td>
			<td width="20%" bgcolor="#00EEFF">Last Name</td>
			<td width="15%" bgcolor="#00EEFF">Email</td>
			<td width="" bgcolor="#00EEFF">Address</td>
			<td width="10%" bgcolor="#00EEFF">Sex</td>
			
		</tr>
		
		<%
		if(userList!=null && userList.size()>0){
		for(int i=0;i<userList.size();i++){
		  	User obj = (User)userList.get(i);
		 %>
			<tr>
			    <td width=""><input type="checkbox" name="userId" value=<%=obj.getUsername() %>></td>
				<td width=""><%=obj.getUsername() %></td>
				<td width=""><%=obj.getFirstname() %></td>
				<td width=""><%=obj.getLastname() %></td>
				<td width=""><%=obj.getEmail() %></td>
				<td width=""><%=obj.getAddress() %></td>
				<td width=""><%=obj.getSex() %></td>
			</tr>
		<%
		    }
		 }
		 %>
		 <tr>
		 <td colspan="7">
		 <input type="submit" value="Delete" name="del">
		 </td>
		 </tr>
	</tbody>
</table>
</form>
</body>
</html:html>
