package com.example.hashtaggenerator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 입력 필드와 버튼, 텍스트뷰 연결
        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        val input3 = findViewById<EditText>(R.id.input3)
        val input4 = findViewById<EditText>(R.id.input4)
        val input5 = findViewById<EditText>(R.id.input5)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val copyButton = findViewById<Button>(R.id.copyButton)
        val outputTextView = findViewById<TextView>(R.id.outputTextView)

        // 버튼 클릭 시 해시태그 생성
        generateButton.setOnClickListener {
            val word1 = input1.text.toString().trim()
            val word2 = input2.text.toString().trim()
            val word3 = input3.text.toString().trim()
            val word4 = input4.text.toString().trim()
            val word5 = input5.text.toString().trim()

            // 해시태그 형식으로 출력
            val hashtagResult = "#$word1 #$word2 #$word3 #$word4 #$word5"
            outputTextView.text = hashtagResult
        }

        // 버튼 클릭 시 해시태그를 클립보드에 복사
        copyButton.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Hashtags", outputTextView.text.toString())
            clipboard.setPrimaryClip(clip)

            // 사용자에게 복사 완료 메시지 표시
            Toast.makeText(this, "Hashtags copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    }
}
