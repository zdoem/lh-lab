<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/dcswc/dcswc.tld" prefix="lh" %>	
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.web.form.CourseIListForm" %>

<html>
<head>
<title>userListGrid</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="GENERATOR" content="Rational Application Developer">
<link rel="stylesheet" href="<%=request.getContextPath()%>/dcswc/css/GridStyle.css" type="text/css">
<script LANGUAGE="javascript" src="<%=request.getContextPath()%>/dcswc/dcswc.js"></script>
<script type="text/javascript">
function editUser(id){
  	document.courseForm.cmd.value="edit";
	document.courseForm.action = "CourseListAction.do?id="+id;
	document.courseForm.submit();

}

</script>

</head>
<%
	List coList =(ArrayList)request.getAttribute("courseList");
	CourseIListForm cListForm = (CourseIListForm)request.getAttribute("CourseIListForm");
 %>

<body>
<lh:validateForm formName="courseForm" formAction="CourseListAction.do" formBean="CourseIListForm">
<form name="courseForm" action="<%=request.getContextPath()%>/CourseAction.do" method="post">
<input type="hidden" name="cmd" value="">
<table>
	<tr>
		<td colspan="2">
		<lh:grid dataSource="<%=coList %>" name="list" pageSize="<%=cListForm.getDisplayRow() %>" width="100%">
		<lh:gridpager imgFirst="/dcswc/images/First.gif" imgPrevious="/dcswc/images/Previous.gif" imgNext="/dcswc/images/Next.gif" 
		imgLast="/dcswc/images/Last.gif"/>
		<lh:gridsorter/>
		<lh:textcolumn dataField="courseCode" headerText="Course Code" width="150" HAlign="center" sortable="ture" linkUrl="javascript:editUser('{courseCode}')"/>
		<lh:textcolumn dataField="courseName" headerText="Course Name" width="300" HAlign="center"/>
		<lh:textcolumn dataField="overView" headerText="Over view" width="300" HAlign="center"/>
		<lh:textcolumn dataField="courseLevel" headerText="Course Level" width="400" HAlign="center"/>
		<lh:textcolumn dataField="duration" headerText="Duration" width="400" HAlign="center"/>
		<lh:textcolumn dataField="target" headerText="Target Trainee" width="300" HAlign="center"/>
		<lh:textcolumn dataField="location" headerText="Location" width="300" HAlign="center"/>
		
		</lh:grid>	
		</td>
	</tr>
</table>
</form>
</lh:validateForm>

</body>
</html>
