package com.example.planifica_vacaciones

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photos WHERE placeId = :placeId")
    fun getPhotosForPlace(placeId: Long): LiveData<List<Photo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: Photo)

}
