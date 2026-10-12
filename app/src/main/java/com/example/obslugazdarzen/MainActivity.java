package com.example.obslugazdarzen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvDisplay;
    private Button btnIncrement, btnDecrement, btnReset;
    private int counter = 0;

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

        tvDisplay = findViewById(R.id.tvCounter);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnDecrement = findViewById(R.id.btnDecrement);
        btnReset = findViewById(R.id.btnReset);

        btnIncrement.setOnClickListener(this);
        btnDecrement.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnIncrement) {
            incrementCounter();
        } else if (v == btnDecrement) {
            decrementCounter();
        } else if (v == btnReset) {
            resetCounter();
        }
    }

    private void incrementCounter() {
        counter++;
        tvDisplay.setText(String.valueOf(counter));
    }

    private void decrementCounter() {
        if (counter <= 0) {
            Toast.makeText(this, getString(R.string.error_negative), Toast.LENGTH_SHORT).show();
            return;
        }
        counter--;
        tvDisplay.setText(String.valueOf(counter));
    }

    private void resetCounter() {
        counter = 0;
        tvDisplay.setText(String.valueOf(counter));
    }
}