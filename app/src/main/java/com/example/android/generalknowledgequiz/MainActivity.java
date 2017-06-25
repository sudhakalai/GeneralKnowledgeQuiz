package com.example.android.generalknowledgequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    /*Declaring global variable*/
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Submit quiz method*/

    public void submitQuiz(View view) {
        //Getting the person's name
        EditText personName = (EditText) findViewById(R.id.personName);
        String name = personName.getText().toString();

        //Question 1
        RadioGroup group1 = (RadioGroup) findViewById(R.id.ans1);
        if (group1.getCheckedRadioButtonId() == R.id.ans1D)
            score++;




        //Question 2
        RadioGroup group2 = (RadioGroup) findViewById(R.id.ans2);
        if (group2.getCheckedRadioButtonId() == R.id.ans2C)
            score++;

        //Question 3
        RadioGroup group3 = (RadioGroup) findViewById(R.id.ans3);
        if (group3.getCheckedRadioButtonId() == R.id.ans3C)
            score++;

        //Question 4
        EditText ans4 = (EditText) findViewById(R.id.ans4);
        String answer4 = ans4.getText().toString();
        if (answer4.equalsIgnoreCase("paris"))
            score++;

        //Question 5
        CheckBox ans5A = (CheckBox) findViewById(R.id.ans5A);
        boolean isCheckedAns5A = ans5A.isChecked();
        CheckBox ans5B = (CheckBox) findViewById(R.id.ans5B);
        boolean isCheckedAns5B = ans5B.isChecked();
        CheckBox ans5C = (CheckBox) findViewById(R.id.ans5C);
        boolean isCheckedAns5C = ans5C.isChecked();
        CheckBox ans5D = (CheckBox) findViewById(R.id.ans5D);
        boolean isCheckedAns5D = ans5D.isChecked();
        if (isCheckedAns5A && isCheckedAns5B && !isCheckedAns5C && isCheckedAns5D)
            score += 1;

        //Display final score
        finalScore(name);

        //reset variables
        personName.setText("");
        group1.clearCheck();
        group2.clearCheck();
        group3.clearCheck();
        ans4.setText("");
        ans5A.setChecked(false);
        ans5B.setChecked(false);
        ans5C.setChecked(false);
        ans5D.setChecked(false);
        score = 0;

    }


    //display score
    public void finalScore(String s) {

        Toast.makeText(this, s + ": Your score is " + score, Toast.LENGTH_SHORT).show();

        if (score == 5)
            Toast.makeText(this,  "Good job!!!" , Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,  "Better luck next time!!!" , Toast.LENGTH_SHORT).show();


    }
}
