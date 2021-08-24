package com.example.relaynovel.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostModel: ViewModel() {
    private val itemList: MutableLiveData<List<PostItem>> by lazy {
        MutableLiveData<List<PostItem>>().also {
            loadItemList()
        }
    }

    @JvmName("getItemList1")
    fun getItemList(): MutableLiveData<List<PostItem>> {
        return itemList
    }

    private fun loadItemList() {
        // TODO 아이템 리스트를 가져오는 과정 구현
    }
}