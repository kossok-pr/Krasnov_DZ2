package com.example.android.krasnov_dz2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var photoView: ImageView = findViewById(R.id.photo_image_view)
        photoView.setImageURI(Uri.parse(intent.getStringExtra("uri")))

        var textView: TextView = findViewById(R.id.name_text_view)
        textView.text = intent.getStringExtra(Intent.EXTRA_TEXT)
    }
}
