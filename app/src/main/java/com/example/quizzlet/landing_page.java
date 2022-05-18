package com.example.quizzlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class landing_page extends AppCompatActivity {
    private String selectedTopicName = "";
    ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ImageView java=findViewById(R.id.java);
        ImageView php=findViewById(R.id.php);
        ImageView rust=findViewById(R.id.rust);
        ImageView cpp=findViewById(R.id.cpp);

        final Button button=findViewById(R.id.button);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName="java";

                java.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                cpp.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                rust.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                php.setBackgroundResource(R.drawable.round_back_white_stroke10);


            }
        });

        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName="php";
//                php.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                java.setBackgroundResource(R.drawable.round_back_white_stroke10);


            }
        });

        rust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName="rust";
//                rust.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                php.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                java.setBackgroundResource(R.drawable.round_back_white_stroke10);

            }
        });

        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicName="cpp";
//                cpp.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                rust.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                php.setBackgroundResource(R.drawable.round_back_white_stroke10);
//                java.setBackgroundResource(R.drawable.round_back_white_stroke10);



            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTopicName.isEmpty()){
                    Toast.makeText(landing_page.this, "Please Select a Topic", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(landing_page.this,QuizActivity.class);
                    intent.putExtra("selectedTopic",selectedTopicName);
                    startActivity(intent);
                }
            }
        });


    }
}