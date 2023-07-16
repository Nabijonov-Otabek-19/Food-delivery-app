package uz.gita.fooddeliveryapp_bek.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.fooddeliveryapp_bek.data.common.ProductData
import uz.gita.fooddeliveryapp_bek.databinding.CartItemBinding
import javax.inject.Inject

class CartAdapter @Inject constructor() : RecyclerView.Adapter<CartAdapter.ItemHolder>() {

    private var productList: List<ProductData> = ArrayList()

    fun setData(l: List<ProductData>) {
        productList = l
        notifyDataSetChanged()
    }

    private var clickListener: ((ProductData) -> Unit)? = null

    fun setClickListener(l: (ProductData) -> Unit) {
        clickListener = l
    }

    inner class ItemHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnRemove.setOnClickListener {
                clickListener?.invoke(productList[adapterPosition])
                notifyItemChanged(adapterPosition)
            }
        }

        fun bind() {
            binding.apply {
                val data = productList[adapterPosition]
                txtPrice.text = (data.price * data.cart_count).toString()
                txtTitle.text = data.title
                txtCount.text = data.cart_count.toString()
                Glide.with(binding.root.context).load(data.imgUrl).into(imgProduct)

                btnPlus.setOnClickListener {
                    data.cart_count++
                    notifyItemChanged(adapterPosition)
                }

                btnMinus.setOnClickListener {
                    if (data.cart_count - 1 != 0) {
                        data.cart_count--
                        notifyItemChanged(adapterPosition)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = productList.size
}