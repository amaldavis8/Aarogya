package com.example.aarogya;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Emergency extends AppCompatActivity {

TextView tview1,tview2,tview3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setContentView(R.layout.emergency);
        tview1 = findViewById(R.id.detail1);
        tview2= findViewById(R.id.detail2);
        tview3= findViewById(R.id.detail3);

    }
}
