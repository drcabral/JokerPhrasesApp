package com.diogocabral.viperSampleApp.interactor

import com.diogocabral.viperSampleApp.entity.PhraseEntity
import com.diogocabral.viperSampleApp.entity.PhraseResultEntity
import com.diogocabral.viperSampleApp.interactor.service.PhrasesService
import com.diogocabral.viperSampleApp.util.RxSchedulerTestSetup
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private const val PHRASES_QUANTITY = 10
private const val PHRASE_JOKE = "foo"
private const val PHRASE_CATEGORY = "bar"

@RunWith(MockitoJUnitRunner::class)
class PhraseInteractorTest {

    @Mock
    lateinit var phrasesService: PhrasesService

    lateinit var phraseInteractor: PhraseInteractor

    @Before
    fun setup() {
        RxSchedulerTestSetup.setupRxScheduler()
        phraseInteractor = PhraseInteractor(phrasesService)
    }

    @After
    fun tearDown() {
        RxSchedulerTestSetup.reset()
    }

    @Test
    fun shouldReturnPhraseWhenCallFetchPhrases(){
        val phraseResultEntity = PhraseResultEntity(PHRASE_CATEGORY, listOf(PhraseEntity(PHRASES_QUANTITY, PHRASE_JOKE)))

        whenever(phrasesService.fetchRandomPhrase(PHRASES_QUANTITY)).thenReturn(Observable.just(phraseResultEntity))

        phraseInteractor.fetchPhrases().test().assertResult(PHRASE_JOKE)
        verify(phrasesService).fetchRandomPhrase(PHRASES_QUANTITY)
    }

}