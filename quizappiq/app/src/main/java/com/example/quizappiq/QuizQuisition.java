package com.example.quizappiq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;


public class QuizQuisition extends AppCompatActivity {
    int iqScore = 0;
    String message = "";
    private TextView result;

    TextView text1;
    private static final String FORMAT = "%02d:%02d:%02d";
    int seconds , minutes;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_quisition);
        result = (TextView) findViewById(R.id.score_text_view);

        text1=(TextView)findViewById(R.id.textView1);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
//بنحط عدد الدقايق فى 60 ونزود ثلاث اصفار
        new CountDownTimer(60000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                text1.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));


                int progress = (int) (millisUntilFinished/1000);

                progressBar.setProgress(progressBar.getMax()-progress);
            }


            public void onFinish() {
                Intent intent = new  Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        }.start();




        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1a:
                        Toast.makeText(QuizQuisition.this, "wrong", Toast.LENGTH_SHORT).show(); // do operations specific to this selection
                        break;
                    case R.id.radio1b:
                        Toast.makeText(QuizQuisition.this, "wrong", Toast.LENGTH_SHORT).show(); // do operations specific to this selection
                        break;
                    case R.id.radio1c:
                        Toast.makeText(QuizQuisition.this, "right", Toast.LENGTH_SHORT).show(); // do operations specific to this selection
                        iqScore += 20;
                        break;
                    case R.id.radio1d:
                        Toast.makeText(QuizQuisition.this, "wrong", Toast.LENGTH_SHORT).show(); // do operations specific to this selection
                        break;

                }
            }
        });

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio2a:
                        break;
                    case R.id.radio2b:
                        iqScore += 20;
                        break;
                    case R.id.radio2c:
                        break;
                    case R.id.radio2d:
                        break;
                }
            }
        });
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio3a:
                        iqScore += 20;
                        break;
                    case R.id.radio3b:
                        break;
                    case R.id.radio3c:
                        break;
                    case R.id.radio3d:
                        break;
                }
            }
        });
        RadioGroup rg4 = (RadioGroup) findViewById(R.id.radioGroup4);

        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio4a:
                        break;
                    case R.id.radio4b:
                        break;
                    case R.id.radio4c:
                        break;
                    case R.id.radio4d:
                        iqScore += 20;
                        break;
                }
            }
        });
        RadioGroup rg5 = (RadioGroup) findViewById(R.id.radioGroup5);

        rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio5a:
                        break;
                    case R.id.radio5b:
                        break;
                    case R.id.radio5c:
                        iqScore += 20;
                        break;
                    case R.id.radio5d:
                        break;


                }
            }
        });}

    public void submit(View view) {
        String message = "";

        if (iqScore <= 30) {
            message = getString(R.string.low);
            result.setTextColor(Color.rgb(200,0,0));

        } else if (iqScore == 50|| iqScore == 40) {
            message = getString(R.string.average);
            result.setTextColor(Color.rgb(0,200,200));

        } else if (iqScore == 70|| iqScore == 60) {
            message = getString(R.string.high);
            result.setTextColor(Color.rgb(0,200,0));

        } else if (iqScore == 100|| iqScore == 80) {
             message = getString(R.string.genius);
             result.setTextColor(Color.rgb(0,0,200)); }

        new AlertDialog.Builder(this).setMessage(message).show();

        message = iqScore + "\n\n" + message;
        result.setText(message);
    }
}
