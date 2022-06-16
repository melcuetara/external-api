<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
</head>

<body>
    <h2>Create Account</h2>
<s:form action="CreateAccount">
    <s:textfield key="username"/>
    <s:password key="password" />
    <s:submit/>
</s:form>
<s:property value="error" />
</body>
</html>
