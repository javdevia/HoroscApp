package com.project.horoscapp.data.provider

import com.project.horoscapp.domain.model.HoroscopeInfo
import com.project.horoscapp.domain.model.HoroscopeInfo.Acuario
import com.project.horoscapp.domain.model.HoroscopeInfo.Aries
import com.project.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.project.horoscapp.domain.model.HoroscopeInfo.Capricornio
import com.project.horoscapp.domain.model.HoroscopeInfo.Escorpio
import com.project.horoscapp.domain.model.HoroscopeInfo.Geminis
import com.project.horoscapp.domain.model.HoroscopeInfo.Leo
import com.project.horoscapp.domain.model.HoroscopeInfo.Libra
import com.project.horoscapp.domain.model.HoroscopeInfo.Piscis
import com.project.horoscapp.domain.model.HoroscopeInfo.Sagitario
import com.project.horoscapp.domain.model.HoroscopeInfo.Tauro
import com.project.horoscapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
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