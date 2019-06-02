package com.comic.universe.ui.view.detail.comicdetail

import androidx.lifecycle.Observer
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.repository.ComicRepository
import kotlinx.android.synthetic.main.fragment_detail_comic.*

class DetailComicFragment : BaseFragment() {

    lateinit var comicRepository: ComicRepository
    lateinit var detailViewModel: DetailViewModel
    var comicId : Int = 0

    override fun onFinishedViewLoad() {
        comicId = arguments!!.getInt("comicId", comicId)
        initializeUi()
    }

    private fun initializeUi() {
        comicRepository = ComicRepository(retrofit)
        detailViewModel = DetailViewModel(comicRepository)
        detailViewModel.getDetailComic(comicId)

        detailViewModel.liveDataDetailComic.observe(this, viewDetails)

    }

    fun initViewDetailSerie(comic: Comic){
        titleDetail.text = comic.title
    }

    var viewDetails = Observer<Comic> { comic ->
        initViewDetailSerie(comic)
    }

    override fun fragmentLayout(): Int = R.layout.fragment_detail_comic
}
