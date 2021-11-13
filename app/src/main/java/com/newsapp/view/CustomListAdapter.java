package com.newsapp.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.internal.LinkedTreeMap;
import com.newsapp.R;
import com.newsapp.model.Article;
import com.newsapp.model.RootClass;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter<Article>  {
    List<Article> articles;
    Context context;
    int layout;

    public CustomListAdapter(Context context, int layout, List<Article> articles){
        super(context, layout, articles);
        this.context=context;
        this.layout=layout;
        this.articles =articles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        ArticleHolder holder;

        if (v==null){
            LayoutInflater vi = ((Activity)context).getLayoutInflater();
            v = vi.inflate(layout, parent, false);

            holder = new ArticleHolder();
            holder.titleArticle = (TextView) v.findViewById(R.id.list_title);
            holder.detailArticle = (TextView) v.findViewById(R.id.list_detail);
//            holder.imageView = (TextView) v.findViewById(R.id.list_img);

            v.setTag(holder);
        }else {
            holder = (ArticleHolder) v.getTag();
        }

        Article article =  articles.get(position);
//        holder.imageView.setText(article.getUrlToImage());
        holder.detailArticle.setText(article.getDescription());
        holder.titleArticle.setText(article.getTitle());

        return v;
    }

    static class ArticleHolder{
        TextView imageView;
        TextView titleArticle;
        TextView detailArticle;
        TextView ageView;
        TextView sexView;
    }
}