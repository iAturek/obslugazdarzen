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

    private TextView tvCounter;
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

        tvCounter = findViewById(R.id.tvCounter);

        View.OnClickListener counterListener = v -> {
            int id = v.getId();

            if (id == R.id.btnIncrement) {
                counter++;
            } else if (id == R.id.btnDecrement) {
                counter--;
            } else if (id == R.id.btnReset) {
                counter = 0;
            }

            tvCounter.setText(String.valueOf(counter));
        };

        findViewById(R.id.btnIncrement).setOnClickListener(counterListener);
        findViewById(R.id.btnDecrement).setOnClickListener(counterListener);
        findViewById(R.id.btnReset).setOnClickListener(counterListener);
    }
}