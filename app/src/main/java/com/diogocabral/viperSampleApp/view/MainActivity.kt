package com.diogocabral.viperSampleApp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diogocabral.viperSampleApp.R
import com.diogocabral.viperSampleApp.presenter.PhrasePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var presenter: PhrasePresenter = PhrasePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.generateRandomPhrase()

        btn_new_phrase.setOnClickListener {
            presenter.generateRandomPhrase()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }

    fun setPhraseText(text: String){
        txt_phrase.text = text
    }
}
