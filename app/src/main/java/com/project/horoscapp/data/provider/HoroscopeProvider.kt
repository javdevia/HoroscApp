package com.project.horoscapp.data.provider

import com.project.horoscapp.domain.model.HoroscopeInfo
import com.project.horoscapp.domain.model.HoroscopeInfo.*

*


class HoroscopeProvider {
    fun getHoroscopes():List<HoroscopeInfo>{
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Escorpio,
            Sagitario,
            Capricornio,
            Acuario,
            Piscis
        )
    }
}