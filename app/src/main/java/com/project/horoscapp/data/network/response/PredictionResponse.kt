package com.project.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.project.horoscapp.domain.model.PredictionModel

class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String,
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}