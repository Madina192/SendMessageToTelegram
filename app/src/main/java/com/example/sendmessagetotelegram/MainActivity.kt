package com.example.sendmessagetotelegram

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessagetotelegram.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendMessage()
    }

    private fun sendMessage(){
        binding.btnSend.setOnClickListener{
            if(binding.etMessage.text != null) {
                try {
                    val telegramIntent = Intent(Intent.ACTION_VIEW)
                    //telegramIntent.action = Intent.ACTION_SEND
                    telegramIntent.data = Uri.parse("http://telegram.me/aixend")
                    telegramIntent.putExtra(Intent.EXTRA_TEXT, binding.etMessage.text)
                    //telegramIntent.type = "text/plain"
                    startActivity(telegramIntent)
                } catch (e: Exception) {
                    // error message
                }
            }
        }
    }
}