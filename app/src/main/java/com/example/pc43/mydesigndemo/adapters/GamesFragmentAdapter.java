package com.example.pc43.mydesigndemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc43.mydesigndemo.R;
import com.example.pc43.mydesigndemo.ResponseSingleton;
import com.example.pc43.mydesigndemo.models.Recycler;
import com.example.pc43.mydesigndemo.models.UserResponse;

import java.util.List;

public class GamesFragmentAdapter extends RecyclerView.Adapter<GamesFragmentAdapter.MyViewHolder> {

    private List<Recycler> recycler;
    private final Context context;

    public GamesFragmentAdapter(List<Recycler> recycler, Context context) {
        this.recycler = recycler;
        this.context = context;
    }

    @NonNull
    @Override
    public GamesFragmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_games_child, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesFragmentAdapter.MyViewHolder holder, int position) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        //holder.mrecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true));
        UserResponse userResponse = ResponseSingleton.getInstance().getUserResponseData();
        holder.mRecyclerView.setAdapter(new GamesFragmentChildAdapter(userResponse.getRecycler().get(position).getInnerChild(), context));
    }

    @Override
    public int getItemCount() {
        return recycler.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;

        MyViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerViewOne);
        }
    }
}
