package com.example.android.earthquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    RadioGroup Radio_Group1;
    RadioButton radio_Button1;
    RadioGroup Radio_Group2;
    RadioButton radio_Button2;
    RadioGroup Radio_Group3;
    RadioButton radio_Button3;
    CheckBox check1answer4;
    CheckBox check2answer4;
    CheckBox check3answer4;
    CheckBox check4answer4;
    CheckBox check1answer8;
    CheckBox check2answer8;
    CheckBox check3answer8;
    CheckBox check4answer8;
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
        Radio_Group1 = findViewById(R.id.firstRadio);
        int firstradioID = Radio_Group1.getCheckedRadioButtonId();
        if (firstradioID == -1)
            return -1;
        radio_Button1 = findViewById(R.id.answer1);
        int radiobuttonID1 = radio_Button1.getId();
        if (radiobuttonID1 == firstradioID)
            TotalScore++;


        EditText answerTwo = findViewById(R.id.answer2);
        String answerSt1 = answerTwo.getText().toString();
        if ((answerSt1.equals("Nile")) || (answerSt1.equals("Nile River")) || (answerSt1.equals("The Nile River")))
            TotalScore++;
        else if(answerSt1.equals(""))
            return -1;


        Radio_Group2 = findViewById(R.id.thirdRadio);
        int thirdradioID = Radio_Group2.getCheckedRadioButtonId();
        if (thirdradioID == -1)
            return -1;
        radio_Button2 = findViewById(R.id.answer3);
        int radiobuttonID2 = radio_Button2.getId();
        if (radiobuttonID2 == thirdradioID)
            TotalScore++;

        check1answer4=findViewById(R.id.answer4Check1);
        check2answer4=findViewById(R.id.answer4Check2);
        check3answer4=findViewById(R.id.answer4Check3);
        check4answer4=findViewById(R.id.answer4Check4);
        if (check1answer4.isChecked() && check2answer4.isChecked() && !check3answer4.isChecked() && !check4answer4.isChecked())
            TotalScore++;
        if (!check1answer4.isChecked() && !check2answer4.isChecked() && !check3answer4.isChecked() && !check4answer4.isChecked())
            return -1;

        if(numberOfContinents==7)
            TotalScore++;

        EditText answerThree = findViewById(R.id.answer6);
        String answerSt6 = answerThree.getText().toString();
        if ((answerSt6.equals("Asia")) || (answerSt6.equals("The Asia")))
            TotalScore++;
        else if(answerSt6.equals(""))
            return -1;

        Radio_Group3 = findViewById(R.id.seventhRadio);
        int seventhradioID = Radio_Group3.getCheckedRadioButtonId();
        if (seventhradioID == -1)
            return -1;
        radio_Button3 = findViewById(R.id.answer7);
        int radiobuttonID3 = radio_Button3.getId();
        if (radiobuttonID3 == seventhradioID)
            TotalScore++;

        check1answer8=findViewById(R.id.answer8Check1);
        check2answer8=findViewById(R.id.answer8Check2);
        check3answer8=findViewById(R.id.answer8Check3);
        check4answer8=findViewById(R.id.answer8Check4);
        if (check1answer8.isChecked() && !check2answer8.isChecked() && !check3answer8.isChecked() && check4answer8.isChecked())
            TotalScore++;
        if (!check1answer8.isChecked() && !check2answer8.isChecked() && !check3answer8.isChecked() && !check4answer8.isChecked())
            return -1;

        radio_Button1.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        answerTwo.setText("Nile");
        answerTwo.setTextColor(getResources().getColor(R.color.CorrectAnswer));
        radio_Button2.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        check1answer4.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        check2answer4.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        numCont = findViewById(R.id.answer5);
        numCont.setText(String.valueOf(7));
        answerThree.setText("Asia");
        answerThree.setTextColor(getResources().getColor(R.color.CorrectAnswer));
        radio_Button3.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        check1answer8.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        check4answer8.setBackgroundColor(getResources().getColor(R.color.CorrectAnswer));
        return TotalScore;


    }

    public void submitScore(View view) {

        int x = calcScore();
        if (x == -1) {
            Toast.makeText(getApplicationContext(), "Finish all questions", Toast.LENGTH_SHORT).show();
            return;
        }
        if (x == 8) {
            Toast.makeText(getApplicationContext(), getName() + " Congrats You have " + x + " questions correct out of 8", Toast.LENGTH_LONG).show();
            Button submit=findViewById(R.id.buttonSubmit);
            submit.setEnabled(false);
        } else {
            Toast.makeText(getApplicationContext(), getName() + " You have " + x + " questions correct out of 8", Toast.LENGTH_LONG).show();
            firstHeader = findViewById(R.id.firstHeader);
            firstHeader.setText("Have you considered life on Mars?");
            firstHeader.setBackgroundResource(R.color.firstHeaderColor);
            mars = findViewById(R.id.intro);
            mars.setImageResource(R.drawable.mars);
            ScrollView test = findViewById(R.id.test);
            test.setBackgroundResource(R.color.firstHeaderColor);
            Button submit=findViewById(R.id.buttonSubmit);
            submit.setEnabled(false);
        }
    }
