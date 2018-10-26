package com.diogocabral.viperSampleApp.entity

import com.google.gson.annotations.SerializedName

data class PhraseResultEntity(@SerializedName("type") var type: String,
                         @SerializedName("value") var phrases: List<PhraseEntity>)