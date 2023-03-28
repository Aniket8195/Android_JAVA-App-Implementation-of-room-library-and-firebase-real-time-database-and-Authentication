package com.example.datab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText email,pass;
    private Button login,register;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        auth= FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Login.this,Register.class));

          }
      });
      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String Email,Pass;
              Email=email.getText().toString();
              Pass=pass.getText().toString();
              auth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if (!task.isSuccessful()) {
                          Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();



                      }
                      else {
                          startActivity(new Intent(Login.this,MainActivity.class));
                      }
                  }
              });
          }
      });

    }
}