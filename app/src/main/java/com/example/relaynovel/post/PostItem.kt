package com.example.relaynovel.post

data class PostItem(val id: String, val title: String, val content: String, val owner: String) {
    override fun toString(): String = content
}
