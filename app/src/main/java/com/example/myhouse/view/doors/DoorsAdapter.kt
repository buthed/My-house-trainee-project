package com.example.myhouse.view.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.databinding.ItemDoorsBinding
import com.example.myhouse.model.realm.RealmOperations
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.squareup.picasso.Picasso


class DoorsAdapter(private var itemClickListener: OnListItemClickListner): RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>()  {

    private lateinit var realmOperations: RealmOperations
    private var doors: List<DoorDTO> = listOf()

    fun setData(data: List<DoorDTO>) {
        doors = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        val binding: ItemDoorsBinding =  ItemDoorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoorsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(doors[position])
    }

    override fun getItemCount() = doors.size

    inner class DoorsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(door: DoorDTO){
            ItemDoorsBinding.bind(itemView).apply {
                doorName.text = door.name
                doorName.setOnClickListener {
                    if (doorsItemImageView.isVisible) doorsItemImageView.visibility = View.GONE
                    else doorsItemImageView.visibility = View.VISIBLE
                }
                doorsItemImageView.setOnClickListener {
                    itemClickListener.onItemClick(door)
                }
                if (door.snapshot.isNullOrBlank()) {
                    val urlSnapshot: String = "https://png.pngtree.com/png-vector/20190820/ourmid/pngtree-no-image-vector-illustration-isolated-png-image_1694547.jpg"
                    Picasso.get().load(urlSnapshot).into(doorsItemImageView)
                } else {
                    val urlSnapshot: String = door.snapshot
                    Picasso.get().load(urlSnapshot).into(doorsItemImageView)
                }

                itemView.setOnClickListener{

                }
            }
        }
    }
}