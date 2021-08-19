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

    /* onCreateViewHolder 란?
    * ViewHolder.class와 ViewHolder.xml을 바인딩
    * (프래그먼트의 onCreateView()와 동일함)
    *  */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    /* onBindViewHolder 란?
    * 주어진 ViewHolder(Item_View)와 Item 데이터를 바인딩
    * ViewHolder의 bind() 메소드를 통해 바인딩 한다
    *  */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }

    // 총 Item 데이터의 개수
    override fun getItemCount(): Int = values.size

    /* ViewHolder란?
    * Item_View와 Item 데이터를 바인딩하는 역할을 한다.
    *  */
    inner class ViewHolder(binding: FragmentPostBinding) : RecyclerView.ViewHolder(binding.root) {
        // 데이터 바인딩을 통해 Item_View의 View들을 가져옴
        val novelName: EditText = binding.NovelName
        val owner: TextView = binding.Owner

        // View와 Item 연결
        fun bind(item: PlaceholderItem) {
            novelName.setText(item.id)
            owner.text = item.owner
        }

        override fun toString(): String {
            return super.toString() + " '" + novelName.text + "'"
        }
    }

}