package com.team.ggzz

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.team.ggzz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val loadingSpinner = LoadingDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        init()
        initWebView()

        viewModel.url.observe(this) { url ->
            binding.mainWb.loadUrl(url)
        }
    }

    private fun init() {
        // viewModel
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        // binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        // loadingSpinner
        loadingSpinner.show(this)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        binding.mainWb.apply {
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    loadingSpinner.dialog?.dismiss()
                }
            }
            settings.javaScriptEnabled = true
            settings.userAgentString =
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"
            settings.textZoom = 100
            settings.setSupportZoom(false)

            addJavascriptInterface(
                WebViewInterface(this@MainActivity),
                "Android"
            )
        }
    }
}