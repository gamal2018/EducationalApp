package com.example.android.educationalapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * This method is called when the Submit button is clicked.
     */
    public void showScore(View view) {
        String finalScore = "";
        EditText name = (EditText) findViewById(R.id.Name);
        String yourName = name.getText().toString();
        if (yourName.equalsIgnoreCase(""))

        {
            Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Your name", Toast.LENGTH_SHORT);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextSize(20);
            toast.show();
        } else {
            int score = calculateScore();
            if (score == 7) {
                finalScore = name.getText().toString() + "\n Excellent! you achieve the fullmark : " + score + "/7";

            } else {
                finalScore = name.getText().toString() + "\n score is : " + score + "/7";
            }


            Toast toast = Toast.makeText(getApplicationContext(), finalScore, Toast.LENGTH_SHORT);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextSize(30);
            toast.show();
        }
    }

    // Calculate the Score
    public int calculateScore() {
        int score = 0;
        // Fix user answer for Question 1
        EditText Q1_text = (EditText) findViewById(R.id.Q1_EditText);

        String Q1_answer = Q1_text.getText().toString();
        if (Q1_answer.equalsIgnoreCase("String")) {
            score++;
        }

        // Fix user answer for Question 2
        RadioButton Q2_radio = (RadioButton) findViewById(R.id.Q2_b_radio_button);
        if (Q2_radio.isChecked() == true) {
            score++;
        }
        // Fix user answer for Question 3
        CheckBox Q3_checkBox_a = (CheckBox) findViewById((R.id.Q3_a_checkbox));
        CheckBox Q3_checkBox_b = (CheckBox) findViewById((R.id.Q3_b_checkbox));
        CheckBox Q3_checkBox_c = (CheckBox) findViewById((R.id.Q3_c_checkbox));
        CheckBox Q3_checkBox_d = (CheckBox) findViewById((R.id.Q3_d_checkbox));

        if (Q3_checkBox_c.isChecked() && !Q3_checkBox_a.isChecked() && !Q3_checkBox_b.isChecked() && Q3_checkBox_d.isChecked()) {

            score++;

        }
        // Fix user answer for Question 4
        RadioButton Q4_radio = (RadioButton) findViewById(R.id.Q4_c_radio_button);
        if (Q4_radio.isChecked() == true) {
            score++;
        }
        // Fix user answer for Question 5
        RadioButton Q5_radio = (RadioButton) findViewById(R.id.Q5_a_radio_button);
        if (Q5_radio.isChecked() == true) {
            score++;
        }

        // Fix user answer for Question 6
        EditText Q6_text = (EditText) findViewById(R.id.Q6_EditText);
        String Q6_answer = Q6_text.getText().toString();
        if (Q6_answer.contains("true") && Q6_answer.contains("false")) {
            score++;
        }

        // Fix user answer for Question 7
        CheckBox Q7_checkBox_a = (CheckBox) findViewById((R.id.Q7_a_checkbox));
        CheckBox Q7_checkBox_b = (CheckBox) findViewById((R.id.Q7_b_checkbox));
        CheckBox Q7_checkBox_c = (CheckBox) findViewById((R.id.Q7_c_checkbox));
        CheckBox Q7_checkBox_d = (CheckBox) findViewById((R.id.Q7_d_checkbox));
        CheckBox Q7_checkBox_e = (CheckBox) findViewById((R.id.Q7_e_checkbox));
        CheckBox Q7_checkBox_f = (CheckBox) findViewById((R.id.Q7_f_checkbox));
        CheckBox Q7_checkBox_g = (CheckBox) findViewById((R.id.Q7_g_checkbox));
        CheckBox Q7_checkBox_h = (CheckBox) findViewById((R.id.Q7_h_checkbox));

        if (!Q7_checkBox_a.isChecked() && Q7_checkBox_b.isChecked() &&
                !Q7_checkBox_c.isChecked() && Q7_checkBox_d.isChecked() &&
                !Q7_checkBox_e.isChecked() && !Q7_checkBox_f.isChecked() &&
                Q7_checkBox_g.isChecked() && !Q7_checkBox_h.isChecked()) {

            score++;

        }

        return score;

    }


    public void resetScore(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
