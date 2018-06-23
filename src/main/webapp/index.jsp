<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增商品界面</title>
</head>
<body>
<h1>新增商品</h1>
<s:actionmessage/>
<s:form action="product_save" method="post" namespace="/api/v1" theme="simple">
    <table width="600px">
        <tr>
            <th>商品名称</th>
            <td><s:textfield name="pname"/></td>
            <td><font color="red"><s:fielderror fieldName="pname"/></font></td>
        </tr>
        <tr>
            <th>商品价格</th>
            <td><s:textfield name="price"/></td>
            <td><font color="red"><s:fielderror fieldName="price"/></font></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="保存"/>
            </th>
            <th> </th>
        </tr>
    </table>
</s:form>
</body>
</html>
