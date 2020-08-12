<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/8/4
  Time: 10:15 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>保存商品页面</h1>
<s:form action="product_save" method="POST" namespace="/" theme="simple">
    <table>
        <tr>
            <td>商品名称</td>
            <td><s:textfield name="pname" /></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><s:textfield name="price" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"></td>
        </tr>
    </table>
</s:form>
</body>
</html>
