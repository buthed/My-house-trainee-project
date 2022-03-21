package com.example.myhouse.view.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse.databinding.ItemDoorsBinding
import com.example.myhouse.model.DataDoors


class DoorsAdapter(
    private var onListItemClickListner: OnListItemClickListner,
    private var doors: List<DataDoors>
): RecyclerView.Adapter<DoorsAdapter.DoorsViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        val binding: ItemDoorsBinding =  ItemDoorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoorsViewHolder(binding.root)
    }




    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        (holder as DoorsViewHolder).bind(doors[position])
    }

    override fun getItemCount() = doors.size

    inner class DoorsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(dataDoors: DataDoors){
            ItemDoorsBinding.bind(itemView).apply {
                doorName.text = dataDoors.name
                doorRoom.text = dataDoors.room
            }
        }
    }

}