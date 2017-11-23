package com.example.android.krasnov_dz2

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var name: Editable

    val REQUEST_IMAGE_CAPTURE = 1

    //lateinit var photoPath: String

    //lateinit var photoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEdit: EditText = findViewById(R.id.name_edit_text)
        name = nameEdit.text
        var takePhotoBtn: Button = findViewById(R.id.take_photo_btn)

        takePhotoBtn.setOnClickListener(View.OnClickListener {
            if (!name.isEmpty()) {
                takePhoto()
            } else Toast.makeText(applicationContext, R.string.enter_name_toast, Toast.LENGTH_SHORT).show()
        })
    }

    fun takePhoto() {
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            var extras: Bundle = data.extras
            //var imageBitmap: Bitmap = extras.get("data") as Bitmap
            //photoImageView.setImageBitmap(imageBitmap)
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtras(extras)
            startActivity(intent)
        }
    }

    /*fun createImageFile(): File {
        var timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var imageFileName = "JPEG_" + timeStamp + "_"
        var storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var image: File = File.createTempFile(imageFileName, ".jpg", storageDir)
        photoPath = image.absolutePath
        return image
    }*/
}
