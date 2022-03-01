package com.b12game.roomrevision.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.b12game.roomrevision.db.dao.ProductDao
import com.b12game.roomrevision.db.entity.Product

@Database(entities = [Product::class], version = 1)

abstract class AppDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object{
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"product.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

            }
        return instance!!
        }
    }
}