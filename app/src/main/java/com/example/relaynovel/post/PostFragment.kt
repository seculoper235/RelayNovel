package com.example.relaynovel.post

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.relaynovel.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A fragment representing a list of Items.
 */
class PostFragment : DialogFragment() {
    private val postModel by viewModels<PostModel>()
    private var columnCount = 1
    private var itemList: MutableList<PostItem> = mutableListOf()
    private lateinit var recycler: RecyclerView

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
        // View를 뽑아옴
        val view = inflater.inflate(R.layout.fragment_post_list, container, false)

        recycler = view.findViewById(R.id.list)

        // create_btn의 클릭 이벤트 등록
        var create = view.rootView.findViewById<FloatingActionButton>(R.id.create_btn)
        create.setOnClickListener {
            showRegisterPopup()
        }

        return view
    }

    private fun showRegisterPopup() {
        var popup = layoutInflater.inflate(R.layout.register_popup, null)

        var postPopup = AlertDialog.Builder(this.context)
            .setView(popup)
            .setPositiveButton("저장") {
                dialog, which ->
                var titleText = popup.findViewById<EditText>(R.id.postTitle)
                var contentText = popup.findViewById<EditText>(R.id.postContent)
                var ownerText = popup.findViewById<EditText>(R.id.postOwner)
                val title = titleText.text.toString()
                val owner = ownerText.text.toString()
                val content = contentText.text.toString()

                itemList.add(PostItem(title, title, content, owner))
                val adapter = MyPostRecyclerViewAdapter(itemList)
                recycler.adapter = adapter
                adapter.notifyDataSetChanged()

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