<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h3>Account Info</h3>
<table cellpadding="2" cellspacing="2" border="1">
    <tr>
        <td>Tên Thành Ph?</td>
        <td>${thanhPho.tenThanhPho }</td>
    </tr>
    <tr>
        <td>Tên Qu?c Gia</td>
        <td>${thanhPho.tenQuocGia }</td>
    </tr>
    <tr>
        <td>Di?n Tích</td>
        <td>${thanhPho.dienTich }</td>
    </tr>
    <tr>
        <td>Dân S?</td>
        <td>${thanhPho.danSo }</td>
    </tr>
    <tr>
        <td>GDP</td>
        <td>${thanhPho.gdp }</td>
    </tr>
    <tr>
        <td>Mô t?</td>
        <td>${thanhPho.moTa }</td>
    </tr>
</table>

</body>
</html>