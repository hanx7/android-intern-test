package com.example.tv_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;

import com.example.tv_app.utils.BaseHttp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        // Show login page
        Intent i = new Intent(context, SummaryActivity.class);
        startActivity(i);
    }
}
