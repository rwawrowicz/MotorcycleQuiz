package com.example.android.motorcylequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        points = 0;
    }

    private String getName() {
        EditText nameInput = findViewById(R.id.name_edit_text);
        return nameInput.getText().toString();
    }

    private void question1() {
        EditText answer1 = findViewById(R.id.answer_1);
        String answer = answer1.getText().toString();
        if (answer.equalsIgnoreCase("indian")){
            points++;
        }
    }

    private void question2() {
        RadioButton answer2_2RB = findViewById(R.id.radio_button_2_2);
        if (answer2_2RB.isChecked()){
            points++;
        }
    }

    private void question3() {
        RadioButton answer3_1RB = findViewById(R.id.radio_button_3_1);
        if (answer3_1RB.isChecked()){
            points++;
        }
    }

    private void question4() {
        RadioButton answer4_3RB = findViewById(R.id.radio_button_4_3);
        if (answer4_3RB.isChecked()){
            points++;
        }
    }

    private void question5() {
        CheckBox answer5_1CB = findViewById(R.id.checkbox_5_1);
        CheckBox answer5_2CB = findViewById(R.id.checkbox_5_2);
        CheckBox answer5_3CB = findViewById(R.id.checkbox_5_3);
        CheckBox answer5_4CB = findViewById(R.id.checkbox_5_4);
        CheckBox answer5_5CB = findViewById(R.id.checkbox_5_5);
        if (!answer5_1CB.isChecked()
                && answer5_2CB.isChecked()
                && answer5_3CB.isChecked()
                && !answer5_4CB.isChecked()
                && !answer5_5CB.isChecked()){
            points++;
        }

    }

    private void countPoints() {
        points = 0;
        question1();
        question2();
        question3();
        question4();
        question5();
    }

    private String prepareMessage(){
        String name = getName();
        String message;
        if (name.matches("")){
            message = "You ";
        } else {
            message = name + ", you ";
        }
        message += "scored " + points + " points";
        if (points < 3){
            message += "\nYour knowledge is... well, let's say that you should still learn someting ;)";
        }else if ((points >= 3) && (points < 5)) {
            message += "\nYour knowledge is quite impressive";
        } else {
            message += "\nCongratulation! All answers are correct! You are an expert!";
        }

        return message;
    }

    public void summary(View v){
        countPoints();
        String message = prepareMessage();
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }
}
