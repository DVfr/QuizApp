package com.example.android.quizappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean answerQ1 = false;
    boolean answerQ2 = false;
    boolean answerQ3 = false;
    boolean answerQ4 = false;
    boolean answerQ5 = false;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Check if a CheckBox has been selected */
    public boolean getCheckBoxState(int checkBoxId) {
        CheckBox c = (CheckBox) findViewById(checkBoxId);
        return c.isChecked();
    }

    /* Check if the right answer (Button3) has been selected for Question 1*/
    public void isQ1OK() {

        answerQ1 = false;
        RadioButton checkFirstQuestion = (RadioButton) findViewById(R.id.question1Button3);
        boolean checkedQ1 = checkFirstQuestion.isChecked();
        if (checkedQ1) {
            answerQ1 = true;
            score = score + 1;
        }
    }

    /* Check if the right answer (Tony Banks, Phil Collins and Mike Rutherford) has been selected for Question 2 */
    public void isQ2OK() {
        answerQ2 = false;

        /* use the getCheckBoxState method to check each checkbox  */
        Boolean checkTB = getCheckBoxState(R.id.TonyBanks);
        Boolean checkEJ = getCheckBoxState(R.id.EltonJohn);
        Boolean checkPC = getCheckBoxState(R.id.PhilCollins);
        Boolean checkMR = getCheckBoxState(R.id.MikeRutherford);
        Boolean checkGM = getCheckBoxState(R.id.GeorgeMichael);

        /* check if the right combination has been chosen */
        if (checkTB && !checkEJ && checkPC && checkMR && !checkGM) {
            answerQ2 = true;
            score = score + 1;
        }
    }

    /* Check if the right answer (Countdown) has been selected for Question 3*/
    public void isQ3OK() {
        String rightAnswer = "countdown";
        String text = ((TextView) findViewById(R.id.editTextQuestion3)).getText().toString().toLowerCase();

        if (text.equals(rightAnswer)) {
            answerQ3 = true;
            score = score + 1;
        }
    }

    /* Check if the right answer (Button2) has been selected for Question 4*/
    public void isQ4OK() {
        answerQ4 = false;
        RadioButton checkFirstQuestion = (RadioButton) findViewById(R.id.question4Button2);
        boolean checkedQ4 = checkFirstQuestion.isChecked();
        if (checkedQ4) {
            answerQ4 = true;
            score = score + 1;
        }
    }

    /* Check if the right answer (Button3) has been selected for Question 5*/
    public void isQ5OK() {
        answerQ5 = false;
        RadioButton checkFirstQuestion = (RadioButton) findViewById(R.id.question5Button3);
        boolean checkedQ5 = checkFirstQuestion.isChecked();
        if (checkedQ5) {
            answerQ5 = true;
            score = score + 1;
        }
    }

    /* submit the answers when the button is clicked*/
    public void submitAnswers(View view) {
        String message;
        score = 0;

        isQ1OK();
        isQ2OK();
        isQ3OK();
        isQ4OK();
        isQ5OK();

        /* Display the score on a toast */
        if (score == 5) {
            message = "PERFECT !!";
        } else {
            message = "Score = " + score + "\nQuestion 1 est: " + answerQ1;
            message = message + "\nQuestion 2 est: " + answerQ2;
            message = message + "\nQuestion 3 est: " + answerQ3;
            message = message + "\nQuestion 4 est: " + answerQ4;
            message = message + "\nQuestion 5 est: " + answerQ5;
        }

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}