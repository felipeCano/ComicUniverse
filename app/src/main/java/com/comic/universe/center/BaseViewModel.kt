package com.comic.universe.center

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comic.universe.control.model.local.Comic
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    val liveData = MutableLiveData<List<Comic>>()
    private val disposables = CompositeDisposable()

    protected fun  addDisposable(observable: Observable<List<Comic>>){
        val disposables1 : Disposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
            }
            .subscribe ({
                liveData.postValue(it)
            },{
                Log.d("holi",it.toString())
            })
        disposables.add(
            disposables1
        )
    }
}