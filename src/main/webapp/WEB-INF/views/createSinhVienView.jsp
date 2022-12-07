<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới sinh viên</title>
<%@include file="/WEB-INF/css/main.css" %>

<script type="text/javascript">
	function validateForm()
	{
		var x = document.forms["createSVForm"]["hoten"].value;
		var y = document.forms["createSVForm"]["diachi"].value;
		if (x=="")
			{
				alert("Vui lòng nhập họ tên");
				return false;
			}
		if (y=="")
			{
			alert("Vui lòng nhập địa chỉ");
			return false;
			}
		return true;	
	}

</script>
</head>
<body>
<h3> Thêm mới sinh viên </h3>
<p style="color: red;">${errorString}</p>
<form method="POST" action="${pageContext.request.contextPath}/createSinhVien" name="createSVForm" onsubmit="return validateForm()">
<table>
<tr>
	<td>ID</td>
	<td><input type="text" name="id"></td>
</tr>
<tr>
	<td>Họ tên</td>
	<td><input type="text" name="hoten"></td>
	<td><label>*</label></td>
</tr>

<tr>
	<td>Địa chỉ</td>
	<td><input type="text" name="diachi"></td>
	
</tr>

<tr>
<td colspan="2">
	<input type="submit" value="Submit" />
	<a href="${pageContext.request.contextPath}/sinhvienList">Cancel</a>

</td>
</tr>


</table>

</form>

<jsp:include page="_footer.jsp"></jsp:include>


</body>
</html>