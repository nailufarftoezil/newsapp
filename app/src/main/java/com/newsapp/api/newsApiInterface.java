package com.newsapp.api;

import com.newsapp.model.Article;
import com.newsapp.model.RootClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface newsApiInterface {

    @GET("top-headlines")
    Call<RootClass> getLatestNews(@Query("sources") String source, @Query("apiKey") String apiKey);
}
