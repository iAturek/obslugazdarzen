package com.example.obslugazdarzen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private TextView tvResult;

    private Button btnPlus, btnMinus, btnEqual, btnClear;

    private double firstValue = 0;
    private String currentOperation = "";
    private boolean isNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        tvResult = findViewById(R.id.tvResult);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        btn1.setOnClickListener(v -> appendNumber("1"));
        btn2.setOnClickListener(v -> appendNumber("2"));
        btn3.setOnClickListener(v -> appendNumber("3"));
        btn4.setOnClickListener(v -> appendNumber("4"));
        btn5.setOnClickListener(v -> appendNumber("5"));
        btn6.setOnClickListener(v -> appendNumber("6"));
        btn7.setOnClickListener(v -> appendNumber("7"));
        btn8.setOnClickListener(v -> appendNumber("8"));
        btn9.setOnClickListener(v -> appendNumber("9"));
        btn0.setOnClickListener(v -> appendNumber("0"));

        btnPlus.setOnClickListener(v -> selectOperation("+"));
        btnMinus.setOnClickListener(v -> selectOperation("-"));
        btnEqual.setOnClickListener(v -> calculateResult());
        btnClear.setOnClickListener(v -> clearCalculator());
    }

    private void appendNumber(String number) {
        if (isNewNumber) {
            tvResult.setText(number);
            isNewNumber = false;
        } else {
            tvResult.setText(tvResult.getText().toString() + number);
        }
    }

    private void selectOperation(String operation) {
        firstValue = Double.parseDouble(tvResult.getText().toString());
        currentOperation = operation;
        isNewNumber = true;
    }

    private void calculateResult() {
        double secondValue = Double.parseDouble(tvResult.getText().toString());
        double finalResult = 0;

        if (currentOperation.equals("+")) {
            finalResult = firstValue + secondValue;
        } else if (currentOperation.equals("-")) {
            finalResult = firstValue - secondValue;
        } else {
            return;
        }

        tvResult.setText(String.valueOf(finalResult));
        isNewNumber = true;
    }

    private void clearCalculator() {
        tvResult.setText("0");
        firstValue = 0;
        currentOperation = "";
        isNewNumber = true;
    }
}