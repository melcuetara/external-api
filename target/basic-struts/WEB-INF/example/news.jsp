<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <sx:head />
  </head>
  <body>
      asdf
    <s:property value="message"/>
    <s:iterator value="newsResponse.articles">
      <fieldset>
        <s:property value="content" /><br />
        <s:property value="title" /><br />
        <s:property value="author" /><br />
      </fieldset>
    </s:iterator>
    
  </body>
</html>
