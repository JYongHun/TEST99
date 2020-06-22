package com.jang.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtQuiz;
    ProgressBar quizBar;
    TextView txt;
    Button btnTure;
    Button btnFalse;

    QuizModel[] questionArray = new QuizModel[]{
            new QuizModel(R.string.q1, true),
            new QuizModel(R.string.q2, false),
            new QuizModel(R.string.q3, true),
            new QuizModel(R.string.q4, false),
            new QuizModel(R.string.q5, true),
            new QuizModel(R.string.q6, false),
            new QuizModel(R.string.q7, true),
            new QuizModel(R.string.q8, false),
            new QuizModel(R.string.q9, false),
            new QuizModel(R.string.q10, true)
    };

    int questionIndex = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        Log.i("GGG",""+score);
        if(savedInstanceState != null){
            score = savedInstanceState.getInt("SCORE");
            questionIndex = savedInstanceState.getInt("INDEX");
        }else {
            score = 0;
            questionIndex = 0;
        }

        txtQuiz = (TextView)findViewById(R.id.txtQuiz);
        quizBar = (ProgressBar)findViewById(R.id.quizBar);
        txt = (TextView)findViewById(R.id.txt);
        btnTure = (Button)findViewById(R.id.btnTure);
        btnFalse = (Button)findViewById(R.id.btnFalse);

        btnTure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateUserAnswer(true);
            }
        });


        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateUserAnswer(false);
            }
        });


        QuizModel q = questionArray[questionIndex];
        txtQuiz.setText(q.getmQuestion());
        txt.setText("점수는 : "+score);
    }

    void evaluateUserAnswer(boolean userAnser) {

        QuizModel q = questionArray[questionIndex];
        boolean answer = q.ismAnswer();

        if (questionIndex != 9) {
            if (userAnser == answer) {
                questionIndex = questionIndex + 1;
                score = score + 1;
                txt.setText("점수는 : " + score);
                q = questionArray[questionIndex];
                txtQuiz.setText(q.getmQuestion());
                Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_SHORT).show();

            } else {
                questionIndex = questionIndex + 1;
                q = questionArray[questionIndex];
                txtQuiz.setText(q.getmQuestion());
                Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_SHORT).show();
            }
        } else {


            questionIndex = 0;
            if (userAnser == answer) {
                questionIndex = questionIndex + 1;
                score = score + 1;
                txt.setText("점수는 : " + score);
                q = questionArray[questionIndex];
                txtQuiz.setText(q.getmQuestion());
                Toast.makeText(getApplicationContext(), "정답", Toast.LENGTH_SHORT).show();

            } else {

                questionIndex = questionIndex + 1;
                q = questionArray[questionIndex];
                txtQuiz.setText(q.getmQuestion());
                Toast.makeText(getApplicationContext(), "오답", Toast.LENGTH_SHORT).show();
            }

            AlertDialog.Builder quizAlert = new AlertDialog.Builder(MainActivity.this);
            quizAlert.setTitle("퀴즈앱종료");
            quizAlert.setMessage("당신의 점수는 : " +score);
            quizAlert.setPositiveButton("앱 종료ㅗ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish(); // 앱종료
                }
            });

            quizAlert.setNegativeButton("취소",null);
            quizAlert.setNeutralButton("d스벌~",null);
            quizAlert.show();
        }

        quizBar.incrementProgressBy(10);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // 스코어라는 키로 score 멤버변수에 저장된 현재 스코어를 저장
        outState.putInt("SCORE",score);
        outState.putInt("INDEX",questionIndex);
        Log.i("test","GGG");
    }
}
