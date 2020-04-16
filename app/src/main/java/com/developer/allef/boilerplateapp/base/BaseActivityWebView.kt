package br.com.redcode.base.activities

import android.os.Build
import android.webkit.WebView
import br.com.redcode.base.utils.Constants
import com.developer.allef.boilerplateapp.base.BaseActivity
import com.developer.allef.boilerplateapp.extensions.*


abstract class BaseActivityWebView : BaseActivity() {

    private val titulo by lazy { intent.getStringExtra("titulo") ?: Constants.EMPTY_STRING }

    abstract val webView: WebView
    abstract val myUrl: String


    abstract fun handleWebView()

    fun load(htmlOrUrl: String?, isURL: Boolean = true) {
        htmlOrUrl.toLogcat()
        htmlOrUrl?.let {
            if (isURL) {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    it.openLinkInBrowser(this)
                    finish()
                } else {
                    loadUrl(it)
                }
            } else {
                loadHtml(it)
            }
        }
    }

    abstract fun loadUrl(url: String)
    abstract fun loadHtml(html: String)

    open fun processingURL(url: String) = "Processing URL: $url".toLogcat()

    override fun showProgress() {
        super.showProgress()
        webView.gone()
    }

    override fun hideProgress() {
        super.hideProgress()
        webView.visible()
    }


}
