<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/ThanhPho">Back to customer list</a>
</p>
<table>
    <tr>
    <th>ID</th>
    <td>
        value="<c:out value='${thanhPho.id}' />"
    </td>
    </tr>
    <tr>
    <th>Tên Thành Phố</th>
    <td>
          value="<c:out value='${thanhPho.tenThanhPho}' />"
    </td>
    </tr>
    <tr>
        <th>Quốc Gia Id</th>
        <td>
            value="<c:out value='${thanhPho.tenQuocGia}' />"
        </td>
    </tr>
    <tr>
        <th>Diện Tích</th>
        <td>
            value="<c:out value='${thanhPho.dienTich}' />"
        </td>
    </tr>
    <tr>
        <th>Dân Số</th>
        <td>
            value="<c:out value='${thanhPho.danSo}' />"
        </td>
    </tr>
    <tr>
        <th>GDP</th>
        <td>
            value="<c:out value='${thanhPho.gdp}' />"
        </td>
    </tr>
    <tr>
        <th>Mô Tả</th>
        <td style="width: 200px ;height: 50px;">
            value="<c:out value='${thanhPho.moTa}' />"
        </td>
    </tr>
</table>
</body>
</html>