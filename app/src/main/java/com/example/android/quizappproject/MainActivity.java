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
        answerQ3 = false;
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

        /* Display the score on a toast + question id if some answers are wrong */
        if (score == 5) {
            message = getString(R.string.perfectScore);
        } else {
            message = getString(R.string.yourScore) + score + "/5";
            if (!answerQ1) {
                message = message + getString(R.string.wrongAnswer1);
            }
            if (!answerQ2) {
                message = message + getString(R.string.wrongAnswer2);
            }
            if (!answerQ3) {
                message = message + getString(R.string.wrongAnswer3);
            }
            if (!answerQ4) {
                message = message + getString(R.string.wrongAnswer4);
            }
            if (!answerQ5) {
                message = message + getString(R.string.wrongAnswer5);
            }
        }

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}