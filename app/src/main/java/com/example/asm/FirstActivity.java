package com.example.asm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
     ProgressBar progressBar;
     TextView textView;
     Handler handler = new Handler();
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao);
        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.tv_chay);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgress();
                startActivity(new Intent(FirstActivity.this, LoginActivity.class));
            }
        });
        thread.start();
    }

    public void startProgress() {
        for (i = 0; i < 100; i = i + 1) {
            try {
                Thread.sleep(50);
                progressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(i + "%");
                }
            });
        }

    }
}