package com.example.clarios6.acmexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {
    private val questionLibrary = QuestionLibrary()
    private var mScoreView : TextView? = null
    private var mQuestionView : TextView? = null
    private var mButtonChoiceA : Button? = null
    private var mButtonChoiceB : Button? = null
    private var mButtonChoiceC : Button? = null

    private var mAnswer : String? = null
    private var mScore = 0
    private var mQuestionNumber = 0

    private val maxScore = 3
    private var attempts = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mScoreView = findViewById<TextView>(R.id.actual_score) as TextView
        mQuestionView = findViewById<TextView>(R.id.question) as TextView
        mButtonChoiceA = findViewById<Button>(R.id.choiceA) as Button
        mButtonChoiceB = findViewById<Button>(R.id.choiceB) as Button
        mButtonChoiceC = findViewById<Button>(R.id.choiceC) as Button


        updateQuestion()
        mButtonChoiceA?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                attempts++
                if(mButtonChoiceA?.text == mAnswer){
                    mScore += 1
                    updateScore(mScore)
                    updateQuestion()
                } else{
                    updateQuestion()
                    Toast.makeText(this@QuizActivity, "Wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })

        mButtonChoiceB?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                attempts++
                if(mButtonChoiceB?.text == mAnswer){
                    mScore += 1
                    updateScore(mScore)
                    updateQuestion()
                } else{
                    updateQuestion()
                    Toast.makeText(this@QuizActivity, "Wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })

        mButtonChoiceC?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                attempts++
                if(mButtonChoiceC?.text == mAnswer){
                    mScore += 1
                    updateScore(mScore)
                    updateQuestion()
                } else{
                    updateQuestion()
                    Toast.makeText(this@QuizActivity, "Wrong", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun updateScore(point : Int){
        mScoreView?.text = "" + point
    }

    private fun updateQuestion(){
        if(attempts == maxScore){
            initiateEnd()
        }
        if(mScore == maxScore){
            return
        }
        if(mQuestionNumber < questionLibrary.mQuestions.size) {
            mQuestionView?.text = questionLibrary.getQuestion(mQuestionNumber)
            mButtonChoiceA?.text = questionLibrary.getChoiceA(mQuestionNumber)
            mButtonChoiceB?.text = questionLibrary.getChoiceB(mQuestionNumber)
            mButtonChoiceC?.text = questionLibrary.getChoiceC(mQuestionNumber)

            mAnswer = questionLibrary.getCorrectAnswer(mQuestionNumber)
            mQuestionNumber++
        }
    }

    private fun initiateEnd(){
        ScoreComm.score = mScore
        println(ScoreComm.score)
        finish()
    }
}


