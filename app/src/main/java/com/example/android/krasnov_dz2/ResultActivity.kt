package com.example.android.krasnov_dz2

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var photoView: ImageView = findViewById(R.id.photo_image_view)
        var extras: Bundle = intent.extras
        var imageBitmap: Bitmap = extras.get("data") as Bitmap
        photoView.setImageBitmap(imageBitmap)
    }
}
