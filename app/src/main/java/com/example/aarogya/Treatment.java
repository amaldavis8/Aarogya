package com.example.aarogya;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class Treatment extends AppCompatActivity {

    private Spinner spinner;

    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treatment);

        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.r1);
        radioButton2 = findViewById(R.id.r2);
        spinner = findViewById(R.id.spinner);



    }

    public void checkButton(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.r1:
                if (checked) {

                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.hospital_list, android.R.layout.simple_spinner_item);
                    spinner.setAdapter(adapter);
                    break;
                }
            case R.id.r2:
                if (checked) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.treatment_list, android.R.layout.simple_spinner_item);
                    spinner.setAdapter(adapter);
                    break;
                }
        }


    }

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

}


