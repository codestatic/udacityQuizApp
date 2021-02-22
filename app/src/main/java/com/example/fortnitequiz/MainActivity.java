package com.example.fortnitequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int pickAxeScore = 0;
    int rareSkinScore = 0;
    int landingZoneScore = 0;
    int checkBoxScore = 0;
    int grade = 0;

    /**
     * These methods check which radio button is clicked
     */
    public void rareSkinRadioClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_assault_trooper:
                if (checked) {
                    rareSkinScore = 1;
                } else {
                    rareSkinScore = 0;
                }
        }
    }

    public void landingZoneRadioClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.radio_salty_towers) {
            landingZoneScore = 1;
        } else {
            landingZoneScore = 0;
        }
    }

    public void pickAxeRadioClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_star_wand:
                if (checked) {
                    pickAxeScore = 1;
                } else {
                    pickAxeScore = 0;
                }
        }
    }

    /**
     * This method checks which checkBox is clicked
     */
    public void checkBoxClick(View view) {

        CheckBox lootCheckBox = (CheckBox) findViewById(R.id.loot_llama_checkbox);

        CheckBox pinataCheckBox = (CheckBox) findViewById(R.id.pinata_llama_checkbox);

        CheckBox llamaCheckBox = (CheckBox) findViewById(R.id.llama_llama_checkbox);

        if (lootCheckBox.isChecked() && pinataCheckBox.isChecked() && llamaCheckBox.isChecked()) {
            checkBoxScore = 0;
        } else if (lootCheckBox.isChecked() && pinataCheckBox.isChecked()) {
            checkBoxScore = 1;
        }

    }

    /**
     * This method is called when the submit button is clicked and displays the grade results in a toast
     */
    public void submitAnswers(View view) {

        grade = pickAxeScore + rareSkinScore + landingZoneScore + checkBoxScore;

        // checks and grades text inputs
        EditText colourText = findViewById(R.id.text_weapon_answer);
        String hasColour = colourText.getText().toString();
        if (hasColour.equals("Gold")) {
            grade = grade + 1;
        }

        EditText materialText = findViewById(R.id.text_material_answer);
        String hasMaterial = materialText.getText().toString();
        if (hasMaterial.equals("Metal")) {
            grade = grade + 1;
        }

        // calculates the final grade
        if (grade == 6) {
            Toast.makeText(this, "Congratulations you answered " + grade + " out of 6 right, you know your stuff!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,
                    MainActivity.class);

            startActivity(intent);
            return;
        } else if (grade >= 4) {
            Toast.makeText(this, "Awesome you answered " + grade + " out of 6 right!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,
                    MainActivity.class);

            startActivity(intent);
            return;
        } else {
            Toast.makeText(this, "Oh no! You got " + (6 - grade) + " wrong. Try again!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,
                    MainActivity.class);

            startActivity(intent);

        }

    }

}


