<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.web.form.UserDetailForm" %>	
<%
   System.out.println("--------->>");
   UserDetailForm usrForm =(UserDetailForm) request.getAttribute("UserDetailForm");
   if(usrForm==null){
         usrForm = new UserDetailForm();
         usrForm.setUserId(0);
         usrForm.setFirstname("");
         usrForm.setUsername("");
         usrForm.setLastname("");
         usrForm.setEmail("");
         usrForm.setAddress("");
         usrForm.setSex("");
         usrForm.setMsg("");
         usrForm.setCmd("");
    }     
 %>

<html:html>
<head>
<title>UserDetail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="GENERATOR" content="Rational Application Developer">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script LANGUAGE="javascript" src="<%=request.getContextPath()%>/dcswc/dcswc.js"></script>
<script LANGUAGE="javascript" src="<%=request.getContextPath()%>/dcswc/prototype.js"></script>
<script type="text/javascript">
var itemData =  null;
<%
if (usrForm ==null || (usrForm.getItemData() == null || "".equals(usrForm.getItemData()))){%>
		itemData = new Array();
<%}else{%>
	itemData = <%=usrForm.getItemData() %>;
<%}%>

function loadData(){
	<% if(usrForm !=null){%>
		document.UserDetailForm.sex.value = '<%=usrForm.getSex() %>';
		document.UserDetailForm.username.value = '<%=usrForm.getUsername() %>';
		document.UserDetailForm.firstname.value = '<%=usrForm.getFirstname() %>';
		document.UserDetailForm.lastname.value = '<%=usrForm.getLastname() %>';
		document.UserDetailForm.email.value = '<%=usrForm.getEmail()%>';
		document.UserDetailForm.address.value = '<%=usrForm.getAddress()%>';
	<%}%>
	generateTable();
}


function addTel(){
	var arg = new Object();
	arg.list = itemData ;
	arg.index = null;
	var result = window.showModalDialog("<%=request.getContextPath()%>/telPopup.jsp",arg,"dialogWidth:600px; dialogHeight:300px; center:yes");	
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
	table = "<table align='left' class='content' border='0' cellpadding='0' cellspacing='0' id='dataTable' width='400px'>";		
	table += "<tr bgcolor='#cccccc'>";
	table += "<td width='80' >เลือก</td>";			
	table += "<td width='80' >ลำดับ</td>";	
	table += "<td width='80' >เบอร์โทร</td>";		
	table += "</tr>";			
	for(var j=0; j<itemData.length ;j++) {
			table += generateRow(itemData[j], j);			
	}
	table += "</table>";
	document.getElementById('myDiv').innerHTML = table;		
}
function generateRow(rec,number){
	var table = "";	
	var runningNo = number+1;	
	table += "<tr>";				
	table += "<td><input type='checkbox' name='deleteTelCheck' value = '"+ number +"'></td>"; 
	table += "<td align='left'><a href='javascript:editItem("+number+");'>"+runningNo+"</a></td>";	
	table += "<td align='left'>"+rec.telNo+"</td>";
	table += "</tr>";
	return table;
}

function delTel(){
   var j = 0;
   for(var i=0;i<document.UserDetailForm.length;i++){
       if(document.UserDetailForm[i].type=='checkbox' && document.UserDetailForm[i].name =='deleteTelCheck' ){
           if(document.UserDetailForm[i].checked){
              var r = parseInt(document.UserDetailForm[i].value)-j;
              itemData.splice(r,1);
              j++;          
            }
       }
   }
   generateTable();
}

function doAjaxKrub(){
		var reqParameters = new Object();		
		reqParameters.cmd = "saveAjax";
		reqParameters.userId= document.UserDetailForm.userId.value;
		reqParameters.username= document.UserDetailForm.username.value;		
		reqParameters.firstname = document.UserDetailForm.firstname.value;	
		reqParameters.lastname= document.UserDetailForm.lastname.value;	
		reqParameters.email= document.UserDetailForm.email.value;	
		reqParameters.sex= document.UserDetailForm.sex.value;	
		reqParameters.address= document.UserDetailForm.address.value;	
		reqParameters.itemData = itemData.toJSON();	
		//document.UserDetailForm.itemData.value= itemData.toJSON();		
		new Ajax.Request('<%=request.getContextPath()%>/UserDetail.do?cmd=saveAjax',{
			method: 'post',
			asynchronous: false,
			parameters: reqParameters,
			onSuccess: function(transport) {
				alert("Your Save Successfully..");	
				window.location = "<%=request.getContextPath()%>/UserList.do?cmd=list";
			},
			onFailure: function() {
				alert("Save Failed!!");	
			}
		});	
	}


function saveUser(){
	document.UserDetailForm.itemData.value= itemData.toJSON();
	document.UserDetailForm.cmd.value="";
	document.UserDetailForm.action = "UserDetail.do";
	document.UserDetailForm.submit();
}
</script>
</head>

<body onload="javascript:loadData();">
<%
if(usrForm.getCmd().equals("EDIT")){
out.println("<h2> Edit Page.</h2>");
   usrForm.setCmd("edit");
}else{
out.println("<h2> Add  Page.</h2>");
   usrForm.setCmd("add");
}
 %>

<form name="UserDetailForm" action="<%=request.getContextPath() %>/UserDetail.do?cmd=<%=usrForm.getCmd() %>">
<input name="itemData" type="hidden">
UserID :<input type="text" name="userId" value="<%=usrForm.getUserId() %>" ><br>
Username :<input type="text" name="username" value="<%=usrForm.getUsername() %>" ><br>
First Name :<input type="text" name="firstname"  value="<%=usrForm.getFirstname() %>"><br>
Last Name :<input type="text" name="lastname" value="<%=usrForm.getLastname() %>"><br>
Email :<input type="text" name="email" value="<%=usrForm.getEmail() %>" ><br>
Address :<input type="text" name="address" value="<%=usrForm.getAddress() %>" ><br>
Sex :<input type="text" name="sex" value="<%=usrForm.getSex() %>" ><br>
<input type="hidden"   name="cmd" value="<%=usrForm.getCmd() %>">
<input type="button" name="save" value="submit" onclick="javascript:saveUser();" >&nbsp;
<input type="button" name="savej" value="submit Ajax" onclick="javascript:doAjaxKrub();" >
<br><br>
<a href="javascript:addTel();">Add</a>&nbsp;&nbsp;<a href="javascript:delTel();">Delete</a>
<font color="RED"><%

if(usrForm!=null){out.println(usrForm.getMsg());}
 %>
 </font>
 <br>
 <div id="myDiv"></div>
 </form>
</body>
</html:html>


