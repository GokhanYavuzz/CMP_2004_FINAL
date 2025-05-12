# 📚 EduGeminiChat – An Educational Gemini Chatbot for Kids

EduGeminiChat is a clean, friendly, and mobile-friendly Android chatbot app powered by Google's Gemini API. Designed for kids aged 7–10, it helps them explore educational topics in a simple, interactive, and supportive way. Whether a curious question about volcanoes or a simple explanation of math concepts, EduGeminiChat is here to make learning fun.

> 👨‍💻 Created by **Gökhan Yavuz**

---

## 🎯 Purpose

The project aims to combine the power of AI with intuitive mobile UI to:
- Encourage curiosity in young learners
- Provide age-appropriate, friendly explanations
- Offer a safe introduction to AI-powered education tools

---

## 🖼️ App Preview

- Main screen with input field and response area  
- Child-friendly responses from Gemini API  
- Scrollable chat format with auto-scroll

---

## ⚙️ Technologies Used

- **Android Studio** with Java
- **Google Gemini API (v1beta - Flash model)**
- **HTTPURLConnection** for API requests
- **Clean XML-based UI** for mobile layout

---

## 📲 Features

✅ Easy-to-use chatbot interface  
✅ Custom prompt tailored to kids aged 7–10  
✅ Real-time API interaction with Gemini  
✅ Friendly greetings and step-by-step replies  
✅ Scrollable chat log with response formatting  
✅ Emoji-based chat feedback  

---

## 🏗️ Project Structure

├── MainActivity.java # UI logic and response handling

├── GeminiApiService.java # Handles API POST requests to Gemini

├── Constants.java # Stores Gemini API key

├── res/layout/activity_main.xml # UI layout in XML

2. Add Your Gemini API Key
Open Constants.java and replace the placeholder:

public static final String GEMINI_API_KEY = "YOUR_API_KEY";

🛡️ Avoid committing your API key in production repositories.

3. Build and Run
Open the project in Android Studio
Run it on an emulator or physical device (Android 10+ recommended)

💬 Sample Interaction

👤 You: What is gravity?

🤖 Gemini: Hello! Gravity is the invisible force that pulls things down to the ground. Like when you jump, gravity pulls you back!

🔐 Security Note

For demo purposes, the API key is stored in Constants.java. In production:

Use encrypted storage or a secure key vault

Never hardcode API keys into your source code

📦 Improvements & Ideas
Here are a few ideas to improve this project:

🔊 Add Text-to-Speech for read-aloud replies

🗃️ Store past chats with Room DB or Firebase

🌍 Support multiple languages for diverse learners

🧠 Switch between Gemini models (Pro, Flash)

