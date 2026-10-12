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
        tvDisplay = findViewById(R.id.tvResult);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        btn1.setOnClickListener(v -> appendSymbol("1"));
        btn2.setOnClickListener(v -> appendSymbol("2"));
        btn3.setOnClickListener(v -> appendSymbol("3"));
        btn4.setOnClickListener(v -> appendSymbol("4"));
        btn5.setOnClickListener(v -> appendSymbol("5"));
        btn6.setOnClickListener(v -> appendSymbol("6"));
        btn7.setOnClickListener(v -> appendSymbol("7"));
        btn8.setOnClickListener(v -> appendSymbol("8"));
        btn9.setOnClickListener(v -> appendSymbol("9"));
        btn0.setOnClickListener(v -> appendSymbol("0"));

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
        double finalResult = 0;

        if (currentText.contains("+")) {
            String[] parts = currentText.split("\\+");
            if (parts.length == 2) {
                double firstValue = Double.parseDouble(parts[0]);
                double secondValue = Double.parseDouble(parts[1]);
                finalResult = firstValue + secondValue;
                tvDisplay.setText(String.valueOf(finalResult));
            }
        } else if (currentText.contains("-")) {
            String[] parts = currentText.split("-");
            if (parts.length == 2) {
                double firstValue = Double.parseDouble(parts[0]);
                double secondValue = Double.parseDouble(parts[1]);
                finalResult = firstValue - secondValue;
                tvDisplay.setText(String.valueOf(finalResult));
            }
        }
    }

    private void clearCalculator() {
        tvDisplay.setText("");
    }
}