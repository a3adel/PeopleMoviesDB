package com.example.themoviesdb.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesdb.R
import com.example.themoviesdb.data.models.PersonProfile
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image.view.*

class ImagesAdapter : RecyclerView.Adapter<ImageViewHolder>() {
    lateinit var images:ArrayList<PersonProfile>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Picasso.get().load(images.get(position).getImage()).into(holder.itemView.person_image_item)
    }
}

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
