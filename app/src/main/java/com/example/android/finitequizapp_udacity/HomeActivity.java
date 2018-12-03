package com.example.android.finitequizapp_udacity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    final int Question1Answer = R.id.question1_radio1_r2;
    final String Question2Answer = "2008";
    final int Question3Answer = R.id.question3_radio2_r1;
    final int Question4Answer = R.id.question4_radio3_r1;
    final String Question6Answer = "Tim Robbins";
    final String Qeustion7Answer = "Tom Cruise";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
    }

    // Check answer for radio button
    private boolean checkQuestion1() {
        RadioGroup radioGroup = (RadioGroup) findViewById( R.id.question1_radio1 );

        if (radioGroup.getCheckedRadioButtonId() == Question1Answer) {
            return true;
        }

        return false;
    }

    // Check answer for edit text box
    private boolean checkQuestion2() {
        EditText editText = (EditText) findViewById( R.id.question2_edit_text );

        return editText.getText().toString().equalsIgnoreCase( Question2Answer );
    }

    private boolean checkQuestion3() {
        RadioGroup radioGroup = (RadioGroup) findViewById( R.id.question3_radio2 );

        if (radioGroup.getCheckedRadioButtonId() == Question3Answer) {
            return true;
        }

        return false;
    }

    // Check answer for radio button
    private boolean checkQuestion4() {
        RadioGroup radioGroup = (RadioGroup) findViewById( R.id.question4_radio3 );

        if (radioGroup.getCheckedRadioButtonId() == Question4Answer) {
            return true;
        }

        return false;
    }

    // Check answer for checkbox
    private boolean checkQuestion5() {
        CheckBox c1 = (CheckBox) findViewById( R.id.question5_checkbox1_c1 );
        CheckBox c2 = (CheckBox) findViewById( R.id.question5_checkbox1_c2 );
        CheckBox c3 = (CheckBox) findViewById( R.id.question5_checkbox1_c3 );

        if (c1.isChecked() && c2.isChecked() && !c3.isChecked()) {
            return true;
        }

        return false;
    }


    // Check answer for radio button
    private boolean checkQuestion6() {
        EditText editText = (EditText) findViewById( R.id.question_6_edit_text );

        return editText.getText().toString().equalsIgnoreCase( Question6Answer );
    }

    // Check answer for edit text box
    private boolean checkQuestion7() {
        EditText editText = (EditText) findViewById( R.id.question_7_edit_text );

        return editText.getText().toString().equalsIgnoreCase( Qeustion7Answer );
    }

    // Check answer for checkbox
    private boolean checkQuestion8() {
        CheckBox c1 = (CheckBox) findViewById( R.id.question8_checkbox2_c1 );
        CheckBox c2 = (CheckBox) findViewById( R.id.question8_checkbox2_c2 );
        CheckBox c3 = (CheckBox) findViewById( R.id.question8_checkbox2_c3 );

        if (c1.isChecked() && !c2.isChecked() && c3.isChecked()) {
            return true;
        }

        return false;
    }

    // Check the number of correct answers
    public void checkQuiz(View view) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 1" );
        }

        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 2" );
        }

        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 3" );
        }

        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 4" );
        }

        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 5" );
        }

        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 6" );
        }

        if (checkQuestion7()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 7" );
        }

        if (checkQuestion8()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 8" );
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : incorrectAnswersList) {
            stringBuilder.append( s );
            stringBuilder.append( "\n" );
        }

        Context context = getApplicationContext();
        CharSequence text = "Congratulations! " + numberOfQuestionsCorrect + "/8 answers right.\n\nPlease! kindly Recheck.:\n" + stringBuilder.toString();

        // For Toast Message
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( context, text, duration );

        // Changes the button image after clicking
        view.setBackgroundResource( R.drawable.custom_background );

        // Show Toast Message
        toast.show();
    }
}
