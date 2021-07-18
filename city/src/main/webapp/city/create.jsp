<%--
  Created by IntelliJ IDEA.
  User: Tam Nguyen
  Date: 7/12/2021
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>User Management Application</title>
    <link rel="stylesheet" type="text/css" href="/css/listcss.css">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/ThanhPho?action=users">Quay lại trang danh sách thành phố</a>
    </h2>
</center>
<div align="center" class="list">
    <form method="post" style="width: 1000px" >
        <table border="1" cellpadding="5">
            <caption>
                <h2>Thêm Thành Phố</h2>
            </caption>
            <tr>
                <th>Tên Thành Phố</th>
                <td>

                    <input type="text" name="TenThanhPho" id="TenThanhPho" size="45" value="${thanhPho.tenThanhPho }"/>
                </td>
            </tr>
            <tr>
                <th>Quốc Gia </th>
                <td>
                    <input type="text" name="TenQuocGia" id="TenQuocGia" size="45" value="${thanhPho.tenQuocGia} "/>

                </td>
            </tr>
            <tr>
                <th>Diện Tích</th>
                <td>
                    <input type="text" name="DienTich" id="DienTich" size="15"${thanhPho.dienTich}/>
                </td>
            </tr>
            <tr>
                <th>Dân Số</th>
                <td>
                    <input type="text" name="DanSo" id="DanSo" size="15"${thanhPho.danSo} />
                </td>
            </tr>
            <tr>
                <th>GDP</th>
                <td>
                    <input type="text" name="GDP" id="GDP" size="15" value="${thanhPho.gdp} "/>
                </td>
            </tr>
            <tr>
                <th>Mô Tả</th>
                <td>
                    <textarea name="MoTa" id="MoTa" rows="5" style="width: 900px"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>