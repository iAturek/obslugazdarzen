package com.example.obslugazdarzen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private Button btnPlus, btnMinus, btnEqual, btnClear;

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

        tvDisplay = findViewById(R.id.tvResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        View.OnClickListener symbolListener =
                v -> appendSymbol(((Button) v).getText().toString());

        int[] symbolIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnComma
        };

        for (int id : symbolIds) {
            findViewById(id).setOnClickListener(symbolListener);
        }

        btnPlus.setOnClickListener(v -> appendSymbol("+"));
        btnMinus.setOnClickListener(v -> appendSymbol("-"));
        btnEqual.setOnClickListener(v -> calculateResult());
        btnClear.setOnClickListener(v -> clearCalculator());
    }

    private void appendSymbol(String symbol) {
        tvDisplay.setText(tvDisplay.getText().toString() + symbol);
    }

    private void calculateResult() {
        String currentText = tvDisplay.getText().toString();
        String textToParse = currentText.replace(",", ".");
        double finalResult = 0;

        if (textToParse.contains("+")) {
            String[] parts = textToParse.split("\\+");
            if (parts.length == 2) {
                double firstValue = Double.parseDouble(parts[0]);
                double secondValue = Double.parseDouble(parts[1]);
                finalResult = firstValue + secondValue;
                tvDisplay.setText(String.valueOf(finalResult).replace(".", ","));
            }
        } else if (textToParse.contains("-")) {
            String[] parts = textToParse.split("-");
            if (parts.length == 2) {
                double firstValue = Double.parseDouble(parts[0]);
                double secondValue = Double.parseDouble(parts[1]);
                finalResult = firstValue - secondValue;
                tvDisplay.setText(String.valueOf(finalResult).replace(".", ","));
            }
        }
    }

    private void clearCalculator() {
        tvDisplay.setText("");
    }
}