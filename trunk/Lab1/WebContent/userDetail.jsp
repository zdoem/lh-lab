<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.web.form.UserDetailForm" %>	

<html:html>
<head>
<title>UserDetail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="GENERATOR" content="Rational Application Developer">
</head>

<%
   System.out.println("--------->>");
   UserDetailForm usrForm =(UserDetailForm) request.getAttribute("UserDetailForm");
   if(usrForm==null){
         usrForm = new UserDetailForm();
         usrForm.setFirstname("");
         usrForm.setUsername("");
         usrForm.setLastname("");
         usrForm.setEmail("");
         usrForm.setAddress("");
         usrForm.setSex("");
         usrForm.setMsg("");
    }
          
 %>
<body>

<form name="UserDetailForm" action="<%=request.getContextPath() %>/UserDetail.do">

Username :<input type="text" name="username" value="<%=usrForm.getUsername() %>" ><br>
First Name :<input type="text" name="firstname"  value="<%=usrForm.getFirstname() %>"><br>
Last Name :<input type="text" name="lastname" value="<%=usrForm.getLastname() %>"><br>
Email :<input type="text" name="email" value="<%=usrForm.getEmail() %>" ><br>
Address :<input type="text" name="address" value="<%=usrForm.getAddress() %>" ><br>
Sex :<input type="text" name="sex" value="<%=usrForm.getSex() %>" ><br>
<input type="submit" name="submit" value="submit">
<br>
<font color="RED"><%

if(usrForm!=null){out.println(usrForm.getMsg());}
 %>
 </font>
 </form>
</body>
</html:html>


