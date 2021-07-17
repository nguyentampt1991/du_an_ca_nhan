<%--
  Created by IntelliJ IDEA.
  User: Tam Nguyen
  Date: 7/12/2021
  Time: 11:17 AM
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
<div class="list">
<center>

    <h2>
        <a href="/ThanhPho">Quay lại danh sách thành phố</a>
    </h2>
</center>
<div align="center">
    <form method="post" style="width: 1000px">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Sửa Thành Phố
                </h2>
            </caption>
            <c:if test="${thanhPho != null}">
                <input type="hidden" name="Id" value="<c:out value='${thanhPho.id}' />"/>
            </c:if>
            <tr>
                <th>Tên Thành Phố</th>
                <td>
                    <input type="text" name="TenThanhPho" size="45"
                           value="<c:out value='${thanhPho.tenThanhPho}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quốc Gia </th>
                <td>

                    <input type="text" name="TenQuocGia" size="45"
                           value="<c:out value='${thanhPho.tenQuocGia}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Diện Tích :</th>
                <td>
                    <input type="text" name="DienTich" size="15"
                           value="<c:out value='${thanhPho.dienTich}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Dân Số</th>
                <td>
                    <input type="text" name="DanSo" size="15"
                           value="<c:out value='${thanhPho.danSo}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>GDP</th>
                <td>
                    <input type="text" name="GDP" size="15"
                           value="<c:out value='${thanhPho.gdp}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Mô Tả</th>
                <td >
                    <textarea  name="MoTa"  rows="5" style="width: 900px">
                           <c:out value='${thanhPho.moTa}' />"
                    </textarea>
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
</div>
</body>
</html>