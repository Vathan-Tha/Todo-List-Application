package com.vathana.temperatureconvertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputTempText;
    private TextView convertedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Convert to views
        Button convertButton = findViewById(R.id.convertButton);
        inputTempText = findViewById(R.id.inputTempEditText);
        convertedText = findViewById(R.id.convertedTempTextView);

        // Handle button event listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fstr = convertToFh(inputTempText.getText().toString());
                convertedText.setText(fstr);
            }
        });

        // Check if there's a saved instance state
        if (savedInstanceState != null) {
            String savedConvertedText = savedInstanceState.getString("convertedText");
            convertedText.setText(savedConvertedText);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the convertedText value to restore later
        outState.putString("convertedText", convertedText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore the convertedText value
        String savedConvertedText = savedInstanceState.getString("convertedText");
        convertedText.setText(savedConvertedText);
    }

    private String convertToFh(String pCelcius) {
        try {
            double c = Double.parseDouble(pCelcius);
            double f = c * (9.0 / 5.0) * 32.0;
            return String.format("%3.2f", f);
        } catch (NumberFormatException nfe) {
            return "Error";
        }
    }
}
