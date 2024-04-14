package com.example.testimoni

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_page)

        val myImg: ImageView = findViewById(R.id.img_item_photo)

        val imgLink = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:52c49609a65663b3ce2a3f2a66d0e5b020221021175927.png"

        Glide.with(this)
            .load(imgLink)
            .apply(RequestOptions())
            .into(myImg)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}