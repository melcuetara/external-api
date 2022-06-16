package com.example.example.recipe;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    private String uri;
    private String label;
    private String image;
    private InlineModel1 images;
    private String source;
    private String url;
    private String shareAs;
    private double yield;
    private String[] dietLabels;
    private String[] healthLabels;
    private String[] cautions;
    private String[] ingredientLines;
    private ArrayList<Ingredient> ingredients;
    private double calories;
    private String[] cuisineType;
    private String[] mealType;
    private String[] dishType;
    private NutrientsInfo totalNutrients;
    private NutrientsInfo totalDaily;
    private Double totalTime;
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public InlineModel1 getImages() {
        return images;
    }
    public void setImages(InlineModel1 images) {
        this.images = images;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getShareAs() {
        return shareAs;
    }
    public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
    }
    
    public double getYield() {
        return yield;
    }
    public void setYield(double yield) {
        this.yield = yield;
    }
    public String[] getDietLabels() {
        return dietLabels;
    }
    public void setDietLabels(String[] dietLabels) {
        this.dietLabels = dietLabels;
    }
    public String[] getHealthLabels() {
        return healthLabels;
    }
    public void setHealthLabels(String[] healthLabels) {
        this.healthLabels = healthLabels;
    }
    public String[] getCautions() {
        return cautions;
    }
    public void setCautions(String[] cautions) {
        this.cautions = cautions;
    }
    public String[] getIngredientLines() {
        return ingredientLines;
    }
    public void setIngredientLines(String[] ingredientLines) {
        this.ingredientLines = ingredientLines;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public String getCalories() {
        return String.format("%,.2f", calories);
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public String[] getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(String[] cuisineType) {
        this.cuisineType = cuisineType;
    }
    public String[] getMealType() {
        return mealType;
    }
    public void setMealType(String[] mealType) {
        this.mealType = mealType;
    }
    public String[] getDishType() {
        return dishType;
    }
    public void setDishType(String[] dishType) {
        this.dishType = dishType;
    }
    public NutrientsInfo getTotalNutrients() {
        return totalNutrients;
    }
    public void setTotalNutrients(NutrientsInfo totalNutrients) {
        this.totalNutrients = totalNutrients;
    }
    public NutrientsInfo getTotalDaily() {
        return totalDaily;
    }
    public void setTotalDaily(NutrientsInfo totalDaily) {
        this.totalDaily = totalDaily;
    }
    public Double getTotalTime() {
        return totalTime;
    }
    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    

}
