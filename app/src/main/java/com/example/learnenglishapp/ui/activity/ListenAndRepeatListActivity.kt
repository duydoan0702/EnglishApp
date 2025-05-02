package com.example.learnenglishapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.RecognitionListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.learnenglishapp.R

class ListenAndRepeatListActivity : AppCompatActivity() {

    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_listen_and_repeat_list)

        // Khởi tạo TextView để hiển thị kết quả
        resultTextView = findViewById(R.id.tvResult)

        // Khởi tạo nút bắt đầu nói
        val btnStartSpeech = findViewById<Button>(R.id.btnCheckSpeech)

        // Khởi tạo SpeechRecognizer
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {}
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() {}

            override fun onError(error: Int) {
                resultTextView.text = "Có lỗi xảy ra khi nhận diện giọng nói!"
            }

            override fun onResults(results: Bundle?) {
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (matches != null && matches.isNotEmpty()) {
                    val recognizedText = matches[0]
                    resultTextView.text = "Phát âm: $recognizedText"
                    checkPronunciation(recognizedText)
                }
            }

            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })

        // Sự kiện nhấn nút để bắt đầu nhận diện giọng nói
        btnStartSpeech.setOnClickListener {
            startSpeechRecognition()
        }
    }

    private fun startSpeechRecognition() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "vi-VN")  // Thiết lập ngôn ngữ tiếng Việt
        speechRecognizer.startListening(intent)
    }

    private fun checkPronunciation(recognizedText: String) {
        // So sánh với câu trả lời đúng
        val correctAnswer = "câu trả lời đúng"  // Ví dụ câu trả lời
        if (recognizedText.equals(correctAnswer, ignoreCase = true)) {
            resultTextView.text = "Phát âm chính xác!"
        } else {
            resultTextView.text = "Phát âm chưa chính xác!"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer.destroy()
    }
}
