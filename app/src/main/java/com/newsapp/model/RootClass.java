package com.newsapp.model;

import com.google.gson.annotations.SerializedName;

import org.json.*;
import java.util.*;


public class RootClass{

    @SerializedName("articles")
    private Article[] articles;
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;

    public void setArticles(Article[] articles){
        this.articles = articles;
    }
    public Article[] getArticles(){
        return this.articles;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;
    }
    public int getTotalResults(){
        return this.totalResults;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public RootClass(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        status = (String) jsonObject.opt("status");
        totalResults = jsonObject.optInt("totalResults");
        JSONArray articlesJsonArray = jsonObject.optJSONArray("articles");
        if(articlesJsonArray != null){
            ArrayList<Article> articlesArrayList = new ArrayList<>();
            for (int i = 0; i < articlesJsonArray.length(); i++) {
                JSONObject articlesObject = articlesJsonArray.optJSONObject(i);
                articlesArrayList.add(new Article(articlesObject));
            }
            articles = (Article[]) articlesArrayList.toArray();
        }
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is
     * the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("status", status);
            jsonObject.put("totalResults", totalResults);
            if(articles != null && articles.length > 0){
                JSONArray articlesJsonArray = new JSONArray();
                for(Article articlesElement : articles){
                    articlesJsonArray.put(articlesElement.toJsonObject());
                }
                jsonObject.put("articles", articlesJsonArray);
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
