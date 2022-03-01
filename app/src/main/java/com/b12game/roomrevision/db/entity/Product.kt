package com.b12game.roomrevision.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var productId:Int? = null, var name: String, var price: Int){}