package com.example.pc43.mydesigndemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pc43.mydesigndemo.MainActivity;
import com.example.pc43.mydesigndemo.R;
import com.example.pc43.mydesigndemo.ResponseSingleton;
import com.example.pc43.mydesigndemo.adapters.Gamesadapter;
import com.example.pc43.mydesigndemo.models.Recycler;
import com.example.pc43.mydesigndemo.models.Userresponse;
import com.example.pc43.mydesigndemo.mydesigndemosdk.MyDesignDemoSdk;
import com.example.pc43.mydesigndemo.mydesigndemosdk.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Games extends Fragment {


    public Games() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games, container, false);
        RecyclerView mRecyclerViews = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViews.setLayoutManager(linearLayoutManager);
        mRecyclerViews.hasFixedSize();
        Userresponse userresponse = ResponseSingleton.getInstance().getUserResponseData();
        mRecyclerViews.setAdapter(new Gamesadapter(userresponse.getRecycler(), getActivity()));
        // Inflate the layout for this fragment


        return view;
    }

}
