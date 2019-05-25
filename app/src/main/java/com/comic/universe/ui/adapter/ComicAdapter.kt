package com.comic.universe.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comic.universe.R
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.model.local.Creators
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_comic.view.*

const val EXTENSIONS_IMAGE = ".jgp"
class ComicAdapter(var myDataset : List<Creators>) :
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
        holder.mimageComic.text = myDataset[position].firstName

        /*if(myDataset[position].thumbnail != null){
            Picasso.get()
                .load(myDataset[position].thumbnail!!.path + EXTENSIONS_IMAGE)
                .resize(600, 950)
                .centerCrop()
                .into(holder.mimageComic)
        }*/

    }

    override fun getItemCount(): Int = myDataset.size
}