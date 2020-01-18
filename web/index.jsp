<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Authorization</title>
</head>
<body>
<div style="text-align: center;">
  <div style="color: teal; font-size: 30px">Авторизация</div>
    <form action="/sign_in" method="post">
    <input type="hidden" name="submitted" value="true"/>
    <p>Логин</p>
    <P><input type="text" name="login" size="20" value="<c:out value="${param.login}"/>" /><br /></p>
    <p>Пароль</p>
    <P><input type="password" name="password" value="<c:out value="${param.password}"/>" /><br /></p>
    <button type="submit">войти</button>
    </form>
</div>
</body>