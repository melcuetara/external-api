package com.example.example.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.example.model.NewsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class News extends ActionSupport{
    
    private final String API_KEY = "bd18a26f73ec43d487609e0287dd9098";
    private NewsResponse newsResponse;
    private String message;
    private String[] languages = {"en", "es", "fr"};
    private String selectedLanguage;
    private String[] sortTypes = {"relevancy", "popularity", "publishedAt"};
    private String selectedSortType;
    private String keyword;
    
    
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String[] getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String[] sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getSelectedSortType() {
        return selectedSortType;
    }

    public void setSelectedSortType(String selectedSortType) {
        this.selectedSortType = selectedSortType;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public String getMessage() {
        return "abcd";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NewsResponse getNewsResponse() {
        return newsResponse;
    }

    public void setNewsResponse(NewsResponse newsResponse) {
        this.newsResponse = newsResponse;
    }


    public String execute() throws Exception {
        String format = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(calendar.getTime());
        try {
 
            URL url = new URL("https://newsapi.org/v2/everything?q=" + keyword + "&searchIn=title,description&from=" + currentDate
                    + "&sortBy=" + selectedSortType + "&language=" + selectedLanguage + "&apiKey=" + API_KEY);
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
                newsResponse = mapper.readValue(output, NewsResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

}
