package com.example.aarogya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public EditText loginEmailId, logInpasswd;
    Button btnLogIn;
    RadioGroup userchoice;
    RadioButton user;
    RadioButton userHospital;
    RadioButton userDepartment;
    RadioButton userPharmacy;
    TextView signup;
    public static String usernameT;
    public static String Age;

    public void login(View view)
    {
        final String username = loginEmailId.getText().toString();
        final String pass = logInpasswd.getText().toString();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;

       // public void checkButton(View view) {
        // Is the button now checked?
       // boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(userchoice.getCheckedRadioButtonId()) {
            case R.id.userRadio:
               // if (checked) {
                    myRef = database.getReference("User");
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                if (ds.child("username").getValue().toString().equalsIgnoreCase(username)) {
                                    if (ds.child("passwd").getValue().toString().equals(pass)) {
                                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                        usernameT = username;
                                       // Age = ds.child("Age").getValue().toString();
                                        Intent in = new Intent(MainActivity.this, Interface.class);
                                        startActivity(in);
                                        break;
                                    }

                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;

            case R.id.hospitalRadio:

                myRef = database.getReference("lhospital");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            if (ds.child("username").getValue().toString().equalsIgnoreCase(username)) {
                                if (ds.child("password").getValue().toString().equals(pass)) {
                                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    usernameT = username;
                                    //Age = ds.child("Age").getValue().toString();
                                    Intent l = new Intent(MainActivity.this, HospitalInterface.class);
                                    startActivity(l);
                                    break;
                                }

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;


            case R.id.departmentRadio:

                myRef = database.getReference("ldepartment");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            if (ds.child("username").getValue().toString().equalsIgnoreCase(username)) {
                                if (ds.child("password").getValue().toString().equals(pass)) {
                                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    usernameT = username;
                                    //Age = ds.child("Age").getValue().toString();
                                    Intent m = new Intent(MainActivity.this, DepartmentInterface.class);
                                    startActivity(m);
                                    break;
                                }

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;



            case R.id.pharmacyRadio:

                myRef = database.getReference("lpharmacy");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            if (ds.child("username").getValue().toString().equalsIgnoreCase(username)) {
                                if (ds.child("password").getValue().toString().equals(pass)) {
                                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    usernameT = username;
                                    //Age = ds.child("Age").getValue().toString();
                                    Intent j = new Intent(MainActivity.this, PharmacyInterface.class);
                                    startActivity(j);
                                    break;
                                }

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;



        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEmailId = findViewById(R.id.loginEmail);
        logInpasswd = findViewById(R.id.loginpaswd);
        userchoice = findViewById(R.id.choicegroup);

        user = findViewById(R.id.userRadio);
        userHospital = findViewById(R.id.hospitalRadio);
        userDepartment = findViewById(R.id.departmentRadio);
        userPharmacy = findViewById(R.id.pharmacyRadio);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, SignUp.class);
                startActivity(I);

                //FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference myRef = database.getReference("message");
            }
        });

    }

//    public void pharmacy_click(View view) {
//        Intent intent = new Intent(MainActivity.this, Pharmacy.class);
//        startActivity(intent);
//        this.finish();
//    }
}
