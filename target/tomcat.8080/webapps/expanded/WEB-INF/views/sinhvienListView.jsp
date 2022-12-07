<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Danh sách Sinh viên</title>

<script type="text/javascript">

function testConfirmDialog(id)
{
	var result=confirm("Bạn có chắc chắn muốn xóa??");
	if (result)
		{
		window.location.href="deleteSinhVien?id=" + id;
		}
	else
		{
		return false;
		}
	
}

</script>
</head>
<body>

<h3> DANH SÁCH SINH VIÊN </h3>
<p style="color: red;">${errorString}</p>
<table border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Id</th>
		<th>Họ tên</th>
		<th>Địa chỉ</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<% System.out.print("hi"); %>
	<c:forEach items="${sinhvienList}" var="sinhvien">
	<tr>
		<td>${sinhvien.id}</td>
		<td>${sinhvien.hotenString}</td>
		<td>${sinhvien.diachiString}</td>
		<td>
			<a href="editSinhVien?id=${sinhvien.id}">Edit</a>
		</td>
		
		<td>
			<a href="#" onclick="testConfirmDialog(${sinhvien.id});">Delete</a>
		</td>
		
	</tr>
	</c:forEach>
</table>
<a href="createSinhVien">Them Sinh Vien</a>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>