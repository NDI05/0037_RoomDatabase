package com.nusadataindonesia.pertemuan_kesembilan.uicontroller

import com.nusadataindonesia.pertemuan_kesembilan.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}