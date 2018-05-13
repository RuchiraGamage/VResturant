package com.example.ruchira.vresturant;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruchira.vresturant.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import info.hoang8f.widget.FButton;

public class SignIn extends AppCompatActivity {

    EditText phoneno,password;
    FButton signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    phoneno=findViewById(R.id.phone_no);
    password=findViewById(R.id.pass_word);
    signIn=findViewById(R.id.signinn);

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        final DatabaseReference reference=firebaseDatabase.getReference("User");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please waiting ...");
                mDialog.show();

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(phoneno.getText().toString()).exists()){

                            mDialog.dismiss();
                            User user=dataSnapshot.child(phoneno.getText().toString()).getValue(User.class);
                            if(user.getPassword().equals(password.getText().toString())){
                                Toast.makeText(getBaseContext(),"Login success",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getBaseContext(),"password is incorrect",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            mDialog.dismiss();
                            Toast.makeText(getBaseContext(),"User not exists in the database",Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
