
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" type="text/css" href="/css/listcss.css">

</head>
<body>
<div class="list">
<center>
    <h1>Danh Sách Thành phố</h1>
    <h2>
        <a href="/ThanhPho?action=create">Thêm Thành Phố</a>
    </h2>
</center>
<form method="post" action="SearchServlet"  >
    <fieldset>
        <legend>Nhập thông tin sách</legend>
        <table>
            <tr>
                <td>
                    Từ khoá:
                </td>
                <td>
                    <input type="text" name="tuKhoa" placeholder="Nhập quốc gia cần tìm :"/>
                </td>

                <td>
                    <button type="submit"  value="Tìm kiếm" >Tìm Kiếm</button>

                </td>
            </tr>
        </table>
    </fieldset>
</form>
<div align="center">

    <table border="1" cellpadding="5">
           <tr>
            <th>Id</th>
            <th>Tên Thành Phố</th>
            <th>Quốc Gia</th>
            <th>Diện Tích</th>
            <th>Dân Số</th>
            <th>GDP</th>
            <th>Mô Tả</th>
        </tr>

        <c:forEach var="thanhPho" items="${listA}">

            <tr>

                <td><a href="/ThanhPho?action=view&id=${thanhPho.id}"><c:out value="${thanhPho.id}"/></a></td>
                <td><c:out value="${thanhPho.tenThanhPho}"/></td>
                 <td><c:out value="${thanhPho.tenQuocGia}"/></td>
                <td><c:out value="${thanhPho.dienTich}"/></td>
                <td><c:out value="${thanhPho.danSo}"/></td>
                <td><c:out value="${thanhPho.gdp}"/></td>
                <td><c:out value="${thanhPho.moTa}"/></td>

                <td>
                    <a href="/ThanhPho?action=edit&id=${thanhPho.id}">Edit</a>
                    <a href="/ThanhPho?action=delete&id=${thanhPho.id}" onclick="return confirm('Bạn có chắc chắn muốn xoá thông tin này ?');">Delete</a>
                </td>

            </tr>

        </c:forEach>

 </table>
</div>
<c:forEach begin="1" end="${endP}" var="i">
    <!-- Truyền gia -->
    <a href="/ThanhPho?index=${i}">${i}</a>
</c:forEach>
</div>
</body>
</html>