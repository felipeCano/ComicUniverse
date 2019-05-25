package com.comic.universe.center

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comic.universe.control.model.local.Characters
import com.comic.universe.control.model.local.Comic
import com.comic.universe.control.model.local.Creators
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    val liveData = MutableLiveData<List<Comic>>()
    private val disposables = CompositeDisposable()
    val liveDataCharacters = MutableLiveData<List<Characters>>()
    val liveDataCreators = MutableLiveData<List<Creators>>()

    protected fun addComics(observable: Observable<List<Comic>>) {
        val disposables1: Disposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
            }
            .subscribe({
                liveData.postValue(it)
            }, {
                Log.d("holi", it.toString())
            })
        disposables.add(
            disposables1
        )
    }

    protected fun addCharacters(observable: Observable<List<Characters>>) {
        val disposables1: Disposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
            }
            .subscribe({
                liveDataCharacters.postValue(it)
            }, {
                Log.d("holi", it.toString())
            })
        disposables.add(
            disposables1
        )
    }

    protected fun addCreators(observable: Observable<List<Creators>>) {
        val disposables1: Disposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
            }
            .subscribe({
                liveDataCreators.postValue(it)
            }, {
                Log.d("holi", it.toString())
            })
        disposables.add(
            disposables1
        )
    }
}