package com.example.myhouse.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myhouse.R
import com.example.myhouse.app.App
import com.example.myhouse.databinding.ItemDoorBinding
import com.example.myhouse.model.realm.RealmManager
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.view.clicklistners.DoorOnListItemClickListner


class DoorsAdapter(private var itemClickListenerDoor: DoorOnListItemClickListner): RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>()  {

    private lateinit var realmManager: RealmManager
    private var doors: List<DoorDTO> = listOf()

    fun setData(data: List<DoorDTO>) {
        doors = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        val binding: ItemDoorBinding =  ItemDoorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoorsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(doors[position])
    }

    override fun getItemCount() = doors.size

    inner class DoorsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(door: DoorDTO){
            ItemDoorBinding.bind(itemView).apply {
                doorItemName.text = door.name
                doorItemName.setOnClickListener {
                    if (doorItemImageView.isVisible) doorItemImageView.visibility = View.GONE
                    else doorItemImageView.visibility = View.VISIBLE
                }
                doorItemImageView.setOnClickListener {
                    itemClickListenerDoor.onItemClickDoor(door)
                }
                Glide
                    .with(App.applicationContext())
                    .load(door.snapshot)
                    .placeholder(R.drawable.photo_unavailable)
                    .error(R.drawable.photo_unavailable)
                    .into(doorItemImageView)
            }
        }
    }
}