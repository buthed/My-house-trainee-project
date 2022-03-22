package com.example.myhouse.view.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.databinding.ItemDoorsBinding
import com.example.myhouse.model.Door


class DoorsAdapter(
//    private var onListItemClickListner: OnListItemClickListner,
//    private var doors: List<Door>
): RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>()  {

    private var doors: List<Door> = listOf()

    fun setData(data: List<Door>) {
        doors = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        val binding: ItemDoorsBinding =  ItemDoorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoorsViewHolder(binding.root)
    }




    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        (holder as DoorsViewHolder).bind(doors[position])
    }

    override fun getItemCount() = doors.size

    inner class DoorsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(door: Door){
            ItemDoorsBinding.bind(itemView).apply {
                doorName.text = door.name
                doorRoom.text = door.room
            }
        }
    }

}