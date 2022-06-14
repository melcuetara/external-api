<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="HelloWorld.message"/></title>
</head>

<body>
<h2><s:property value="message"/></h2>

<h3>Languages</h3>
<ul>
    <li>
        <s:url var="url" action="CreateAccount">
        </s:url>
        <s:a href="%{url}">Create Account</s:a>
    </li>
    <li>
        <s:url var="url" action="LoginAccount">
        </s:url>
        <s:a href="%{url}">Login Account</s:a>
    </li>
</ul>

</body>
</html>
