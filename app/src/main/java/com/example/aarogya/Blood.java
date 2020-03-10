package com.example.aarogya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Blood extends AppCompatActivity {

    TextView myText;
    EditText result;
    Spinner mySpinner;
    DatabaseReference myRef;
    String bank,storage;



    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("dname");
        myText = (TextView) findViewById(R.id.textView2);
        myText = (TextView) findViewById(R.id.textView3);
        result= (EditText) findViewById(R.id.editText);

        final Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
        String[] items = new String[]{"Select District", "thrissur", "ernakulam", "kottayam"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        dynamicSpinner.setAdapter(adapter1);
        dynamicSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){

                final String district1= dynamicSpinner.getSelectedItem().toString();
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.child(district1).getChildren()) {
                           // if(ds.getValue(String.class).equals("dname")) {
                                //Toast.makeText(Blood.this, "gjhfhf", Toast.LENGTH_SHORT).show();
                                if (ds.child("district").getValue().toString().equalsIgnoreCase(district1)) {
                                    bank = ds.child("name").getValue().toString();
                                    //Toast.makeText(Blood.this, bank, Toast.LENGTH_SHORT).show();

                                    result.setText(bank);
                                    break;

                                }


                            //}

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }


                    //String bank= myRef.child(district).child("bank").child("name").getValue



        });
    }
}

