package com.nusadataindonesia.pertemuan_kesembilan.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nusadataindonesia.pertemuan_kesembilan.repositori.RepositoriSiswa
import com.nusadataindonesia.pertemuan_kesembilan.uicontroller.DestinasiEditSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
): ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiEditSiswa.itemIdArg])
    init {
        viewModelScope.launch {
            uiStateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                .filterNotNull()
                .first()
                .toUIStateSiswa(isEntryValid = true)
        }
    }

     fun updateUiState(detailSiswa: DetailSiswa){
         uiStateSiswa =
             UIStateSiswa(detailSiswa = detailSiswa,
                isEntryValid = validasiInput(uiState=detailSiswa))
     }

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun udpateSiswa(){
        if (validasiInput()){
            repositoriSiswa.updateSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}

