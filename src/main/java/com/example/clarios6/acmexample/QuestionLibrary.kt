package com.example.clarios6.acmexample

/**
 * Created by clarios6 on 10/31/17.
 */

public class QuestionLibrary{
    val mQuestions = arrayOf<String>(
            "What do you call the small image icons used to express emotions or ideas in digital communication",
            "What do the letters in the acronym CD-ROM stand for?",
            "In 1975 an engineer created the first electronic camera while working for what company?"
    )

    private val mChoices = arrayOf(
            arrayOf("emoticons", "emoji", "ASCII"),
            arrayOf("Check Disk Remove Only Memory", "Closed Directions Revive Once Monthly", "Compact Disk Read Only Memory"),
            arrayOf("Kodak", "Canon", "Minolta")

    )

    private val mCorrectAnswers = arrayOf("emoji",
            "Compact Disk Read Only Memory",
            "Kodak"
    )

    fun getQuestion(a : Int) : String{
        return mQuestions[a]
    }

    fun getChoiceA(a : Int) : String{
        return mChoices[a][0]
    }

    fun getChoiceB(a : Int) : String{
        return mChoices[a][1]
    }

    fun getChoiceC(a : Int) : String{
        return mChoices[a][2]
    }

    fun getCorrectAnswer(a : Int) :String{
        return mCorrectAnswers[a]
    }
}

