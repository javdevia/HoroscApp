package com.project.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.project.horoscapp.databinding.ItemHoroscopeBinding
import com.project.horoscapp.domain.model.HoroscopeInfo
import kotlinx.coroutines.NonCancellable.start

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){

        val context = binding.tvHoroscope.context

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text= context.getString(horoscopeInfo.name)

        binding.Layout.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope)
            //onItemSelected(horoscopeInfo)
        }
    }
    private fun startRotationAnimation(view:View){
        view.animate().apply{
            duration = 500
            interpolator = LinearInterpolator ()
            rotationBy(360f)
            start()
        }
    }
}