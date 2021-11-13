package com.newsapp.model;

import org.json.*;

import com.google.gson.annotations.SerializedName;


public class Source{

    @SerializedName("id")
    private Object id;
    @SerializedName("name")
    private String name;

    public void setId(Object id){
        this.id = id;
    }
    public Object getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public Source(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        name = (String) jsonObject.opt("name");
        id = jsonObject.opt("id");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("name", name);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
