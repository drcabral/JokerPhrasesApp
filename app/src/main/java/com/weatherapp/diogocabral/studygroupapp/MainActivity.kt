package com.weatherapp.diogocabral.studygroupapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var phrases = arrayOf(
            "If you're good at something, never do it for free.",
            "It's not about money...it’s about sending a message. Everything burns!",
            "I believe, whatever doesn't kill you, simply makes you...stranger.",
            "Why so serious?",
            "Nobody panics when things go “according to plan”. Even if the plan is horrifying!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_new_phrase.setOnClickListener {
            val randomIndex = generateRandomArrayIndex(phrases)
            txt_phrase.text = phrases[randomIndex]
        }
    }

    private fun generateRandomArrayIndex(array: Array<String>) : Int {
        return Random().nextInt(array.size)
    }
}
