package com.example.clarios6.acmexample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var totalScore = findViewById<TextView>(R.id.total_score) as TextView
//        var lastScore = findViewById<TextView>(R.id.last_score) as TextView
//        var startButton = findViewById<Button>(R.id.start_button) as Button

        var totalScore = findViewById(R.id.total_score) as TextView
        var lastScore = findViewById(R.id.last_score) as TextView
        var startButton = findViewById(R.id.start_button) as Button

        startButton.setOnClickListener{
            val intent = Intent(this, QuizActivity::class.java)
            ScoreComm.score = 0
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
//        var totalScore = findViewById<TextView>(R.id.total_score) as TextView
//        var lastScore = findViewById<TextView>(R.id.last_score) as TextView
        var totalScore = findViewById(R.id.total_score) as TextView
        var lastScore = findViewById(R.id.last_score) as TextView
        lastScore.text = "" + ScoreComm.score
        ScoreComm.totScore += ScoreComm.score
        totalScore.text = "" + ScoreComm.totScore
    }
}
