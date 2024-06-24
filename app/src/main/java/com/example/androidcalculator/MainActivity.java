package com.example.androidcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Spinner spinner= binding.spinnerActions;
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.actions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        binding.buttonCalc.setOnClickListener(onClickListenerCalculate);
    }
    @SuppressLint("SetTextI18n")
    View.OnClickListener onClickListenerCalculate = V->{
        try {
            double number1 = Integer.parseInt(binding.editTextNumOne.getText().toString());
            double number2 = Integer.parseInt(binding.editTextNumTwo.getText().toString());
            String op = binding.spinnerActions.getSelectedItem().toString();
            double result = 0;

            switch (op) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1*number2;
                    break;
                case "/":
                    if(number2 == 0)
                        throw new Exception("division by zero");
                    result = number1 / number2;
                    break;
                case "^":
                    result = Math.pow(number1, number2);
                    break;
            }

            binding.textViewResult.setText(String.valueOf(result));
        }
        catch (Exception e){
            binding.textViewResult.setText("Error: " + e.getMessage());
        }
    } ;

}