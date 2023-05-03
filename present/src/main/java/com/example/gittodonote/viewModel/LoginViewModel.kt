package com.example.gittodonote.viewModel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.RetrofitUseCase
import com.example.gittodonote.base.viewModel.BaseViewModel
import com.example.gittodonote.util.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

/**
 * 2023-05-01
 * pureum
 */
@HiltViewModel
class LoginViewModel @Inject constructor (
    private val useCase: RetrofitUseCase
    ): BaseViewModel() {

    init {
        Log.e("TAG", "viewModel 생성!: ", )
    }

    private var loginStateKey=""
    private val _loginState = MutableSharedFlow<LoginState>()
    val loginState = _loginState.asSharedFlow()
    fun changeLoginState(state: LoginState){
        viewModelScope.launch{
            _loginState.emit(state)
        }
    }

    fun compareLoginStateKey(state:String):Boolean {
        var gap = loginStateKey == state
        Log.e("TAG", "state: $state", )
        Log.e("TAG", "loginStateKey: $loginStateKey", )
        Log.e("TAG", "compareLoginStateKey: $gap", )
        return gap
    }

    fun makeUri(state:String):Uri{
        loginStateKey = (1..32).random().toString()
        Log.e("TAG", "loginStateKey: $loginStateKey", )
        var gap = Uri.Builder()
            .scheme("https")
            .authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter(state, loginStateKey)
            .appendQueryParameter("scope", "repo, read:user")
            .appendQueryParameter("client_id", "c9432555fcb27ad00349")
            .build()
        Log.e("TAG", "makeUri: $gap", )
        return gap
    }

    fun getAccessToken(code:String){
        //여기서 뭘하는걸까?
        updateAccessToken(code = code)
    }

    private fun updateAccessToken(code:String){
        //하나로 뭉쳐보자
        viewModelScope.launch(Dispatchers.IO+exceptionHandler){
            var res = useCase.getAccessTokenUseCase(code)
            Log.e("TAG", "response: $res", )
            _loginState.emit(
                LoginState.SUCCESS
                //if 만약 preferenceManager 에서 정상적으로 토큰이 업뎃 됐다면,
                //else LoginState.SUCCESS
            )
        }
    }




}