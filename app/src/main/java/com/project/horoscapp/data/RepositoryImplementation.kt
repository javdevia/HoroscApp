package com.project.horoscapp.data

import android.util.Log
import com.project.horoscapp.data.network.HoroscopeApiService
import com.project.horoscapp.domain.Repository
import com.project.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService) :
    Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("JAVDEVIA", "Ha ocurrido un error ${it.message}") }
        return null
    }
}