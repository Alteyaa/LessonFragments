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
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
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
        listener = (IFragmentInterface) context;
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
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

        btnOpenNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.sendNews("Цифра дня. 179 тысяч 707 звонков поступило за все время в кол-центр 118");
            }
        });

        txtNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.sendNewsDesc("По ее данным, «Линия самодиагностики — 118»" +
                        " запущена 6 апреля мэрией Бишкека совместно с Минздравом КР, " +
                        "Городским управлением здравоохранения, Фондом «Сорос-Кыргызстан»," +
                        " ОАО «Кыргызтелеком» и швейцарским проектом «Реформы медицинского образования»");
            }
        });

    }

    public void openNews(String text){
        txtNews.setText(text);
    }
}