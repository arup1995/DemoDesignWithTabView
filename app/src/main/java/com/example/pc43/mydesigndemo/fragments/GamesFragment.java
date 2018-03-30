package com.example.pc43.mydesigndemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc43.mydesigndemo.R;
import com.example.pc43.mydesigndemo.ResponseSingleton;
import com.example.pc43.mydesigndemo.adapters.GamesFragmentAdapter;
import com.example.pc43.mydesigndemo.models.UserResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {


    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games, container, false);
        RecyclerView recyclerViews = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViews.setLayoutManager(linearLayoutManager);
        recyclerViews.hasFixedSize();
        UserResponse userResponse = ResponseSingleton.getInstance().getUserResponseData();
        recyclerViews.setAdapter(new GamesFragmentAdapter(userResponse.getRecycler(), getActivity()));
        // Inflate the layout for this fragment


        return view;
    }

}
