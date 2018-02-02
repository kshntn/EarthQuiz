package com.example.android.earthquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    ImageView mars;
    TextView firstHeader;
    int counter = 0;
    Button hintButton;
    int numberOfContinents = 0;
    TextView numCont;
    int TotalScore;
    RadioGroup Radio_Group;
    RadioButton radio_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Hint(View view) {
        hintButton = findViewById(R.id.hint0);
        if (counter == 0) {
            Toast.makeText(getApplicationContext(), "Flows through Africa", Toast.LENGTH_SHORT).show();
            hintButton.setText("Hint-1");
        } else if (counter == 1) {
            Toast.makeText(getApplicationContext(), "Starts with N", Toast.LENGTH_SHORT).show();
            hintButton.setText("Hint-0");
        } else {
            Toast.makeText(getApplicationContext(), "No more hints", Toast.LENGTH_SHORT).show();
        }
        counter++;
    }

    private String getName() {
        EditText nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();
        return name;
    }

    private int calcScore() {
        Radio_Group = findViewById(R.id.firstRadio);
        int firstradioID = Radio_Group.getCheckedRadioButtonId();
        if (firstradioID == -1)
            return -1;
        radio_Button = findViewById(R.id.answer1);
        int radiobuttonID = radio_Button.getId();
        if (radiobuttonID == firstradioID)
            TotalScore++;
        radio_Button.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));

        EditText answerTwo = findViewById(R.id.answer2);
        String answer = answerTwo.getText().toString();
        if (((answer == "Nile") || (answer == "Nile River") || (answer == "The Nile River")))
            TotalScore++;

        answerTwo.setText("Nile River");
        return TotalScore;
    }

    public void submitScore(View view) {

        int x = calcScore();
        if (x == -1) {
            Toast.makeText(getApplicationContext(), "Finish all questions", Toast.LENGTH_SHORT).show();
            return;
        }
        if (x == 2) {
            Toast.makeText(getApplicationContext(), getName() + "Congrats", Toast.LENGTH_SHORT).show();
        } else {
            firstHeader = findViewById(R.id.firstHeader);
            firstHeader.setText("Have you considered life on Mars?");
            firstHeader.setBackgroundResource(R.color.firstHeaderColor);
            mars = findViewById(R.id.intro);
            mars.setImageResource(R.drawable.mars);
            ScrollView test = findViewById(R.id.test);
            test.setBackgroundResource(R.color.firstHeaderColor);
        }
    }

    public void increment(View view) {
        numberOfContinents = numberOfContinents + 1;
        numCont = findViewById(R.id.questionNine);
        numCont.setText(String.valueOf(numberOfContinents));

    }

    public void decrement(View view) {
        if (numberOfContinents == 0) {
            numberOfContinents = 0;
        } else
            numberOfContinents = numberOfContinents - 1;
        numCont = findViewById(R.id.questionNine);
        numCont.setText(String.valueOf(numberOfContinents));
    }
}
