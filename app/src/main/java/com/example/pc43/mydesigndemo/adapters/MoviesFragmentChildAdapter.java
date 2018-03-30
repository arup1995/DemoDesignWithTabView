package com.example.pc43.mydesigndemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pc43.mydesigndemo.R;
import com.example.pc43.mydesigndemo.models.InnerChild;

import java.util.List;

public class MoviesFragmentChildAdapter extends RecyclerView.Adapter<MoviesFragmentChildAdapter.MyViewHolder> {
    private List<InnerChild> innerChildList;
    private final Context context;

    MoviesFragmentChildAdapter(List<InnerChild> innerChildList, Context context) {
        this.innerChildList = innerChildList;
        this.context = context;
    }
    @NonNull
    @Override
    public MoviesFragmentChildAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_movies_childone, parent, false);
        return new MoviesFragmentChildAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesFragmentChildAdapter.MyViewHolder holder, int position) {
        InnerChild innerChild = innerChildList.get(position);
        holder.mTitle.setText(innerChild.getTitle());
        Glide.with(context).load(innerChild.getImageUrl()).into(holder.mProfile);

    }

    @Override
    public int getItemCount() {
        return innerChildList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView mProfile;
        TextView mTitle;

        MyViewHolder(View itemView) {
            super(itemView);
            mProfile = (ImageView) itemView.findViewById(R.id.profile);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
