<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Sinh viên</title>
</head>
<body>
<h3>Edit SinhVien</h3>
<p style="color: red;">${errorString}</p>
<c:if test="${not empty sinhvien}">
<form method="POST" action="${pageContext.request.contextPath}/editSinhVien">

<input type="hidden" name="id" value="${sinhvien.id}" />
<table style="border: 0;">
<tr>
	<td>ID</td>
	<td style="color: red;">${sinhvien.id}</td>
</tr>

<tr>
	<td>Họ tên</td>
	<td><input type="text" name="hoten" value="${sinhvien.hotenString}"></td>
	<td><label>*</label></td>
</tr>

<tr>
	<td>Địa chỉ</td>
	<td><input type="text" name="diachi" value="${sinhvien.diachiString}"></td>
	
</tr>

<tr>
<td colspan="2">
	<input type="submit" value="Submit" />
	<a href="${pageContext.request.contextPath}/sinhvienList">Cancel</a>

</td>
</tr>

</table>


</form>
</c:if>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>