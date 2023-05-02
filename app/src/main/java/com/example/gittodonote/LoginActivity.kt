package com.example.gittodonote

import android.content.Intent
import android.provider.SyncStateContract
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.gittodonote.databinding.ActivityLoginBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    companion object {
        const val state = "state"
    }

    private val loginViewModel: LoginViewModel by viewModels()

    override fun initUI() {
        binding.button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, loginViewModel.makeUri(state))
            startActivity(intent)
        }
    }

    override fun initListener() {
        lifecycleScope.launch {
            loginViewModel.loginState.collectLatest {
                Log.e("TAG", "loginState: $it",)
                when (it) {
                    LoginState.SUCCESS -> {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }
                    LoginState.FALSE -> {
                        showToast("로그인 실패")
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume: ",)
        intent?.data?.let {
            val code = it.getQueryParameter("code")
            val state = it.getQueryParameter("state")
            Log.e("TAG", "onResume: $code,  $state",)
            if (code != null && state != null && loginViewModel.compareLoginStateKey(state)) {
                loginViewModel.getAccessToken(code)
//                loginViewModel.changeLoginState(LoginState.SUCCESS)
            } else {
//                loginViewModel.changeLoginState(LoginState.FALSE)

            }
        }
    }




}
    //이건 왜?
//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//        Log.e("TAG", "onNewIntent: in", )
//        intent?.data?.let {
//            Log.e("TAG", "onNewIntent: $it", )
//            val code = it.getQueryParameter("code");
////            val state = it.getQueryParameter()
//
//        }
//    }



//        var intent = Intent(Intent.ACTION_VIEW, loginUri).apply {
//            data = loginUri
//        }
//        startActivity(intent)

//                CustomTabsIntent.Builder().build().also {
//            it.launchUrl(this, loginUri)
//        }\

