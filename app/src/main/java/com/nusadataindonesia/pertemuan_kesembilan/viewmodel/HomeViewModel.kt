package com.nusadataindonesia.pertemuan_kesembilan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nusadataindonesia.pertemuan_kesembilan.AplikasiSiswa
import com.nusadataindonesia.pertemuan_kesembilan.repositori.RepositoriSiswa
import com.nusadataindonesia.pertemuan_kesembilan.room.Siswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(repositoriSiswa: RepositoriSiswa) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> = repositoriSiswa.getAllSiswaStream()
        .map { HomeUiState(listSiswa = it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    data class HomeUiState(val listSiswa: List<Siswa> = listOf())

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L

        fun factory(aplikasiSiswa: AplikasiSiswa): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    HomeViewModel(aplikasiSiswa.container.repositoriSiswa)
                }
            }
    }
}
