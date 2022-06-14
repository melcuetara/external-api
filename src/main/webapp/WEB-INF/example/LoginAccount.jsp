<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>

<body>
    <h2>Login Account</h2>
<s:form action="LoginAccount">
    <s:textfield key="username"/>
    <s:password key="password" />
    <s:submit/>
</s:form>
<s:property value="error" />
</body>
</html>
