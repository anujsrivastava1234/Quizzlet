package com.example.quizzlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity<Stirng> extends AppCompatActivity {

    private  TextView questions;
    private TextView question;

    QuestionBank questionBank=new QuestionBank();


    private TextView option1;
    private TextView option2;
    private TextView option3;
    private TextView option4;

    private Timer quizTimer;

    private int TotalTimerInMins=1;

    private int seconds=0;

    private  List<QuestionList> questionListList ;

    private String selectedOptionByUser="";

    private int currentQuestionPosition=0;
    private TextView nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backbtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextbtn = findViewById(R.id.nextBtn);

//        String string =getString(R.xml.next_btn);


         String getSelectedTopic = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopic);

        questionListList=questionBank.getQuestion(getSelectedTopic);
        Log.e("QuizActivity", "onCreate: " + getSelectedTopic);
        Toast.makeText(this, getSelectedTopic, Toast.LENGTH_SHORT).show();

        startTimer(timer);

        questions.setText((currentQuestionPosition) + "/" + questionListList.size());
        questions.setText(questionListList.get(0).getQuestion());
        option1.setText((CharSequence) questionListList.get(0).getOption1());
        option2.setText(questionListList.get(0).getOption2());
        option3.setText(questionListList.get(0).getOption3());
        option4.setText(questionListList.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser=option1.toString();

                    option1.setBackgroundColor(R.drawable.round_back_red10);

                    option1.setTextColor(Color.WHITE);

                    try {
                        revealAnswer();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    questionListList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }

            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser=option2.toString();

                    option2.setBackgroundColor(R.drawable.round_back_red10);

                    option2.setTextColor(Color.WHITE);

                    try {
                        revealAnswer();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    questionListList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser=option3.toString();

                    option3.setBackgroundColor(R.drawable.round_back_red10);

                    option3.setTextColor(Color.WHITE);

                    try {
                        revealAnswer();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    questionListList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser=option4.toString();

                    option4.setBackgroundColor(R.drawable.round_back_red10);

                    option4.setTextColor(Color.WHITE);

                    try {
                        revealAnswer();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    questionListList.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }else{
                    changeNextQuestion();
                }
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quizTimer.purge();
                quizTimer.cancel();
                Intent intent=new Intent(QuizActivity.this,QuizResult.class);
                startActivity(intent);
//                startActivity(new Intent(QuizActivity.this,landing_page.class));
                finish();
            }
        });


    }

    private void changeNextQuestion(){

        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionListList.size()){
            nextbtn.setText("Submit Quiz");
        }
        if((currentQuestionPosition+1)<questionListList.size()){
            selectedOptionByUser="";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke10);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke10);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke10);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke10);
            option4.setTextColor(Color.parseColor("#1F6BB8"));


            question.setText(currentQuestionPosition + "/" + questionListList.size());
            questions.setText(questionListList.get(currentQuestionPosition).getQuestion());
            option1.setText(questionListList.get(currentQuestionPosition).getOption1());
            option2.setText(questionListList.get(currentQuestionPosition).getOption2());
            option3.setText(questionListList.get(currentQuestionPosition).getOption3());
            option4.setText(questionListList.get(currentQuestionPosition).getOption4());
        }else{
            Intent intent=new Intent(QuizActivity.this,QuizResult.class);
            startActivity(intent);
            intent.putExtra("Correct",getCorrectAnswer());
            intent.putExtra("Incorrect",getInCorrectAnswer());
//            startActivity(new Intent(QuizActivity.this,landing_page.class));
            finish();
        }
    }

    private void startTimer(TextView timerTextView){
        quizTimer=new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds==0){
                    TotalTimerInMins--;
                    seconds=50;
                }else if(seconds==0 && TotalTimerInMins==0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Time over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this,QuizResult.class);
                    intent.putExtra("correct",getCorrectAnswer());
                    intent.putExtra("incorrect",getInCorrectAnswer());
                    startActivity(intent);

                    finish();
                }
                else{
                    seconds--;
                    finish();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes= String.valueOf(TotalTimerInMins);
                        String finalSeconds= String.valueOf(seconds);

                        if(finalMinutes.length()==1){
                            finalMinutes="0"+finalMinutes;
                        }


                        if(finalSeconds.length()==1){
                            finalSeconds="0"+finalSeconds;
                        }
                        timerTextView.setText(finalMinutes + ":" + finalSeconds);
                    }
                });
            }
        },1000,1000);
    }

    private int getCorrectAnswer(){
        int correctAnswer=0;

        for(int i=0;i<questionListList.size();i++){
            final String getUserSelectedAnswer=questionListList.get(i).getUserSelectedAnswer();
            final String getAnswer=questionListList.get(i).getAnswer();

            if (getUserSelectedAnswer.equals((getAnswer))) {

                correctAnswer++;
            }
        }

        return correctAnswer;
    }

    private int getInCorrectAnswer(){
        int correctAnswer=0;

        for(int i=0;i<questionListList.size();i++){
            final String getUserSelectedAnswer=questionListList.get(i).getUserSelectedAnswer();
            final String getAnswer=questionListList.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals((getAnswer))) {

                correctAnswer++;
            }
        }

        return correctAnswer;
    }

    public void onBackPressed(){

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this,landing_page.class));
        finish();
    }

    private void revealAnswer() throws UnsupportedEncodingException {

        final String getAnswer=questionListList.get(currentQuestionPosition).getAnswer();
        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);
        }else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);
        }else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);
        }
    }
}