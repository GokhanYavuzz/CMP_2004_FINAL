package com.example.cmp2004_final;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserInput;
    private Button buttonSend;
    private TextView textViewResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserInput = findViewById(R.id.editTextUserInput);
        buttonSend = findViewById(R.id.buttonSend);
        textViewResponse = findViewById(R.id.textViewResponse);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextUserInput.getText().toString().trim();
                textViewResponse.setText("Waiting for response...");

                new Thread(() -> {
                    String response = GeminiApiService.sendMessageToGemini(userInput);
                    runOnUiThread(() -> textViewResponse.setText(response));
                }).start();
            }
        });
    }
}
