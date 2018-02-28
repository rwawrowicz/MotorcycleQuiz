package com.example.android.motorcylequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        RadioGroup question1RG = findViewById(R.id.radio_group_1);
        RadioButton answer1_3RB = findViewById(R.id.radio_button_1_3);
        if (answer1_3RB.isChecked()){
            points++;
        }
    }

    private void countPoints() {
        points = 0;
        question1();
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
        return message;
    }

    public void summary(View v){
        countPoints();
        String message = prepareMessage();
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }
}
