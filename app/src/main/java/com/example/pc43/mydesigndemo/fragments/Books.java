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
import com.example.pc43.mydesigndemo.adapters.BooksFragmentAdapter;
import com.example.pc43.mydesigndemo.adapters.Gamesadapter;
import com.example.pc43.mydesigndemo.models.Userresponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class Books extends Fragment {


    public Books() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_books, container, false);
        RecyclerView mRecyclerViews = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViews.setLayoutManager(linearLayoutManager);
        mRecyclerViews.hasFixedSize();
        Userresponse userresponse = ResponseSingleton.getInstance().getUserResponseData();
        mRecyclerViews.setAdapter(new BooksFragmentAdapter(userresponse.getRecycler(), getActivity()));
        return view;
    }

}
