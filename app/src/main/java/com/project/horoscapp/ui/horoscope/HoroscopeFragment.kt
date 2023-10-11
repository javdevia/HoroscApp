package com.project.horoscapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.project.horoscapp.databinding.FragmentHoroscopeBinding
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
import com.project.horoscapp.domain.model.HoroscopeModel
import com.project.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected={
            val type = when(it){
                Acuario -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricornio ->HoroscopeModel.Capricorn
                Escorpio -> HoroscopeModel.Scorpio
                Geminis -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Piscis -> HoroscopeModel.Pisces
                Sagitario -> HoroscopeModel.Sagittarius
                Tauro -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    // Cambios en horoscope
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
