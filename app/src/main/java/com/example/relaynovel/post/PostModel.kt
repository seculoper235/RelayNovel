package com.example.relaynovel.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostModel: ViewModel() {
    var itemList: MutableLiveData<MutableList<PostItem>> = MutableLiveData(mutableListOf())
        get() { return field }
        set(item) {
            field = item
        }
}