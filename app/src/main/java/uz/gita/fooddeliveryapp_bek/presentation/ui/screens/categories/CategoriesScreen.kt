package uz.gita.fooddeliveryapp_bek.presentation.ui.screens.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.fooddeliveryapp_bek.R
import uz.gita.fooddeliveryapp_bek.databinding.ScreenCategoryBranchBinding
import uz.gita.fooddeliveryapp_bek.presentation.ui.adapters.CategoryBranchAdapter
import uz.gita.fooddeliveryapp_bek.utils.categoryBolimlar
import uz.gita.fooddeliveryapp_bek.utils.toast
import javax.inject.Inject

@AndroidEntryPoint
class CategoriesScreen : Fragment(R.layout.screen_category_branch) {

    private val binding by viewBinding(ScreenCategoryBranchBinding::bind)

    @Inject
    lateinit var adapter: CategoryBranchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setData(categoryBolimlar)

        adapter.setOnItemClickListener {
            toast(it.title)
        }

        binding.apply {
            recyclerCategories.layoutManager =
                GridLayoutManager(requireContext(), 3, RecyclerView.VERTICAL, false)
            recyclerCategories.adapter = adapter
        }

    }
}