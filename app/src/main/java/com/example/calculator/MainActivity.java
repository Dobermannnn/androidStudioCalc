package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner=(Spinner)findViewById(R.id.spinner);

        int num1=Integer.parseInt(findViewById(R.id.num1).toString());
        int num2=Integer.parseInt(findViewById(R.id.num2).toString());
        Button getRes=findViewById(R.id.btnCalc);

        TextView resText=findViewById(R.id.txtRes);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.spinnerArr,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        getRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int result = 0;
                    switch (sign) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                throw new ArithmeticException("Division by zero");
                            }
                            result = num1 / num2;
                            break;
                        case "X":
                            result = num1 * num2;
                            break;
                        case "^":
                            result = (int) Math.pow(num1, num2);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid operation");
                    }
                    resText.setText(result);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }


            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0:
                        sign="+";
                    case 1:
                        sign="-";
                    case 2:
                        sign="/";
                    case 3:
                        sign="X";
                    case 4:
                        sign="^";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

}