package io.intercom.glidesample

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import java.io.InputStream

@GlideModule
class MainGlideAppModule : AppGlideModule() {
    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor {
            Log.d("glideExperiment", "app okhttp interceptor called")
            it.proceed(it.request())
        }
        .build()

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions {
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
        }
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        Log.d("glideExperiment", "app registerComponents called")
        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(okHttpClient)
        )
    }
}
