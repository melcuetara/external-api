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
    <s:form action="ListNews">
      <s:select label="Select Language" 
      list="languages" 
      name="selectedLanguage" />
      <s:select label="Sort By" 
      list="sortTypes" 
      name="selectedSortType" />
      <s:textfield key="keyword"/>
      <s:submit />
    </s:form>
    <s:iterator value="newsResponse.articles">
      <fieldset>
        <s:property value="publishedAt" /><br />
        <s:property value="title"/> by: <s:property value="author" /><br />
        <s:property value="description" /><br />
        <a href='<s:property value="url"/>'>read more</a><br />
      </fieldset>
    </s:iterator>
  </body>
</html>
