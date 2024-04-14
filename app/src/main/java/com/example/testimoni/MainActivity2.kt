package com.example.testimoni

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testimoni.breh.MovieAdapter

class MainActivity2 : AppCompatActivity() {
    private lateinit var rvMovie: RecyclerView
    private var listMovie: ArrayList<Movie> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        setSupportActionBar(findViewById(R.id.toolbar))

        rvMovie = findViewById(R.id.movie_view)
        rvMovie.setHasFixedSize(true)

        listMovie.addAll(MovieData.dataList)
        showRecyclerList()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showRecyclerList() {
        rvMovie.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = MovieAdapter(listMovie)
        rvMovie.adapter = listMovieAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectMode: Int) {
        when (selectMode) {
            R.id.item_menu -> {
                val aboutMe = Intent(this@MainActivity2, AboutPage::class.java)
                startActivity(aboutMe)
            }
        }
    }

}