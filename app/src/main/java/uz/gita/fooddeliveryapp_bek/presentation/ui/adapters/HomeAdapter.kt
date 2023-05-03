package uz.gita.fooddeliveryapp_bek.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.fooddeliveryapp_bek.databinding.ItemFoodBinding

class HomeAdapter : Adapter<HomeAdapter.ItemHolder>() {

    inner class ItemHolder(private val binding: ItemFoodBinding) :
        ViewHolder(binding.root) {

        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }
}