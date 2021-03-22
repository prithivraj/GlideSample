package io.intercom.sdk

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.LibraryGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream

@GlideModule
class IntercomGlideModule : LibraryGlideModule() {
    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor {
            Log.d("glideExperiment", "sdk okhttp interceptor called")
            it.proceed(it.request())
        }
        .build()

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        Log.d("glideExperiment", "sdk registerComponents called")
        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(okHttpClient)
        )
    }
}
