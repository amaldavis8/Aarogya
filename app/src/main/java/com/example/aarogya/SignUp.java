package com.example.aarogya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    String userNameString;
    DatabaseReference myRef;
    EditText editText, editTextValue, editTextValue1, editTextValue2, editTextValue3, editTextValue4, editTextValue5, editTextValue6;
    TextView myText;
    Button button;
    CheckBox yes;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_user:
                if (checked)
                    //
                    break;
            case R.id.radio_department: {
                if (checked)
                    //
                    break;
            }
            case R.id.radio_hospital:
                if (checked)
                    //
                    break;
        }
    }
    EditText userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User");
        myText = (TextView) findViewById(R.id.textView);
        myText = (TextView) findViewById(R.id.textView2);

        yes = (CheckBox) findViewById(R.id.checkBox);
        myText = (TextView) findViewById(R.id.textVie);

        final Spinner bgp = findViewById(R.id.bgpspinner);
        String[] items = new String[]{"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        bgp.setAdapter(adapter);

        final EditText simpleEditText = (EditText) findViewById(R.id.simpleEditText);


        final EditText simEditText = (EditText) findViewById(R.id.simEditText);


        final EditText ageEditText = (EditText) findViewById(R.id.ageEditText);


        EditText sEditText = (EditText) findViewById(R.id.sEditText);


        final EditText simpEditText = (EditText) findViewById(R.id.simpEditText);

         userName = (EditText) findViewById(R.id.userNameEditText);

        final EditText nEditText = (EditText) findViewById(R.id.nEditText);









        //create a list of items for the spinner.

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.

        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                 userNameString= userName.getText().toString();
                int selectedRadioButtonID = rg.getCheckedRadioButtonId();
                 RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                String selectedRadioButtonText = selectedRadioButton.getText().toString();
                Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_LONG).show();
                myRef.child(userNameString).child("username").setValue(userNameString);
                myRef.child(userNameString).child("Age").setValue(ageEditText.getText().toString());
                myRef.child(userNameString).child("bgp").setValue(bgp.getSelectedItem().toString());
                myRef.child(userNameString).child("fname").setValue(simpleEditText.getText().toString());
                myRef.child(userNameString).child("gender").setValue(selectedRadioButtonText);
                myRef.child(userNameString).child("lname").setValue(simEditText.getText().toString());
                myRef.child(userNameString).child("passwd").setValue(nEditText.getText().toString());
                myRef.child(userNameString).child("phone").setValue(simpEditText.getText().toString());

                Intent i = new Intent(SignUp.this,Interface.class);
                startActivity(i);




            }

        });


    }
}
