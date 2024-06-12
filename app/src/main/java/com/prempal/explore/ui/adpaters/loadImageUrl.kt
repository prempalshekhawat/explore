package com.prempal.explore.ui.adpaters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImageUrl(imageView: ShapeableImageView, imageUrl: String?) {
    imageUrl?.let {
        Picasso.get().load(it).into(imageView)
    }
}