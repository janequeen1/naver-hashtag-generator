package com.example.hashtaggenerator

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.hashtaggenerator.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

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
    }
}