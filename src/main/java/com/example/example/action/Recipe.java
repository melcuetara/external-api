package com.example.example.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.example.recipe.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class Recipe extends ActionSupport{
    
    private final String APP_ID = "24f1a656";
    private final String APP_KEY = "453fc9e84106d91636c935b5857382c2";
    private String search;
    private Response response;
    private String selectedMeal;
    private String selectedCuisine;
    private String[] mealTypes = {"Breakfast", "Dinner", "Lunch", "Snack", "Teatime"};
    private String[] cuisineTypes = {"American", "Asian", "British", "Carribean", "Central Europe"
                                    , "Chinese", "Eastern Europe", "French", "Indian", "Italian"
                                    , "Japanese", "Kosher", "Mediterranean", "Mexican", "Middle Eastern"
                                    , "Nordic", "South American", "South East Asian"};
               
    public String getSelectedMeal() {
        return selectedMeal;
    }

    public void setSelectedMeal(String selectedMeal) {
        this.selectedMeal = selectedMeal;
    }


    public String getSelectedCuisine() {
        return selectedCuisine;
    }

    public void setSelectedCuisine(String selectedCuisine) {
        this.selectedCuisine = selectedCuisine;
    }

    public String[] getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(String[] mealTypes) {
        this.mealTypes = mealTypes;
    }

    public String[] getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(String[] cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String execute() {
        try {
            if (getSearch() == null) {
                return INPUT;
            }
            URL url = new URL("https://api.edamam.com/api/recipes/v2?type=public&q=" + search + "&app_id=24f1a656&app_key=453fc9e84106d91636c935b5857382c2&cuisineType="+ selectedCuisine + "&mealType="+ selectedMeal);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
 
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
 
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                response = mapper.readValue(output, Response.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    } 

    public void displayRecipe() {
        
    }
}
