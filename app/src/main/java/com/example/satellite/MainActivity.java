package com.example.satellite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText userInput;
    double a;
    double p;
    final int r = 6378;
    final double k = 0.00995;
    Button calc;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.user_input);
        calc = findViewById(R.id.button);
        calc.setOnClickListener(this);
    }

    public void onClick(View v) {
        String index1 = userInput.getText().toString();
        a = Double.parseDouble(index1);
        double c1 = a + r;
        p = k * (Math.pow(c1, 1.5));
//        Algorithm to convert any button to hours, minutes and seconds.
        int day = (int) p / (24 * 3600);

        p = p % (24 * 3600);
        int hour = (int) p / 3600;

        p %= 3600;
        int minutes = (int) p / 60 ;

        p %= 60;
        double seconds =  p;


        result = String.valueOf(day) + " days " +  String.valueOf(hour) + " hours " + String.valueOf(minutes) + " minutes" + " and " + String.format("%.1f", seconds) + " seconds";
        ((TextView) findViewById(R.id.answer)).setText(result);
    }
}
