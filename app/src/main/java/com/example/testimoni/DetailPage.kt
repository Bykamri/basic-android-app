package com.example.testimoni

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)

        val titleSet: TextView = findViewById(R.id.movie_set_title)
        val imgSet: ImageView = findViewById(R.id.movie_set_image)
        val descSet: TextView = findViewById(R.id.movie_set_description)
        val castSet: TextView = findViewById(R.id.movie_set_cast)
        val directSet: TextView = findViewById(R.id.movie_set_direction)
        val yearSet: TextView = findViewById(R.id.movie_set_year)
        val writSet: TextView = findViewById(R.id.movie_set_writter)
        val rateSet: TextView = findViewById(R.id.movie_set_rating)
        val storySet: TextView = findViewById(R.id.movie_set_storyline)
        val timeSet: TextView = findViewById(R.id.movie_set_times)

        val sTitle = intent.getStringExtra(EXTRA_TITLE)
        val sImg = intent.getStringExtra(EXTRA_PIC)
        val sDesc = intent.getStringExtra(EXTRA_DESC)
        val sCast = intent.getStringExtra(EXTRA_CAST)
        val dirCast = intent.getStringExtra(EXTRA_DIRECT)
        val sYear = intent.getStringExtra(EXTRA_YEAR)
        val sWrite = intent.getStringExtra(EXTRA_WRITER)
        val sStory = intent.getStringExtra(EXTRA_STORY)
        val sTime = intent.getStringExtra(EXTRA_TIMES)
        val sRate = intent.getStringExtra(EXTRA_RATING)

        titleSet.text = sTitle
        Glide.with(this)
            .load(sImg)
            .apply(RequestOptions())
            .into(imgSet)

        descSet.text = sDesc
        castSet.text = sCast
        directSet.text = dirCast
        yearSet.text = sYear
        writSet.text = sWrite
        storySet.text = sStory
        timeSet.text = sTime
        rateSet.text = sRate

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_PIC = "extra_pic"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_CAST = "extra_cast"
        const val EXTRA_DIRECT = "extra_direct"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_WRITER = "extra_writer"
        const val EXTRA_STORY = "extra_story"
        const val EXTRA_TIMES = "extra_times"
        const val EXTRA_RATING = "extra_rating"

    }
}