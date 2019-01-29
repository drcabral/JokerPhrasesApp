package com.diogocabral.viperSampleApp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diogocabral.viperSampleApp.R
import com.diogocabral.viperSampleApp.presenter.PhrasePresenter
import kotlinx.android.synthetic.main.phrases_activity.btn_new_phrase
import kotlinx.android.synthetic.main.phrases_activity.txt_phrase

class PhrasesActivity : AppCompatActivity() {

    private var presenter: PhrasePresenter = PhrasePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phrases_activity)

        presenter.setInitialPhrase()

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
