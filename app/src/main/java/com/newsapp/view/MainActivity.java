package com.newsapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.newsapp.R;
import com.newsapp.model.Article;
import com.newsapp.model.RootClass;
import com.newsapp.api.newsApiInterface;
import com.newsapp.api.newsApiClient;
import com.newsapp.view.CustomListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "08a3a6d3b2004157a063cd86c5464c7f";

        Call<RootClass> RootClass;
//    newsApiInterface mNewsApiInterface;
    ListView lv;
    CustomListAdapter customListAdapter;
    List<Article>  listArticle;
//    TextView title, detail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        lv = findViewById(R.id.list_news_all);
//        listArticle = new ArrayList<Article>();


        final newsApiInterface mNewsApiInterface = newsApiClient.getClient().create(newsApiInterface.class);

        Call<RootClass> call = mNewsApiInterface.getLatestNews("techcrunch", API_KEY);

        call.enqueue(new Callback<RootClass>() {
            @Override
            public void onResponse(Call<RootClass> call, Response<RootClass> response) {
                if(response.body().getStatus().equals("ok")){
                    List<Article> article = Arrays.asList(response.body().getArticles());
                    if(article.size()>0) {
                        listArticle = article;
                        showList();
                    }

                }
            }

            @Override
            public void onFailure(Call<RootClass> call, Throwable t) {
                Log.e("out", t.toString());
            }
        });



    }
    private void showList() {
        String[] items = new String[listArticle.size()];

        for (int i = 0; i < listArticle.size(); i++) {
            items[i] = listArticle.get(i).getTitle();
        }

        customListAdapter = new CustomListAdapter(this, R.layout.list_news, listArticle);
        lv.setAdapter(customListAdapter);


    }







}