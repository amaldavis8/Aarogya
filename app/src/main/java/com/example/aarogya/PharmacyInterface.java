package com.example.aarogya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.aarogya.MainActivity.usernameT;

public class PharmacyInterface extends AppCompatActivity {

    String medicineName, medicineUnits, medicineName2, medicineUnits2;
    DatabaseReference myRef;
    Button buttonAdd1, buttonAdd2, buttonRemove, buttonUpdate1, buttonUpdate2;
    TextView textViewNew, textViewUpdate;
    EditText editTextMedName1, editTextMedName2, editTextUnits, editTextUnits2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter_pharmacy);

        buttonAdd1 = (Button) findViewById(R.id.buttonAdd1);
        buttonAdd2 = (Button) findViewById(R.id.buttonAdd2);


        textViewNew = (TextView) findViewById(R.id.textViewNew);
        textViewUpdate = (TextView) findViewById(R.id.textViewUpdate);

        editTextMedName1 = (EditText) findViewById(R.id.editTextMedicine);
        editTextMedName2 = (EditText) findViewById(R.id.editTextMedicine2);
        editTextUnits = (EditText) findViewById(R.id.editTextUnits);
        editTextUnits2 = (EditText) findViewById(R.id.editTextUnits2);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Pharmacy");


    }

    public void addNew(View view) {
        medicineName = editTextMedName1.getText().toString();
        medicineUnits = editTextUnits.getText().toString();

        myRef.child(usernameT).child(medicineName).child("Stock").setValue(medicineUnits);
        myRef.child(usernameT).child(medicineName).child("name").setValue(medicineName);
    }

    public void updateStock(View view) {
        medicineName2 = editTextMedName2.getText().toString();
        medicineUnits2 = editTextUnits2.getText().toString();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot./*child(usernameT).*/getChildren()) {
                    if (ds/*.child(usernameT)*/.child(medicineName2).child("name").getValue().toString().equalsIgnoreCase(medicineName2)) {
                        myRef.child(usernameT).child(medicineName2).child("Stock").setValue(medicineUnits2);
                        //ds.child(usernameT).child(medicineName2).child("Stock").set
                        Toast.makeText(PharmacyInterface.this, "Updated Successfully", Toast.LENGTH_SHORT).show();

                        break;
                    }

                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

