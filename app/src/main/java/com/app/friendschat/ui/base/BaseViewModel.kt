package com.app.friendschat.ui.base

import androidx.lifecycle.ViewModel
import com.app.friendschat.data.model.response.ErrorResponse
import com.app.friendschat.data.scheduler.ISchedulerProvider
import com.app.friendschat.utils.RxProgressBar
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

open class BaseViewModel : ViewModel() {
    lateinit var fragmentCallback: IFragmentCallback
    lateinit var navigation: Navigators
    lateinit var scheduler: ISchedulerProvider
    private val mDisposable = CompositeDisposable()
    lateinit var io: Scheduler
    lateinit var ui: Scheduler
    lateinit var computation: Scheduler
    lateinit var progressBar: RxProgressBar

    val trackingError: PublishSubject<ErrorResponse> by lazy {
        PublishSubject.create<ErrorResponse>()
    }

    fun initData(scheduler: ISchedulerProvider) {
        this.scheduler = scheduler
        io = scheduler.io
        ui = scheduler.ui
        computation = scheduler.computation
        progressBar = RxProgressBar(scheduler)
    }

    fun Disposable.addDisposable() {
        mDisposable.add(this)
    }

    override fun onCleared() {
        mDisposable.clear()
        super.onCleared()
    }

    fun onDestroyView() {
        progressBar.reset()
        mDisposable.clear()
    }
}