package com.comic.universe.ui.view.comic

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.repository.ComicRepository
import com.comic.universe.ui.adapter.ComicAdapter
import com.comic.universe.ui.interfaces.onDetailsComicsInterfaces
import com.comic.universe.util.Multiple
import kotlinx.android.synthetic.main.fragment_comic.*

class ComicFragment : BaseFragment() , onDetailsComicsInterfaces {

    lateinit var comicViewModel: ComicViewModel
    lateinit var comicRepository: ComicRepository
    var mAdapterComic : ComicAdapter? = null
    var responseOperation : Int = 0

    override fun onFinishedViewLoad() {
        initializeUi()
    }

    private fun initializeUi(){
        comicRepository = ComicRepository(retrofit)
        comicViewModel = ComicViewModel(comicRepository)
        //comicViewModel.getStories()
        //responseOperation = arguments!!.getInt("responseOperation", responseOperation)

        comicViewModel.getComic()
        comicViewModel.liveData.observe(this, recyclerComic)

        //isMutiple(responseOperation.toDouble())
    }

    private fun initAdapterComic(comic : List<Comic>){
        mAdapterComic = ComicAdapter(comic)
        mAdapterComic!!.onDetailComic(this)
        rvComic.adapter = mAdapterComic
    }

    var recyclerComic = Observer<List<Comic>>{comic ->
        initAdapterComic(comic)
    }

    override fun onDetailsComic(comic: Comic) {
            var bundle = Bundle()
            bundle.putInt("comicId", comic.id)
            Log.d("idprueba", comic.id.toString())
            navController()!!.navigate(R.id.action_comicFragment_to_detailComicFragment, bundle)
        }

    fun isMutiple(numb : Double) {
        when {
            numb == 0.0 -> {
                //comicViewModel.getCharacters()
            }
            numb.ResponseMultipleOf(3) -> {
                comicViewModel.getComic()
                comicViewModel.liveData.observe(this, recyclerComic)
            }
            numb.ResponseMultipleOf(5) -> {
                comicViewModel.getComic()
                comicViewModel.liveData.observe(this, recyclerComic)
            }
            numb.ResponseMultipleOf(7) -> {
                //comicViewModel.getCreators()
            }
            numb.ResponseMultipleOf(11) -> {
                //comicViewModel.getEvents()
            }
            numb.ResponseMultipleOf(13) -> {
                //comicViewModel.getSeries()
            }
        }
    }

    fun Double.ResponseMultipleOf(value: Int): Boolean {
        return (this % value) == 0.0
    }

    override fun fragmentLayout(): Int = R.layout.fragment_comic
}