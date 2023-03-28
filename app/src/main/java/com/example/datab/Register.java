package com.example.datab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;


public class Register extends AppCompatActivity {
    private EditText email,pass;
    private Button submit;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth= FirebaseAuth.getInstance();
        email=findViewById(R.id.email1);
        pass=findViewById(R.id.pass1);
        submit=findViewById(R.id.submit);
        progressBar=findViewById(R.id.progress);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });


    }

     void registerUser(){
       progressBar.setVisibility(View.VISIBLE);
       String Email,Pass;
       Email=email.getText().toString();
       Pass=pass.getText().toString();
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(Pass)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        else {
        mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this,Login.class));
                    finish();
                }
               else {
                    FirebaseAuthException e = (FirebaseAuthException)task.getException();
                   Toast.makeText(Register.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();

                   progressBar.setVisibility(View.GONE);
             }
           }
        });
        }
//        mAuth.createUserWithEmailAndPassword(Email,Pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//            @Override
//            public void onSuccess(AuthResult authResult) {
//                HashMap<String,Object>map=new HashMap<>();
//                map.put("Email",Email);
//                map.put("id",mAuth.getCurrentUser().getUid());
//
//            }
//        });
    }
}