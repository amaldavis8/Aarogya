package com.example.aarogya;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.aarogya.MainActivity.usernameT;

public class Pharmacy extends AppCompatActivity {

    EditText editText;
    TextView myText;
    Button search;
    String query;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharmacy);

        editText = (EditText) findViewById(R.id.editText);
        myText=(TextView)findViewById(R.id.resultView);
        search=(Button)findViewById(R.id.searchBt);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Pharmacy");


    }

    public void Search(View view) {
        query=editText.getText().toString();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot./*child(usernameT).*/getChildren()) {
                    if ((ds.child(query).child("name").getValue().toString().equalsIgnoreCase(query)))
                    //&&((ds/*.child(usernameT)*/.child(query).child("name").getValue())>0))
                    {//String var=myRef.child(ds);
                        //DataSnapshot var= ds;
                        //myRef.child(var)
                       // myRef.child(usernameT).child(medicineName2).child("Stock").setValue(medicineUnits2);
                        //ds.child(usernameT).child(medicineName2).child("Stock").set
                       String var= ds.child(query).child("store").getValue().toString();
                        //Toast.makeText(Pharmacy.this, var, Toast.LENGTH_SHORT).show();
                    myText.setText(var);
                        break;

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                };
           });
        };
    }
