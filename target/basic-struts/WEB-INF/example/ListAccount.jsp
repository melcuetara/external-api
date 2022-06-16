<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>

<head>
  <sx:head />
</head>

<body>
  <s:include value="Navigation.jsp" />
  <s:form action="displayUser">
    <sx:autocompleter label="Choose your record" list="username" name="input" />
    <s:submit />
  </s:form>
  <h3>All User Records:</h3>
  <s:iterator value="users">
    <fieldset>
      <s:property value="username" /><br />
      <s:property value="password" /><br />
    </fieldset>
  </s:iterator>
  <p><a href="<s:url action='index' />">Return to home page</a>.</p>
</body>

</html>