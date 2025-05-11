package com.example.cmp2004_final;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray candidates = jsonResponse.getJSONArray("candidates");
                        JSONObject firstCandidate = candidates.getJSONObject(0);
                        JSONObject content = firstCandidate.getJSONObject("content");
                        JSONArray parts = content.getJSONArray("parts");
                        String message = parts.getJSONObject(0).getString("text");

                        runOnUiThread(() -> textViewResponse.setText(message));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        runOnUiThread(() -> textViewResponse.setText("An error occurred while parsing the response."));
                    }
                }).start();
            }
        });
    }
}
