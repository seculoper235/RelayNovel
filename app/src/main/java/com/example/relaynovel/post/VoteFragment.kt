package com.example.relaynovel.post

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.example.relaynovel.R
import com.example.relaynovel.databinding.VotePopupBinding

class VoteFragment: Fragment() {
    private var _binding: VotePopupBinding? = null
    private val binding get() = _binding!!
    private var goodCount = 0
    private var badCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = VotePopupBinding.inflate(inflater, container, false)
        val view = binding.root

        view.rootView.setOnClickListener {
            val viewPopup = AlertDialog.Builder(it.context)
                .setView(this.view)
                .setPositiveButton("확인") {
                        dialog, which ->
                    //

                    Toast.makeText(it.context.applicationContext, "투표 완료!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("취소") {
                        dialog, which ->
                    //
                }
                .create()

            viewPopup.show()
        }

        val goodBtn = view.findViewById<ToggleButton>(R.id.goodButton)
        val goodText = view.findViewById<TextView>(R.id.goodNum)
        val badBtn = view.findViewById<ToggleButton>(R.id.badButton)
        val badText = view.findViewById<TextView>(R.id.badNum)

        goodBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                goodCount += 1
                goodText.setText("$goodCount")
            }

            else {
                goodCount -= 1
                goodText.setText("$goodCount")
            }
        }

        badBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                badCount += 1
                badText.setText("$badCount")
            }

            else {
                badCount -= 1
                badText.setText("$badCount")
            }
        }

        return view
    }
}