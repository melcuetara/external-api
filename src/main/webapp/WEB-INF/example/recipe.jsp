<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
      <!DOCTYPE html>
      <html>

      <head>
        <style type="text/css">
          * {
            margin: 0px;
            padding: 0px;
          }

          body {
            font-family: arial;
          }

          .main {

            margin: 2%;
          }

          .card {
            width: 20%;
            display: inline-block;
            box-shadow: 2px 2px 20px black;
            border-radius: 5px;
            margin: 2%;
          }

          .image img {
            width: 100%;
            border-top-right-radius: 5px;
            border-top-left-radius: 5px;
          }

          .title {
            text-align: center;
            padding: 10px;
          }

          h1 {
            font-size: 20px;
          }

          .des {
            padding: 3px;
            text-align: center;

            padding-top: 10px;
            border-bottom-right-radius: 5px;
            border-bottom-left-radius: 5px;
          }

          button {
            margin-top: 40px;
            margin-bottom: 10px;
            background-color: white;
            border: 1px solid black;
            border-radius: 5px;
            padding: 10px;
          }

          button:hover {
            background-color: black;
            color: white;
            transition: .5s;
            cursor: pointer;
          }
        </style>
      </head>
      <body>
        <s:form action="Recipe">
          <s:select label="Select Meal Type" 
            list="mealTypes" 
            name="selectedMeal" />
          <s:select label="Select Cuisine Type" 
            list="cuisineTypes" 
            name="selectedCuisine" />
          <s:textfield key="search" label="Search Keyword" />
          <s:submit />
        </s:form>
      <s:iterator value="response.hits">
      <div class="card">
        <div class="image">
          <img src="<s:property value='recipe.image' />" />
        </div>
        <div class="title">
          <h1>
            <s:property value="recipe.label" />
          </h1>
        </div>
        <div class="des">
          <p>
            Source: <s:property value="recipe.source" /> </br>
            Meal: <s:property value="recipe.mealType" /> </br>
            Dish: <s:property value="recipe.dishType" /> </br>
            Cuisine: <s:property value="recipe.cuisineType" /> </br>
            Calories: <s:property value="recipe.calories" />kcal
          </p>
          <s:form action="SelectRecipe" >
            <button>Get Recipe</button>
          </s:form>
        </div>
      </div>
      </s:iterator>    
      </body> 
      </html>