<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="/dcswc/dcswc.tld" prefix="LH" %>	
<%@page import="com.web.form.CourseForm"%>
<% CourseForm courseForm = (CourseForm)request.getAttribute("CourseForm"); %>
<html:html>
<head>
<title>course Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="GENERATOR" content="Rational Application Developer">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script LANGUAGE="javascript" src="<%=request.getContextPath()%>/dcswc/dcswc.js"></script>
<script LANGUAGE="javascript" src="<%=request.getContextPath()%>/dcswc/prototype.js"></script>
<script type="text/javascript">
var itemData =  null;
<%
if (courseForm ==null || (courseForm.getItemData() == null || "".equals(courseForm.getItemData()))){%>
		itemData = new Array();
<%}else{%>
	itemData = <%=courseForm.getItemData() %>;
<%}%>

function loadData(){
	<% if(courseForm !=null){%>
		document.courseForm.courseCode.value = '<%=courseForm.getCourseCode() %>';
		document.courseForm.courseName.value = '<%=courseForm.getCourseName() %>';
		document.courseForm.overView.value = '<%=courseForm.getOverView() %>';
		document.courseForm.courseLevel.value = '<%=courseForm.getCourseLevel() %>';
		document.courseForm.target.value = '<%=courseForm.getTarget()%>';
		document.courseForm.location.value = '<%=courseForm.getLocation()%>';
		document.courseForm.clanguage.value = '<%=courseForm.getClanguage()%>';
		document.courseForm.duration.value = '<%=courseForm.getDuration()%>';
		document.courseForm.fee.value = '<%=courseForm.getFee()%>';
		document.courseForm.payment.value = '<%=courseForm.getPayment()%>';
		document.courseForm.remark.value = '<%=courseForm.getRemark()%>';
		document.courseForm.ddate.value = '<%=courseForm.getDdate()%>';
	<%}%>
	generateTable();
}

//Add
function addIns(){
	var arg = new Object();
	arg.list = itemData ;
	arg.index = null;
	var result = window.showModalDialog("<%=request.getContextPath()%>/instructorPopup.jsp",arg,"dialogWidth:600px; dialogHeight:300px; center:yes");	
	if(result != null){
		var reqParameters = new Object();
		reqParameters.itemData = result;	
		//var jsonResult = eval('('+result+')');	
		var jsonResult = result.evalJSON();
		itemData.push(jsonResult);	
		generateTable();	
	}	
}
function generateTable(){
	var table = "";
	table = "<table align='left' class='content' border='0' cellpadding='0' cellspacing='0' id='dataTable' width='450px'>";		
	table += "<tr bgcolor='#cccccc'>";
	table += "<td width='80' >เลือก</td>";			
	table += "<td width='80' >Instructor Name</td>";	
	table += "<td width='80' >Main instructor</td>";		
	table += "</tr>";			
	for(var j=0; j<itemData.length ;j++) {
			table += generateRow(itemData[j], j);			
	}
	table += "</table>";
	document.getElementById('myDiv').innerHTML = table;		
}
function generateRow(rec,number){
    if(rec==null)
      return '';
      
	var table = "";	
	var runningNo = number+1;	
	table += "<tr>";				
	table += "<td><input type='checkbox' name='deleteInsCheck' value = '"+ number +"'></td>"; 
	//table += "<td align='left'><a href='javascript:editItem("+number+");'>"+runningNo+"</a></td>";
	table += "<td align='left'>"+rec.instructorName+"</td>";	
	table += "<td align='left'>"+rec.main+"</td>";
	table += "</tr>";
	return table;
}

function delIns(){
   var j = 0;
   for(var i=0;i<document.courseForm.length;i++){
       if(document.courseForm[i].type=='checkbox' && document.courseForm[i].name =='deleteInsCheck' ){
           if(document.courseForm[i].checked){
              var r = parseInt(document.courseForm[i].value)-j;
              itemData.splice(r,1);
              j++;          
            }
       }
   }
   generateTable();
}


function saveUser(){
	document.courseForm.itemData.value= itemData.toJSON();
	document.courseForm.cmd.value="save";
	document.courseForm.action = "CourseAction.do";
	document.courseForm.submit();
}
</script>
</head>
<%
//dropdown
   String []payment = {"Cash","Credit Card","Free"};
   String []paymentValue={"cash","creditcard","free"};
 %>

<body onload="javascript:loadData();" >
<LH:validateForm formName="courseForm" formAction="CourseAction.do" formBean="CourseForm">
<form name="courseForm" action="<%=request.getContextPath()%>/CourseAction.do" method="post">
<input name="itemData" type="hidden">
<fieldset>
<table width="560"  align="center">
<tr>
	<td>
		<table width="99%" align="left" border="0">
			<br>
			<tr>
				<td width="144">Course Code :</td>
				<td width="398"><input name="courseCode" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Course Name :</td>
				<td width="398"><input name="courseName" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Over view :</td>
				<td width="398"><input name="overView" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Course Level :</td>
				<td width="398">
				<input name="courseLevel" type="radio" value="1">Fundamental&nbsp;
				<input name="courseLevel" type="radio" valude="2">Intermediate&nbsp;
				<input name="courseLevel" type="radio" valude="3">Advance&nbsp;
				</td>
			</tr>
			<tr>
				<td width="144">Duration :</td>
				<td width="398"><input name="duration" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Target Trainee :</td>
				<td width="398"><input name="target" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Location :</td>
				<td width="398"><input name="location" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Language :</td>
				<td width="398"><input name="clanguage" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Fee :</td>
				<td width="398"><input name="fee" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Payment by:</td>
				<td width="398">
				<LH:validateDropDown name="payment" property="payment" optionList="<%=payment %>" optionValueList="<%=paymentValue %>" />
				</td>
			</tr>
			<tr>
				<td width="144">Remark :</td>
				<td width="398"><input name="remark" type="text" size="32"></td>
			</tr>
			<tr>
				<td width="144">Update Date :</td>
				<td width="398">
				<LH:validateDate name="ddate" property="ddate" size="18"/>
				</td>
			</tr>
			
			<tr align="center">
				<td width="144">&nbsp;</td>
				<td align="left" width="398">
				    <input type="hidden" value="save" name="cmd"> 
					<input type="button" value=" OK " onclick="javascript:saveUser();"> &nbsp; 
					<input type="reset" value="Reset"></td>
			</tr>

		</table>
		</td>
</tr>
<tr>
	<td>
		<a href="javascript:addIns();">Add</a>&nbsp;&nbsp;<a href="javascript:delIns();">Delete</a>
	</td>
</tr>
<tr>
	<td>
		<div id="myDiv"></div>
	</td>
</tr>
</table>
</fieldset>
</form>
</LH:validateForm>
</body>
</html:html>
