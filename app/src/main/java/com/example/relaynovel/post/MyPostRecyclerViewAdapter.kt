package com.example.relaynovel.post

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.relaynovel.databinding.FragmentPostBinding
import com.example.relaynovel.post.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPostRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyPostRecyclerViewAdapter.ViewHolder>() {

    // ViewHolder.java와 ViewHolder.xml을 바인딩
    // (프래그먼트의 onCreateView()와 동일함)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }


    // 주어진 ViewHolder(Item_View)와 Item 데이터를 바인딩
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.novelName.setText(item.id)
        holder.owner.text = item.content
    }

    // 총 Item 데이터의 개수
    override fun getItemCount(): Int = values.size

    // Item_View를 바인딩해서 Item 데이터를 가져옴
    inner class ViewHolder(binding: FragmentPostBinding) : RecyclerView.ViewHolder(binding.root) {
        val novelName: EditText = binding.NovelName
        val owner: TextView = binding.Owner

        override fun toString(): String {
            return super.toString() + " '" + novelName.text + "'"
        }
    }

}