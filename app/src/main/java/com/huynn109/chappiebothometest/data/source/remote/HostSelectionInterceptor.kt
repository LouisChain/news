package com.huynn109.chappiebothometest.data.source.remote

import okhttp3.HttpUrl
import java.io.IOException
import okhttp3.Interceptor
import timber.log.Timber
import java.net.URI


/** An interceptor that allows runtime changes to the URL hostname.  */

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HostSelectionInterceptor : Interceptor {
    @Volatile
    private var host: String? = "www.dropbox.com"
    private var port: Int = 80
    private var scheme: String? = "https"
    private var newUrl: String? = "https"

    /// http://54.38.94.124:86/api/
    fun setBaseUrl(baseUrl: String) {
        val uri = URI(baseUrl)
        this.newUrl = baseUrl
        host = uri.host
        scheme = uri.scheme
        port = uri.port
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        Timber.d("intercept $scheme $host $port")
        val newRequest = newUrl?.let {
            val httpUrl = HttpUrl.parse(newUrl)
//                chain.request().url().newBuilder()
//                .scheme(scheme)
//                .host(host)
//                .port(port)
//                .build()

            return@let chain.request().newBuilder()
                .url(httpUrl)
                .build()
        }
        if (newRequest == null) {
            Timber.e("newRequest is null")
        } else {
            Timber.e(newRequest.toString())
        }
        return chain.proceed(newRequest)
    }
}