package io.intercom.sdk

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class IntercomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intercom)
        val image = findViewById<ImageView>(R.id.imageView)

        Glide.with(this)
            .load("https://i.imgur.com/BF7A1NZ.jpg").into(image)
    }
}
