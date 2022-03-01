package com.b12game.roomrevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.b12game.roomrevision.databinding.ActivityMainBinding
import com.b12game.roomrevision.db.AppDatabase
import com.b12game.roomrevision.db.entity.Product

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDatabase = AppDatabase.getInstance(this)
        binding.apply {
            saveBtn.setOnClickListener {
                val product = Product(
                    name = productName.text.toString(),
                    price = productPrice.text.toString().toInt()
                )
                appDatabase.productDao().insertProduct(product)
            }

            getAllProductBtn.setOnClickListener {
                tvGetData.text = appDatabase.productDao().getAllProduct().toString()
            }

            deleteAllBtn.setOnClickListener {
                appDatabase.productDao().clearProduct()
                tvGetData.text = null
//                tvGetData.text = appDatabase.productDao().getAllProduct().toString()
            }

        }
    }
}