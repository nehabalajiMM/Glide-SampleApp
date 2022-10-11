package com.example.glide_sampleapp // ktlint-disable package-name

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation
import jp.wasabeef.glide.transformations.GrayscaleTransformation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv1 = findViewById<ImageView>(R.id.iv1)
        val iv2 = findViewById<ImageView>(R.id.iv2)
        val iv3 = findViewById<ImageView>(R.id.iv3)
        val iv4 = findViewById<ImageView>(R.id.iv4)
        val iv5 = findViewById<ImageView>(R.id.iv5)
        val iv6 = findViewById<ImageView>(R.id.iv6)
        val iv7 = findViewById<ImageView>(R.id.iv7)
        val iv8 = findViewById<ImageView>(R.id.iv8)
        val iv9 = findViewById<ImageView>(R.id.iv9)
        val iv10 = findViewById<ImageView>(R.id.iv10)
        val iv11 = findViewById<ImageView>(R.id.iv11)
        val iv12 = findViewById<ImageView>(R.id.iv12)

        // Basic usage
        Glide.with(applicationContext)
            .load("https://picsum.photos/id/237/200")
            .into(iv1)

        // Resizing
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .override(500)
            .into(iv2)

        // placeholder and error images
        Glide.with(this)
            .load("htttps://picksum.photos/id/237/200/300")
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.imagenotfound)
            .into(iv3)

        // cropping images
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .centerCrop()
            .into(iv4)

        Glide.with(this)
            .load("https://picsum.photos/id/237/600/400")
            .fitCenter() // scale to fit entire image within ImageView
            .into(iv5)

        // Loading errors
        Glide.with(this)
            .load("htttps://picsum.photos/id/237/200")
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.imagenotfound)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("TAG", "Error loading image", e)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(iv6)

        // Transformations - Rounded corner
        val radius = 30
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .centerCrop() // scale image to fill the entire ImageView
            .transform(RoundedCorners(radius))
            .into(iv7)

        // Transformations - Circle crop
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .transform(CircleCrop())
            .into(iv8)

        // Transformation - circle crop with border
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .transform(CropCircleWithBorderTransformation())
            .into(iv9)

        // Transformations - Effect(Blur)
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .transform(BlurTransformation())
            .into(iv10)

        // Transformation - Grayscale
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .transform(GrayscaleTransformation())
            .into(iv11)

        // Multiple transformations
        Glide.with(this)
            .load("https://picsum.photos/id/237/200")
            .transform(MultiTransformation(BlurTransformation(25), CircleCrop()))
            .into(iv12)
    }
}
