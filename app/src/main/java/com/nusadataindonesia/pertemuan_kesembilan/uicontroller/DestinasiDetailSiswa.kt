package com.nusadataindonesia.pertemuan_kesembilan.uicontroller

import com.nusadataindonesia.pertemuan_kesembilan.R
object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg]"
}