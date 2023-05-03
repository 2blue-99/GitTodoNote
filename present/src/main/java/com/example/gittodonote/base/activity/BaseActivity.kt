package com.example.gittodonote.base.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * 2023-05-02
 * pureum
 */
abstract class BaseActivity<T: ViewDataBinding>(
    @LayoutRes val layoutRes: Int
): AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        initUI()
        initListener()
        initObserver()
    }

    abstract fun initUI()
    abstract fun initListener()
    abstract fun initObserver()

    protected fun showToast(message:String){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
    }
}