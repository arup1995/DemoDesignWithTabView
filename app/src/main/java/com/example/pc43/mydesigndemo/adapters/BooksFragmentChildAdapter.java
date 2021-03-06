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

public class BooksFragmentChildAdapter extends RecyclerView.Adapter<BooksFragmentChildAdapter.MyViewHolder> {
    private List<InnerChild> innerChildList;
    private final Context context;

    BooksFragmentChildAdapter(List<InnerChild> innerChildList, Context context) {
        this.innerChildList = innerChildList;
        this.context = context;
    }

    @NonNull
    @Override
    public BooksFragmentChildAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_books_child_one, parent, false);
        return new BooksFragmentChildAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksFragmentChildAdapter.MyViewHolder holder, int position) {

        InnerChild innerChild = innerChildList.get(position);
        holder.mTitle.setText(innerChild.getTitle());
        Glide.with(context).load(innerChild.getImageUrl()).into(holder.mProfile);
    }

    @Override
    public int getItemCount() {
        return innerChildList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mProfile;
        TextView mTitle;

        MyViewHolder(View itemView) {
            super(itemView);
            mProfile = (ImageView) itemView.findViewById(R.id.profile);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
