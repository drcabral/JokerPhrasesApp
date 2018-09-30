package com.diogocabral.jokerPhrasesApp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.diogocabral.jokerPhrasesApp.R
import com.diogocabral.jokerPhrasesApp.presenter.PhrasePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var presenter: PhrasePresenter = PhrasePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setPhraseOnView()

        btn_new_phrase.setOnClickListener {
            presenter.setPhraseOnView()
        }
    }
}
