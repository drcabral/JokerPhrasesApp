package com.diogocabral.viperSampleApp.entity

import com.google.gson.annotations.SerializedName

class PhraseResultEntity(@SerializedName("type") var type: String, @SerializedName("value") var phrases: List<PhraseEntity>)