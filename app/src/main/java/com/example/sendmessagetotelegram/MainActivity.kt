package com.example.sendmessagetotelegram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessagetotelegram.databinding.ActivityMainBinding
import java.lang.Exception


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
                    val appName = "org.telegram.messenger"
                    val tIntent = Intent(Intent.ACTION_SEND)
                    tIntent.type = "text/plain"
                    tIntent.setPackage(appName)
                    tIntent.putExtra(Intent.EXTRA_TEXT, binding.etMessage.text)
                    startActivity(tIntent)
                } catch (e : Exception){
                    //todo
                }
            }
        }
    }
}