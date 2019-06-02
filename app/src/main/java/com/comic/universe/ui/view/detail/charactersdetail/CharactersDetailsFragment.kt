package com.comic.universe.ui.view.detail.charactersdetail

import androidx.lifecycle.Observer
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.model.local.Characters
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.repository.ComicRepository
import com.comic.universe.ui.view.detail.comicdetail.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_comic.*

class CharactersDetailsFragment  : BaseFragment() {

    lateinit var comicRepository: ComicRepository
    lateinit var detailViewModel: CharactersDetailViewModel
    var comicId : Int = 0

    override fun onFinishedViewLoad() {
        comicId = arguments!!.getInt("comicId", comicId)
        initializeUi()
    }

    private fun initializeUi() {
        comicRepository = ComicRepository(retrofit)
        detailViewModel = CharactersDetailViewModel(comicRepository)
        detailViewModel.getDetailCharacters(comicId)

        detailViewModel.liveDataDetailCharacters.observe(this, viewDetails)

    }

    fun initViewDetailSerie(characters: Characters){
        titleDetail.text = characters.name
    }

    var viewDetails = Observer<Characters> { characters ->
        initViewDetailSerie(characters)
    }

    override fun fragmentLayout(): Int = R.layout.fragment_detail_comic
}
