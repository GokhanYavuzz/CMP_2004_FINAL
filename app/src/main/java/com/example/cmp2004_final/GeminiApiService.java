package com.example.cmp2004_final;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class GeminiApiService {
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public static String sendMessageToGemini(String userInput) {
        try {
            URL url = new URL(API_URL + "?key=" + Constants.GEMINI_API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String prompt = "You are a friendly and smart education chatbot for kids aged 7 to 10. "
                    + "Explain things clearly, step by step, using simple and encouraging language. "
                    + "Always include a friendly greeting like 'Hello!' at the start.";

            String jsonInputString = "{\n" +
                    "  \"contents\": [\n" +
                    "    {\n" +
                    "      \"parts\": [\n" +
                    "        {\"text\": \"" + prompt + "\\nUser: " + userInput + "\"}\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
                return parseGeminiResponse(response.toString());
            } else {
                return "Could not get a response. Server returned code: " + responseCode;
            }

        } catch (IOException e) {
            return "Connection error: Please check your internet connection.";
        } catch (Exception e) {
            return "An unexpected error occurred: " + e.getMessage();
        }
    }

    private static String parseGeminiResponse(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray candidates = obj.getJSONArray("candidates");
            JSONObject content = candidates.getJSONObject(0).getJSONObject("content");
            JSONArray parts = content.getJSONArray("parts");
            return parts.getJSONObject(0).getString("text").trim();
        } catch (Exception e) {
            return "Error parsing Gemini's response.";
        }
    }
}
