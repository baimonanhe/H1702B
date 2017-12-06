<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head> 

<body>
<h1>展示页面</h1>
<form id="myForm" action="" method="post">
<table width="100%" border=1>
<tr>
	<td><input type="checkbox">  </td>
	<td>姓名</td>
	<td>性别</td>
	<td>日</td>	
	<td>操作</td>
</tr>
<c:forEach items="${user }" var="user">
<tr>
	<td><input type="checkbox" name="ids" value="${user.sid }"/></td>
	<td>${user.sname }</td>
	<td>${user.ssex }</td>
	<td>${user.sc }</td>
</tr>
</c:forEach>

</table>
</form>
</body>
</html>