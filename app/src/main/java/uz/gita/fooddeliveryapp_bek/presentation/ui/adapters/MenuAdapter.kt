package uz.gita.fooddeliveryapp_bek.presentation.ui.adapters

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.fooddeliveryapp_bek.data.common.MenuData
import uz.gita.fooddeliveryapp_bek.databinding.ItemBolimBinding
import javax.inject.Inject

class MenuAdapter @Inject constructor() : Adapter<MenuAdapter.ItemHolder>() {

    private var list: List<MenuData> = ArrayList()

    fun setData(l: List<MenuData>) {
        list = l
        notifyDataSetChanged()
    }

    private var onItemClickListener: ((MenuData) -> Unit)? = null

    fun setOnItemClickListener(l: (MenuData) -> Unit) {
        onItemClickListener = l
    }

    inner class ItemHolder(private val binding: ItemBolimBinding) :
        ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(list[adapterPosition])
            }
        }

        fun bind() {
            binding.apply {
                val data = list[adapterPosition]
                val cardColor = ContextCompat.getColor(binding.root.context, data.color)
                btnCategory.setCardBackgroundColor(cardColor)
                imgIcon.setImageResource(data.icon)

                if (data.tintColor != 0) {
                    val tintColor = ContextCompat.getColor(binding.root.context, data.tintColor)
                    imgIcon.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
                }
                txtTitle.text = data.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemBolimBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }
}