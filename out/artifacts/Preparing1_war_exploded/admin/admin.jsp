<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Страница админа</title>
</head>
<body>
<p>

    <%--@elvariable id="users" type="controller"--%>
<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>UID</td>
        <td>Имя</td>
        <td>Роль</td>
        <td>Пароль</td>
        <td>Логин</td>
        <td>Эл. почта</td>
        <td>Страна</td>
        <td>Номер мобильного</td>
        <td>Удалить данные пользователя</td>
        <td>Изменить данные пользователя</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.role}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td><c:out value="${user.mobile}"/></td>
            <td>
                <form action="admin/delete" method="post">
                    <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/><br/>
                    <button type="submit">Удалить</button>
                </form>
            </td>
            <td>
                <form action="admin/update" method="get">
                    <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/><br/>
                    <button type="submit" name="button" value="update">Изменить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="admin/create" method="post">
    <input type="hidden" name="submitted" value="true"/>
    <P>Введите имя пользователя: <input type="text" name="name" value=""/><br/></p>
    <P>Введите роль пользователя: <label for="role">
        <select name="role" id="role">
            <option value="user">user</option>
            <option value="admin">admin</option>
        </select>
    </label>
    </p>
    <P>Введите пароль пользователя: <input type="password" name="password" value=""/><br/></p>
    <P>Введите логин пользователя: <input type="text" name="login" value=""/><br/></p>
    <P>Введите электронную почту пользователя: <input type="text" name="email" value=""/><br/></p>
    <P>Введите страну пользователя: <input type="text" name="country" value=""/><br/></p>
    <P>Введите номер мобильного телефона пользователя: <input type="text" name="mobile" value=""/><br/></p>
    <button type="submit">Создать</button>
</form>

</body>
</html>
