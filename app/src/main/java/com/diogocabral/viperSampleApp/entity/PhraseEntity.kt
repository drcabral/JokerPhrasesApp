package com.diogocabral.viperSampleApp.entity

import com.google.gson.annotations.SerializedName

data class PhraseEntity(@SerializedName("id") var id: Int, @SerializedName("joke") var joke: String)