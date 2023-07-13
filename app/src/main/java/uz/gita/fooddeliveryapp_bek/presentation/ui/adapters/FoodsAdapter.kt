package uz.gita.fooddeliveryapp_bek.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import uz.gita.fooddeliveryapp_bek.data.common.FoodData
import uz.gita.fooddeliveryapp_bek.databinding.ItemFoodBinding

class FoodsAdapter : Adapter<FoodsAdapter.ItemHolder>() {

    private var foodsList: List<FoodData> = ArrayList()

    fun setData(l: List<FoodData>){
        foodsList = l
        notifyDataSetChanged()
    }

    inner class ItemHolder(private val binding: ItemFoodBinding) :
        ViewHolder(binding.root) {

        fun bind() {
            binding.apply {
                txtTitle.text = foodsList[adapterPosition].title
                txtInfo.text = foodsList[adapterPosition].description
                txtPrice.text = "${foodsList[adapterPosition].price} so'm"

                val imgUrl = foodsList[adapterPosition].imgUrl

                Glide.with(binding.root.context).load(imgUrl).into(imgIcon)
            }
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

    override fun getItemCount() = foodsList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }
}