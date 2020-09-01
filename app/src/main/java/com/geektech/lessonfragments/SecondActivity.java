package com.geektech.lessonfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.second_container,SecondFragment.newInstance("",""));
        transaction.commit();

    }

    public void sendResult(String text){
        Intent intent = new Intent();
        intent.putExtra("task",text);
        setResult(RESULT_OK,intent);
        finish();
    }
}