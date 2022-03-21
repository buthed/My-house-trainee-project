package com.example.myhouse.view.cameras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.databinding.ItemCameraBinding
import com.example.myhouse.model.Camera
import com.squareup.picasso.Picasso

class CamerasAdapter(private val onListItemClickListner: OnListItemClickListner,
                     private var cameras: List<Camera>
                      ): RecyclerView.Adapter<CamerasAdapter.CamerasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamerasViewHolder {
        val binding: ItemCameraBinding =  ItemCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CamerasViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CamerasViewHolder, position: Int) {
        (holder as CamerasViewHolder).bind(cameras[position])
    }

    override fun getItemCount() = cameras.size

    inner class CamerasViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(camera: Camera){
            ItemCameraBinding.bind(itemView).apply {
                cameraItemName.text = camera.name
                itemView.setOnClickListener{
                    onListItemClickListner.onItemClick(camera)
                }
                if (camera.rec) cameraItemRec.visibility = View.VISIBLE
                if (camera.favorites) cameraItemFavorite.setChecked(true)
                val urlSnapshot: String = camera.snapshot       //TODO Picasso
                Picasso.get().load(urlSnapshot).into(cameraItemImageView)

            }
        }
    }

}