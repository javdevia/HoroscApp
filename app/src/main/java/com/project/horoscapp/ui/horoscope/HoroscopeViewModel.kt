package com.project.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.project.horoscapp.domain.model.HoroscopeInfo
import com.project.horoscapp.domain.model.HoroscopeInfo.Aries
import com.project.horoscapp.domain.model.HoroscopeInfo.Geminis
import com.project.horoscapp.domain.model.HoroscopeInfo.Tauro
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope


    init {
        _horoscope.value = listOf(
            Aries, Tauro, Geminis
        )
    }


}