public void Reset(View view){
    EditText nameField = findViewById(R.id.name);
    nameField.setText("");
    counter=0;
    hintButton = findViewById(R.id.hint0);
    hintButton.setText("Hint-2");
    Radio_Group1 = findViewById(R.id.firstRadio);
    Radio_Group1.clearCheck();

    EditText answerTwo = findViewById(R.id.answer2);
    answerTwo.setText("");

    Radio_Group2 = findViewById(R.id.thirdRadio);
    Radio_Group2.clearCheck();

    check1answer4=findViewById(R.id.answer4Check1);
    check2answer4=findViewById(R.id.answer4Check2);
    check3answer4=findViewById(R.id.answer4Check3);
    check4answer4=findViewById(R.id.answer4Check4);
    check1answer4.setChecked(false);
    check2answer4.setChecked(false);
    check3answer4.setChecked(false);
    check4answer4.setChecked(false);

    numberOfContinents=0;
    numCont = findViewById(R.id.answer5);
    numCont.setText(String.valueOf(numberOfContinents));

    EditText answerThree = findViewById(R.id.answer6);
    answerThree.setText("");

    Radio_Group3 = findViewById(R.id.seventhRadio);
    Radio_Group3.clearCheck();

    check1answer8=findViewById(R.id.answer8Check1);
    check2answer8=findViewById(R.id.answer8Check2);
    check3answer8=findViewById(R.id.answer8Check3);
    check4answer8=findViewById(R.id.answer8Check4);
    check1answer8.setChecked(false);
    check2answer8.setChecked(false);
    check3answer8.setChecked(false);
    check4answer8.setChecked(false);

    radio_Button1.setBackgroundColor(Color.TRANSPARENT);
    answerTwo.setTextColor(Color.BLACK);
    radio_Button2.setBackgroundColor(Color.TRANSPARENT);
    check1answer4.setBackgroundColor(Color.TRANSPARENT);
    check2answer4.setBackgroundColor(Color.TRANSPARENT);
    answerThree.setTextColor(Color.BLACK);
    radio_Button3.setBackgroundColor(Color.TRANSPARENT);
    check1answer8.setBackgroundColor(Color.TRANSPARENT);
    check4answer8.setBackgroundColor(Color.TRANSPARENT);


    firstHeader = findViewById(R.id.firstHeader);
    firstHeader.setText("Do You Really Know Your Planet");
    firstHeader.setBackgroundResource(R.color.black);
    mars = findViewById(R.id.intro);
    mars.setImageResource(R.drawable.earth);
    ScrollView test = findViewById(R.id.test);
    test.setBackgroundResource(R.color.earthblue);
    Button submit=findViewById(R.id.buttonSubmit);
    submit.setEnabled(true);

}

    public void increment(View view) {
        numberOfContinents = numberOfContinents + 1;
        numCont = findViewById(R.id.answer5);
        numCont.setText(String.valueOf(numberOfContinents));

    }

    public void decrement(View view) {
        if (numberOfContinents == 0) {
            numberOfContinents = 0;
        } else
            numberOfContinents = numberOfContinents - 1;
        numCont = findViewById(R.id.answer5);
        numCont.setText(String.valueOf(numberOfContinents));
    }
}