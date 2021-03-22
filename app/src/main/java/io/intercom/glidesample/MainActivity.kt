package io.intercom.glidesample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.intercom.sdk.IntercomActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this).load("https://i.imgur.com/XqhVAA7.gif").into(imageView)
        findViewById<Button>(R.id.startIntercom).setOnClickListener {
            startActivity(Intent(this, IntercomActivity::class.java))
        }
    }
}
