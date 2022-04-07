package com.example.myhouse.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myhouse.R
import com.example.myhouse.app.App
import com.example.myhouse.databinding.ItemCameraBinding
import com.example.myhouse.model.rest.rest_entites.CameraDTO

class CamerasAdapter(): RecyclerView.Adapter<CamerasAdapter.CamerasViewHolder>() {

    private var cameras: List<CameraDTO> = listOf()

    fun setData(data: List<CameraDTO>) {
        cameras = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamerasViewHolder {
        val binding: ItemCameraBinding =  ItemCameraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CamerasViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CamerasViewHolder, position: Int) {
        holder.bind(cameras[position])
    }

    override fun getItemCount() = cameras.size

    inner class CamerasViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(camera: CameraDTO){
            ItemCameraBinding.bind(itemView).apply {
                cameraItemName.text = camera.name
                if (camera.rec) cameraItemRec.visibility = View.VISIBLE
                if (camera.favorites) cameraItemFavorite.setChecked(true)
                //TODO Переделать на Glide и поставить заглушку
                Glide
                    .with(App.applicationContext())
                    .load(camera.snapshot)
                    .placeholder(R.drawable.photo_unavailable)
                    .error(R.drawable.photo_unavailable)
                    .into(cameraItemImageView)
            }
        }
    }
}