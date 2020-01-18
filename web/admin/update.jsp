<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Страница изменения данных</title>
</head>
<body>
<%--@elvariable id="userById" type="controller"--%>
<form action="update" method="post">
    <input type="hidden" name="id" value="<c:out value="${userById.id}"/>"/>
    <P>name: <input type="text" name="name" size="20" value="${userById.name}"/><br/></P>
    <%--<P>role: <input type="text" name="role" size="20" value="${userById.role}" /></P>--%>
    <P>role: <label for="role">
        <select name="role" id="role">
            <option value="user">user</option>
            <option value="admin">admin</option>
        </select>
    </label>
    </P>
    <P>password: <input type="text" name="password" size="20" value="${userById.password}"/></P>
    <P>login: <input type="text" name="login" size="20" value="${userById.login}"/></P>
    <P>email: <input type="text" name="email" size="20" value="${userById.email}"/></P>
    <P>country: <input type="text" name="country" size="20" value="${userById.country}"/></P>
    <P>mobile: <input type="text" name="mobile" size="20" value="${userById.mobile}"/></P>
    <p>
        <button type="submit">Обновить</button>
    </p>
</form>

</body>
</html>
