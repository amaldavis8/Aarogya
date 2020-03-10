package com.example.aarogya;

    import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

    public class appoinment extends AppCompatActivity {
        CheckBox cb1,cb2,cb3;
        Button b1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.appoinment);

            //get the spinner from the xml.
            Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
            String[] items = new String[]{"select hospital","Medical Hospital Chalakudy", "Medical Hospital Ernakulam", "Medical Hospital Thrissur"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
            dropdown.setAdapter(adapter);
            cb1 = (CheckBox) findViewById(R.id.checkBox_Medical);
            cb2 = (CheckBox) findViewById(R.id.checkBox_Health);
            cb3 = (CheckBox) findViewById(R.id.checkBox_Others);


        }}
//        buttonApply.setOnClickListener(new View.OnClickListener(){
//            radioButton = findViewById(radioId);
//        }
//        public void checkButton(View v)
//        {
//            int radioId = radioGroup.getCheckedRadioButtonId();
//            radioButton = findViewById(radioId);
//            Toast.makeText( context: this, text: "selected"+ radioButton.getText(), Toast.LENGTH_SHORT).show();
//
//            @Override
//            public  void onClick(View v){
//            }


