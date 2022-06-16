<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
      <!DOCTYPE html>
      <html>

      <head>
      </head>
      <body>
      <s:iterator value="response.hits.recipe.ingredients">
        <fieldset>
            <s:property value="text" />
        </fieldset>
      </s:iterator>    
      </body> 
      </html>