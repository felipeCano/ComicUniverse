package com.comic.universe.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comic.universe.R
import com.comic.universe.control.model.local.Characters
import com.comic.universe.ui.interfaces.onDetailsComicsInterfaces
import kotlinx.android.synthetic.main.adapter_comic.view.*

class CharactersAdapter(var myDataset: List<Characters>) :
    RecyclerView.Adapter<CharactersAdapter.CharactersHolder>() {

    var detailComic: onDetailsComicsInterfaces? = null

    inner class CharactersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {
        val mimageComic = itemView.imageComic

        init {
            mimageComic.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val i = v!!.id
            if (i == R.id.imageComic){
                detailComic!!.onDetailCharacters(myDataset[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_comic, parent, false)
        return CharactersHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        holder.mimageComic.text = myDataset[position].name
        /*if(myDataset[position].thumbnail != null){
            Picasso.get()
                .load(myDataset[position].thumbnail!!.path + EXTENSIONS_IMAGE)
                .resize(600, 950)
                .centerCrop()
                .into(holder.mimageComic)
        }*/

    }

    override fun getItemCount(): Int = myDataset.size

    fun onDetailComic(onDetailsComicsInterfaces: onDetailsComicsInterfaces) {
        this.detailComic = onDetailsComicsInterfaces
    }
}