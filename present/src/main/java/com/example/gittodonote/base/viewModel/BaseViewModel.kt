package com.example.gittodonote.base.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gittodonote.util.FetchState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * 2023-05-03
 * pureum
 */
abstract class BaseViewModel : ViewModel() {

    //아마도 shared로 바꿔야할듯
    private val _state = MutableLiveData<Pair<Throwable, FetchState>>()
    val state: LiveData<Pair<Throwable, FetchState>>
        get() =  _state

    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        Log.e("TAG", "$throwable", )
        _state.postValue(Pair(throwable, FetchState.ERR))
//        when(throwable){
//
//        }
    }
}