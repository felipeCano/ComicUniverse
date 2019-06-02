package com.comic.universe.ui.view.detail.eventsdetail

import androidx.lifecycle.Observer
import com.comic.universe.R
import com.comic.universe.center.BaseFragment
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.repository.ComicRepository
import com.comic.universe.ui.view.detail.comicdetail.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_comic.*

class EventsDetailFragment : BaseFragment() {

    lateinit var comicRepository: ComicRepository
    lateinit var detailViewModel: EventsDetailViewModel
    var comicId : Int = 0

    override fun onFinishedViewLoad() {
        comicId = arguments!!.getInt("comicId", comicId)
        initializeUi()
    }

    private fun initializeUi() {
        comicRepository = ComicRepository(retrofit)
        detailViewModel = EventsDetailViewModel(comicRepository)
        detailViewModel.getDetailEvents(comicId)

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
