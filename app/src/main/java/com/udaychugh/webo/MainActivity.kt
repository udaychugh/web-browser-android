package com.udaychugh.webo

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.loadUrl("http://www.google.com")
        webview.settings.javaScriptEnabled = true
        webview.canGoBack()
        webview.webViewClient = WebClient(this)

        search_btn.setOnClickListener {
            val URL = url_text.text.toString()
            webview.loadUrl(URL)
        }

        //now we will add the script to return back
        return_btn.setOnClickListener {
            webview.goBack()
        }





    }


    class WebClient internal constructor(private val activity: Activity):WebViewClient(){
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

    }
}