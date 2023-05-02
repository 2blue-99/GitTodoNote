package com.example.gittodonote

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * 2023-05-01
 * pureum
 */
class LoginViewModel :ViewModel(){

    private var loginStateKey=""

    private val _loginState = MutableSharedFlow<LoginState>()
    val loginState = _loginState.asSharedFlow()
    fun changeLoginState(state:LoginState){
        viewModelScope.launch{
            _loginState.emit(state)
        }
    }

    fun compareLoginStateKey(state:String):Boolean = loginStateKey == state

    fun makeUri(state:String):Uri{
        loginStateKey = Random(32).toString()
        return Uri.Builder()
            .scheme("https")
            .authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter(state, loginStateKey)
            .appendQueryParameter("scope", "repo, read:user")
            .appendQueryParameter("client_id", "c9432555fcb27ad00349")
            .build()
    }

    fun getAccessToken(code:String){
        //여기서 뭘하는걸까?
        updateAccessToken(accessToken = code)
    }

    private fun updateAccessToken(accessToken:String){
        //하나로 뭉쳐보자
        viewModelScope.launch(Dispatchers.IO){
            _loginState.emit(
                //if 만약 preferenceManager 에서 정상적으로 토큰이 업뎃 됐다면,
                LoginState.SUCCESS
                //else LoginState.SUCCESS
            )
        }
    }




}