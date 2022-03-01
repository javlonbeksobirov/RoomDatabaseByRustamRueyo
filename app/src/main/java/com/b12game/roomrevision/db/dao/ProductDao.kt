package com.b12game.roomrevision.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.b12game.roomrevision.db.entity.Product

@Dao
interface ProductDao {

    @Insert()
    fun insertProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProduct(): List<Product>

    @Query("Delete From product")
    fun clearProduct()

    @Query("DELETE FROM product WHERE productId=:productId")
    fun removeProduct(productId: Int)
}