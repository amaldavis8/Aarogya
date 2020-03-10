package com.example.aarogya;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HospitalInterface extends AppCompatActivity {

    Button button_home,button_services,button_post_1,button_post_2;
    TextView textView,textView2;
    EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter_hospital);
        button_home = (Button) findViewById(R.id.button_home);
        button_services = (Button) findViewById(R.id.button_services);
        button_post_1 = (Button) findViewById(R.id.button_post_1);
        button_post_2 = (Button) findViewById(R.id.button_post_2);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

    }
}
