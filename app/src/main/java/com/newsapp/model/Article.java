package com.newsapp.model;

import org.json.*;

import com.google.gson.annotations.SerializedName;


public class Article{

    @SerializedName("author")
    private String author;
    @SerializedName("content")
    private String content;
    @SerializedName("description")
    private String description;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("source")
    private Source source;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String urlToImage;

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setPublishedAt(String publishedAt){
        this.publishedAt = publishedAt;
    }
    public String getPublishedAt(){
        return this.publishedAt;
    }
    public void setSource(Source source){
        this.source = source;
    }
    public Source getSource(){
        return this.source;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){return this.title; }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrlToImage(String urlToImage){
        this.urlToImage = urlToImage;
    }
    public String getUrlToImage(){
        return this.urlToImage;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public Article(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        author = (String) jsonObject.opt("author");
        content = (String) jsonObject.opt("content");
        description = (String) jsonObject.opt("description");
        publishedAt = (String) jsonObject.opt("publishedAt");
        title = (String) jsonObject.opt("title");
        url = (String) jsonObject.opt("url");
        urlToImage = (String) jsonObject.opt("urlToImage");
        source = new Source(jsonObject.optJSONObject("source"));
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("author", author);
            jsonObject.put("content", content);
            jsonObject.put("description", description);
            jsonObject.put("publishedAt", publishedAt);
            jsonObject.put("title", title);
            jsonObject.put("url", url);
            jsonObject.put("urlToImage", urlToImage);
            jsonObject.put("source", source.toJsonObject());

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
