package com.geektech.lessonfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public TextView txtNews;
    public Button btnOpenNews;

    IFragmentInterface listener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    public FirstFragment() {
        // Required empty public constructor
    }


    public static FirstFragment newInstance(int page) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString("task");
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        txtNews = view.findViewById(R.id.txtView_first);
        btnOpenNews = view.findViewById(R.id.open_btn);

        txtNews.setText(mParam1);

        btnOpenNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             MainActivity activity = (MainActivity) getActivity();

             activity.openSecondActivity();

            }
        });

    }

    public void openNews(String position) {
        txtNews.setText(position);
    }
}