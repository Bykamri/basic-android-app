package com.example.testimoni.breh

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testimoni.DetailPage
import com.example.testimoni.Movie
import com.example.testimoni.R

class MovieAdapter(private val moviesList: ArrayList<Movie>):RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgMovie: ImageView = itemView.findViewById(R.id.img_movie)
        var movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        var movieYear: TextView = itemView.findViewById(R.id.movie_year)
        var movieRating: TextView = itemView.findViewById(R.id.movie_rating)
        var movieTimes: TextView = itemView.findViewById(R.id.movie_times)
        var movieDesc: TextView = itemView.findViewById(R.id.movie_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, year, times, photo, description, rating, topCast, director, writer, storyline ) = moviesList[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgMovie)

        holder.movieTimes.text = times
        holder.movieRating.text = rating
        holder.movieTitle.text = title
        holder.movieYear.text = year
        holder.movieDesc.text = description

        val detContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val movePages = Intent(detContext, DetailPage::class.java)
            movePages.putExtra(DetailPage.EXTRA_TITLE, title)
            movePages.putExtra(DetailPage.EXTRA_PIC, photo)
            movePages.putExtra(DetailPage.EXTRA_DESC, description)
            movePages.putExtra(DetailPage.EXTRA_CAST, topCast)
            movePages.putExtra(DetailPage.EXTRA_DIRECT, director)
            movePages.putExtra(DetailPage.EXTRA_YEAR, year)
            movePages.putExtra(DetailPage.EXTRA_TIMES, times)
            movePages.putExtra(DetailPage.EXTRA_STORY, storyline)
            movePages.putExtra(DetailPage.EXTRA_RATING, rating)
            movePages.putExtra(DetailPage.EXTRA_WRITER, writer)
            detContext.startActivity(movePages)
        }


    }
}