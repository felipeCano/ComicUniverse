package com.comic.universe.ui.view.comic

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.model.local.Characters
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.model.local.Creators
import com.comic.universe.control.repository.ComicRepository
import com.comic.universe.ui.adapter.CharactersAdapter
import com.comic.universe.ui.adapter.ComicAdapter
import com.comic.universe.ui.adapter.CreatorsAdaper
import com.comic.universe.ui.interfaces.onDetailsComicsInterfaces
import kotlinx.android.synthetic.main.fragment_comic.*

class ComicFragment : BaseFragment(), onDetailsComicsInterfaces {

    lateinit var comicViewModel: ComicViewModel
    lateinit var comicRepository: ComicRepository
    var mAdapterComic: ComicAdapter? = null
    var mAdapterCharacters: CharactersAdapter? = null
    var mAdapterCreators: CreatorsAdaper? = null
    var responseOperation: Int = 0

    override fun onFinishedViewLoad() {
        responseOperation = arguments!!.getInt("responseOperation", responseOperation)
        initializeUi()
    }

    private fun initializeUi() {
        comicRepository = ComicRepository(retrofit)
        comicViewModel = ComicViewModel(comicRepository)


        isMutiple(responseOperation.toDouble())
    }

    private fun initAdapterComic(comic: List<Comic>) {
        mAdapterComic = ComicAdapter(comic)
        mAdapterComic!!.onDetailComic(this)
        rvComic.adapter = mAdapterComic
    }

    private fun initAdapterCharacters(comic: List<Characters>) {
        mAdapterCharacters = CharactersAdapter(comic)
        mAdapterCharacters!!.onDetailComic(this)
        rvCharacters.adapter = mAdapterCharacters
    }

    private fun initAdapterCreators(comic: List<Creators>) {
        mAdapterCreators = CreatorsAdaper(comic)
        mAdapterCreators!!.onDetailComic(this)
        rvCreators.adapter = mAdapterCreators
    }

    var recyclerComic = Observer<List<Comic>> { comic ->
        initAdapterComic(comic)
    }
    var recyclerCharacters = Observer<List<Characters>> { comic ->
        initAdapterCharacters(comic)
    }
    var recyclerCreators = Observer<List<Creators>> { comic ->
        initAdapterCreators(comic)
    }

    override fun onDetailsComic(comic: Comic) {
        var bundle = Bundle()
        bundle.putInt("comicId", comic.id)
        Log.d("idprueba", comic.id.toString())
        navController()!!.navigate(R.id.action_comicFragment_to_detailComicFragment, bundle)
    }

    override fun onDetailCharacters(characters: Characters) {
        var bundle = Bundle()
        bundle.putInt("comicId", characters.id)
        Log.d("idprueba", characters.id.toString())
        navController()!!.navigate(R.id.action_comicFragment_to_detailComicFragment, bundle)
    }

    override fun onDetailCreators(creators: Creators) {
        var bundle = Bundle()
        bundle.putInt("comicId", creators.id)
        Log.d("idprueba", creators.id.toString())
        navController()!!.navigate(R.id.action_comicFragment_to_detailComicFragment, bundle)
    }

    fun isMutiple(numb: Double) {
        when {
            numb == 0.0 -> {
                comicViewModel.getCharacters()
                comicViewModel.liveDataCharacters.observe(this, recyclerCharacters)
                rvCharacters.visibility = View.VISIBLE
                rvCreators.visibility = View.GONE
                rvComic.visibility = View.GONE
            }
            numb.ResponseMultipleOf(3) -> {
                comicViewModel.getComic()
                comicViewModel.liveData.observe(this, recyclerComic)
                rvCharacters.visibility = View.GONE
                rvCreators.visibility = View.GONE
                rvComic.visibility = View.VISIBLE
            }
            numb.ResponseMultipleOf(5) -> {
                comicViewModel.getComic()
                comicViewModel.liveData.observe(this, recyclerComic)
                rvCharacters.visibility = View.GONE
                rvCreators.visibility = View.GONE
                rvComic.visibility = View.VISIBLE
            }
            numb.ResponseMultipleOf(7) -> {
                comicViewModel.getCreators()
                comicViewModel.liveDataCreators.observe(this, recyclerCreators)
                rvCharacters.visibility = View.GONE
                rvCreators.visibility = View.VISIBLE
                rvComic.visibility = View.GONE
            }
            numb.ResponseMultipleOf(11) -> {
                comicViewModel.getEvents()
                comicViewModel.liveData.observe(this, recyclerComic)
                rvCharacters.visibility = View.GONE
                rvCreators.visibility = View.GONE
                rvComic.visibility = View.VISIBLE
            }
            numb.ResponseMultipleOf(13) -> {
                comicViewModel.getSeries()
                comicViewModel.liveData.observe(this, recyclerComic)
                rvCharacters.visibility = View.GONE
                rvCreators.visibility = View.GONE
                rvComic.visibility = View.VISIBLE
            }
            numb.ResponseMultipleOf(17) -> {
                comicViewModel.getStories()
                comicViewModel.liveData.observe(this, recyclerComic)
                rvCharacters.visibility = View.GONE
                rvCreators.visibility = View.GONE
                rvComic.visibility = View.VISIBLE
            }
        }
    }

    fun Double.ResponseMultipleOf(value: Int): Boolean {
        return (this % value) == 0.0
    }

    override fun fragmentLayout(): Int = R.layout.fragment_comic
}