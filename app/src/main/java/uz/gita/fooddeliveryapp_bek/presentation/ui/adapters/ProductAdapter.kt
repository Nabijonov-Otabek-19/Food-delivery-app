package uz.gita.fooddeliveryapp_bek.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import uz.gita.fooddeliveryapp_bek.data.common.ProductData
import uz.gita.fooddeliveryapp_bek.databinding.ItemFoodBinding
import javax.inject.Inject

class ProductAdapter @Inject constructor() : Adapter<ProductAdapter.ItemHolder>() {

    private var foodsList: List<ProductData> = ArrayList()

    fun setData(l: List<ProductData>) {
        foodsList = l
        notifyDataSetChanged()
    }

    private var clickListener: ((ProductData) -> Unit)? = null

    fun setClickListener(l: (ProductData) -> Unit) {
        clickListener = l
    }

    inner class ItemHolder(private val binding: ItemFoodBinding) :
        ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                clickListener?.invoke(foodsList[adapterPosition])
            }
        }

        fun bind() {
            binding.apply {
                txtTitle.text = foodsList[adapterPosition].title
                txtInfo.text = foodsList[adapterPosition].description
                txtPrice.text = "${foodsList[adapterPosition].price} sum"

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