package com.geektech.lessonfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements IFragmentInterface{

    Button btnReplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReplace = findViewById(R.id.btnReplace);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.second_container,SecondFragment.newInstance("",""));
        transaction.addToBackStack(null);
        transaction.commit();

//
//        btnReplace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//           FragmentManager manager = getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                transaction.replace(R.id.second_container,FirstFragment.newInstance("",""));
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//         FragmentManager manager2 = getSupportFragmentManager();
//                FragmentTransaction transaction2 = manager2.beginTransaction();
//                transaction2.replace(R.id.first_container,SecondFragment.newInstance("",""));
//                transaction2.addToBackStack(null);
//                transaction2.commit();
//            }
//        });

    }

    @Override
    public void sendNews(String text) {
        FragmentManager manager = getSupportFragmentManager();
        FirstFragment fragment = (FirstFragment) manager.findFragmentById(R.id.first_container);
        fragment.openNews(text);
    }

    @Override
    public void sendNewsDesc(String text) {
        FragmentManager manager = getSupportFragmentManager();
        SecondFragment fragment = (SecondFragment) manager.findFragmentById(R.id.second_container);
        fragment.resultDesc(text);
    }
}