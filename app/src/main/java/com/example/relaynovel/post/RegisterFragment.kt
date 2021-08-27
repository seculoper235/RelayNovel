package com.example.relaynovel.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.relaynovel.R
import com.example.relaynovel.databinding.RegisterPopupBinding

class RegisterFragment: Fragment() {
    private var _binding: RegisterPopupBinding? = null
    private val binding get() = _binding!!
    private var voteNumber = 2
    private lateinit var ownerName: String
    private lateinit var title: String
    private lateinit var content: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterPopupBinding.inflate(inflater, container, false)
        val view = binding.root
        val voteBar = binding.voteBar
        val voteNum = binding.voteNum

        voteBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (seekBar != null) {
                    voteNumber += seekBar.progress
                    voteNum.setText(voteNumber)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                voteNumber = voteNum.text.toString().toInt()
            }

        }
        )



        return view
    }
}