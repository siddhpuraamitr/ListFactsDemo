package com.siddhpuraamitr.androiddemo.model

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.gson.annotations.Expose
import com.siddhpuraamitr.androiddemo.R

data class Rows(
    @Expose
    var title: String,
    @Expose
    var description: String,
    @Expose
    var imageHref: String
) : BaseObservable() {

    companion object {
        @BindingAdapter("loadImageHref")
        @JvmStatic
        fun loadImageHref(imageView: ImageView, imageURL: String?) {
            Glide.with(imageView.context)
                .load(imageURL)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }

    }

    var _title: String
        @Bindable get() = title
        set(value) {
            title = value
            notifyPropertyChanged(BR._title)
        }

    var _description: String
        @Bindable get() = description
        set(value) {
            description = value
            notifyPropertyChanged(BR._description)
        }


    var _imageHref: String
        @Bindable get() = imageHref
        set(value) {
            imageHref = value
            notifyPropertyChanged(BR._imageHref)
        }
}