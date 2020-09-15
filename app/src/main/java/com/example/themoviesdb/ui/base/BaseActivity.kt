package com.example.themoviesdb.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.ui.utils.NetworkUtils
import dagger.android.AndroidInjection


abstract class BaseActivity : AppCompatActivity() {
    private val mProgressDialog: ProgressDialog? = null
    protected abstract fun initializeViewModel()
    abstract fun observeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initializeViewModel()
        observeViewModel()
    }

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
