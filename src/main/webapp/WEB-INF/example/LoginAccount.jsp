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
<s:property value="error" /> </br>
<s:property value="token" /> </br>
<a href="https://henisozakaqoyibi.hub.loginradius.com/auth.aspx?action=logout&return_url=http://localhost:8080/example/LoginAccount.action"> Logout </a></br>
<a href="https://henisozakaqoyibi.hub.loginradius.com/auth.aspx?action=register&return_url=http://localhost:8080/example/LoginAccount.action"> Login via LoginRadius </a>
            
</body>
</html>
