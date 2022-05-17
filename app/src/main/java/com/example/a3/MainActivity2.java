package com.example.a3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView textView2, button3;
    private EditText editTextFullName, editTextEmail, editTextPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth = FirebaseAuth.getInstance();

        textView2 = (TextView) findViewById(R.id.textView2);
        button3 = (TextView) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        editTextFullName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.textView2:
              startActivity(new Intent(this, MainActivity.class));
              break;
          case R.id.button3:
              registerUser();
              break;
      }
    }
    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullName = editTextFullName.getText().toString().trim();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            User user = new User(fullName, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

                        }
                    }
                });


    }
}