package com.example.a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
private Button Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Signup = (Button) findViewById(R.id.button2);
        Signup.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                MainActivity2();
            }
        });
    }
   public void MainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
   }

    }
