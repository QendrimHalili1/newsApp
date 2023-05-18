package com.example.news24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news24.Models.NewsHeadLines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CostumViewHolder> {
    private Context context;
    private List<NewsHeadLines> headLines;

    public CustomAdapter(Context context, List<NewsHeadLines> headLines) {
        this.context = context;
        this.headLines = headLines;
    }

    @NonNull
    @Override
    public CostumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CostumViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CostumViewHolder holder, int position) {
        holder.text_title.setText(headLines.get(position).getTitle());
        holder.text_source.setText(headLines.get(position).getSource().getName());
        if(headLines.get(position).getUrlToImage()!=null)
        {
            Picasso.get().load(headLines.get(position).getUrlToImage()).into(holder.img_headline);
        }
    }

    @Override
    public int getItemCount() {
        return headLines.size();
    }
}
