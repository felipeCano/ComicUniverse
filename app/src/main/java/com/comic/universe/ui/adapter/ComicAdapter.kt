package com.comic.universe.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comic.universe.R
import com.comic.universe.control.model.local.Comic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_comic.view.*

class ComicAdapter(var myDataset : List<Comic>) :
RecyclerView.Adapter<ComicAdapter.ComicHolder>(){

    class ComicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val mimageComic = itemView.imageComic
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_comic, parent, false)
        return ComicHolder(view)
    }

    override fun onBindViewHolder(holder: ComicHolder, position: Int) {
        holder.mimageComic.text = myDataset[position].originalName
        /*Picasso.get()
            .load(myDataset[position].imageserie)
            .resize(600, 950)
            .centerCrop()
            .into(holder.mimageComic)*/
    }

    override fun getItemCount(): Int = myDataset.size
}