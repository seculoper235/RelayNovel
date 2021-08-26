package com.example.relaynovel.post

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.relaynovel.R
import com.example.relaynovel.databinding.FragmentPostBinding
import com.example.relaynovel.databinding.VotePopupBinding


class MyPostRecyclerViewAdapter(
    private val values: MutableList<PostItem>
) : RecyclerView.Adapter<MyPostRecyclerViewAdapter.ViewHolder>() {

    private lateinit var voteBinding: VotePopupBinding
    /* onCreateViewHolder 란?
    * ViewHolder.class와 ViewHolder.xml을 바인딩
    * (프래그먼트의 onCreateView()와 동일함)
    *  */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        voteBinding = VotePopupBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

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
        var value = values[position]
        holder.bind(value)

        holder.itemView.setOnClickListener {
            showPopup(holder)
        }


    }

    fun showPopup(holder: ViewHolder) {
        val viewPopup = AlertDialog.Builder(holder.itemView.context)
            .setView(R.layout.vote_popup)
            .setPositiveButton("확인") {
                    dialog, which ->
                //

                Toast.makeText(holder.itemView.context.applicationContext, "투표 완료!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("취소") {
                    dialog, which ->
                //
            }
            .create()

        viewPopup.show()
    }

    // 총 Item 데이터의 개수
    override fun getItemCount(): Int = values.size

    /* ViewHolder란?
    * Item_View와 Item 데이터를 바인딩하는 역할을 한다.
    *  */
    inner class ViewHolder(binding: FragmentPostBinding) : RecyclerView.ViewHolder(binding.root) {
        // 데이터 바인딩을 통해 Item_View의 View들을 가져옴
        val novelName: TextView = binding.NovelName
        val owner: TextView = binding.Owner

        // View와 Item 연결
        fun bind(item: PostItem) {
            novelName.text = item.title
            owner.text = item.owner
        }

        override fun toString(): String {
            return super.toString() + " '" + novelName.text + "'"
        }
    }
}