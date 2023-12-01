package com.example.planifica_vacaciones

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Este código define una base de datos de habitaciones llamada CreateVacationPlannerDB con dos tablas (Lugar y Foto).
//También proporciona una instancia única de la base de datos utilizando el patrón de creación de bases de datos Room.
//Esto garantiza que solo se cree una instancia de la base de datos, lo que promueve la seguridad y eficiencia de los subprocesos.

// Define the Room database by annotating the class with @Database
@Database(entities = [Place::class, Photo::class], version = 1, exportSchema = false)
abstract class CreateVacationPlannerDB : RoomDatabase() {
    // Declare abstract methods for each DAO (Data Access Object) in the database //Declarar métodos abstractos para cada DAO en la DB
    abstract fun placeDao(): PlaceDao
    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: CreateVacationPlannerDB? = null

        // Create a singleton instance of the database //Crear una instancia singleton de la base de datos.
        fun getDatabase(context: Context): CreateVacationPlannerDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CreateVacationPlannerDB::class.java,
                    "create_vacation_planner_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

