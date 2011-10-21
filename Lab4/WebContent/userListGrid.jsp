<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/dcswc/dcswc.tld" prefix="lh" %>	
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.web.form.UserlListForm" %>

<html>
<head>
<title>userListGrid</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="GENERATOR" content="Rational Application Developer">
<link rel="stylesheet" href="<%=request.getContextPath()%>/dcswc/css/GridStyle.css" type="text/css">
<script LANGUAGE="javascript" src="<%=request.getContextPath()%>/dcswc/dcswc.js"></script>
</head>
<%
	List userList =(ArrayList)request.getAttribute("userList");
	UserlListForm userListForm = (UserlListForm)request.getAttribute("UserlListForm");
 %>

<body>
<lh:validateForm formName="userListGridForm" formAction="UserlList.do" formBean="UserlListForm">
<table>
	<tr>
		<td colspan="2">
		<lh:grid dataSource="<%=userList %>" name="userList" pageSize="<%=userListForm.getDisplayRow() %>" width="100%">
		<lh:gridpager imgFirst="/dcswc/images/First.gif" imgPrevious="/dcswc/images/Previous.gif" imgNext="/dcswc/images/Next.gif" 
		imgLast="/dcswc/images/Last.gif"/>
		<lh:gridsorter/>
		<lh:textcolumn dataField="userId" headerText="User Id" width="150" HAlign="center" sortable="ture" linkUrl="javascript:editUser('{userId}')"/>
		<lh:textcolumn dataField="username" headerText="User Name" width="300" HAlign="center"/>
		<lh:textcolumn dataField="firstname" headerText="First Name" width="300" HAlign="center"/>
		<lh:textcolumn dataField="lastname" headerText="Last Name" width="400" HAlign="center"/>
		<lh:textcolumn dataField="email" headerText="Email" width="400" HAlign="center"/>
		<lh:textcolumn dataField="sex" headerText="Sex" width="300" HAlign="center"/>
		<lh:textcolumn dataField="address" headerText="Address" width="300" HAlign="center"/>
		
		</lh:grid>	
		</td>
	</tr>
</table>

</lh:validateForm>

</body>
</html>
