<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>instructorPopup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="GENERATOR" content="Rational Application Developer">
<script language="javascript" src="<%=request.getContextPath() %>/dcswc/dcswc.js"></script>
<script language="javascript" src="<%=request.getContextPath() %>/dcswc/prototype.js"></script>

<script language="javascript">

function addItemData(){
	var result = new Object();
	var arg = window.dialogArguments;	
	//result.userId = 0;	
	result.instructorName = document.all.instructorName.value; 
	result.main = document.all.main.value; 
	//result.user = null;
	window.returnValue = Object.toJSON(result);
	window.close();
}

function closePopup(){
	window.returnValue = null;
	window.close();
}
</script>

</head>
<body>
<form name="insPopupForm">
<fieldset style="width:500px">
<table>
	<tr>
		<td width="130">Instructor Name:</td>
		<td width="187">
		<input type="text" name="instructorName"></td>
	</tr>
	<tr>
		<td width="130">Main Instructor:

		</td>
		<td width="187">
				<select name="main">
					<option value="Y">Yes</option>
					<option value="N">No</option>
				</select>
		</td>
	</tr>
	<tr>
		<td colspan="2"> <input type="button" value="  OK  " name="OK" onclick="javascript:addItemData();"> 
		&nbsp;<input type="button" value="Close" name="Cancel" onclick="javascript:closePopup();"> </td>
	</tr>
</table>
</fieldset>
</form>
</body>
</html>
