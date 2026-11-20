package com.nusadataindonesia.pertemuan_kesembilan.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nusadataindonesia.pertemuan_kesembilan.repositori.RepositoriSiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    savedSateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
): ViewModel(){

}

