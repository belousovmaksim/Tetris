package com.example.tetrisnoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tetrisnoactivity.databinding.ActivityMainBinding
import storage.AppPreferences
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnNewGame.setOnClickListener { onBtnNewGameClick() }
        binding.btnResetScore.setOnClickListener { onBtnResetScoreClick() }
        binding.btnExit.setOnClickListener { onBtnExitClick() }
    }

    private fun onBtnNewGameClick() {

        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)

    }

    private fun onBtnResetScoreClick() {
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Toast.makeText(this, "Score successfully reset", Toast.LENGTH_SHORT).show()
        binding.tvHighScore.text = "High score: ${preferences.getHighScore()}"
    }

    private fun onBtnExitClick() {
        exitProcess(0)
    }

}