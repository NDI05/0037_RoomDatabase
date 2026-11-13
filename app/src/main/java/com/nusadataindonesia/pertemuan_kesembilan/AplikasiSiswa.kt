package com.nusadataindonesia.pertemuan_kesembilan

import android.app.Application
import com.nusadataindonesia.pertemuan_kesembilan.repositori.ContainerApp
import com.nusadataindonesia.pertemuan_kesembilan.repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp
        private set

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
