package com.example.relaynovel.post

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.example.relaynovel.R
import com.example.relaynovel.post.placeholder.PlaceholderContent
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A fragment representing a list of Items.
 */
class PostFragment : Fragment() {

    private var columnCount = 1

    // 액티비티의 호출을 받아 프래그먼트가 생성됨
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    // 프래그먼트.java와 프래그먼트.xml을 연결
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_post_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyPostRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }

        // create_btn의 클릭 이벤트 등록
        var create = view.rootView.findViewById<FloatingActionButton>(R.id.create_btn)
        create.setOnClickListener {
            showRegisterPopup()
        }

        return view
    }

    fun showRegisterPopup() {
        // TODO: post를 등록하기 위한 레이아웃 제작할 것!
        var popup = layoutInflater.inflate(R.layout.register_popup, null)

        var postPopup = AlertDialog.Builder(this.context)
            .setView(popup)
            .setPositiveButton("저장") {
                dialog, which ->
                Toast.makeText(context?.applicationContext, "저장 완료!", Toast.LENGTH_SHORT).show()
            }
            .create()

        postPopup.show()
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            PostFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}