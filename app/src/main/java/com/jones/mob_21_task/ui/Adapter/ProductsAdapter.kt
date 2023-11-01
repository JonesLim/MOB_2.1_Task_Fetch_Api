package com.jones.mob_21_task.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jones.mob_21_task.data.model.Product
import com.jones.mob_21_task.databinding.ItemLayoutProductBinding


class ProductsAdapter(
    private var products: List<Product>,


    ) : RecyclerView.Adapter<ProductsAdapter.ProductItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutProductBinding.inflate(inflater, parent, false)
        return ProductItemViewHolder(binding)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    fun setProducts(items: List<Product>) {
        products = items
        notifyDataSetChanged()
    }

    inner class ProductItemViewHolder(private val binding: ItemLayoutProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.run {

                tvTitle.text = product.title
                tvCate.text = "Category: ${product.category}"
                tvDesc.text = product.description
                tvPrice.text = "$ ${product.price.toString()}"

                val imageView: ImageView = imImage
                Glide.with(imageView)
                    .load(product.images.firstOrNull())
                    .into(imageView)

            }
        }
    }
}

