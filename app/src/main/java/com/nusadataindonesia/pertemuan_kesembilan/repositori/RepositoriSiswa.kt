package com.nusadataindonesia.pertemuan_kesembilan.repositori

import com.nusadataindonesia.pertemuan_kesembilan.room.Siswa
import com.nusadataindonesia.pertemuan_kesembilan.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> =
        siswaDao.getAllSiswaStream()

    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}
