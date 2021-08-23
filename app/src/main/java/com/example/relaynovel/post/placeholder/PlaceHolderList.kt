package com.example.relaynovel.post.placeholder

object PlaceHolderList {
    @JvmStatic
    val ITEMLIST = ArrayList<PlaceHolderItem>()

    data class PlaceHolderItem(val id: String, val owner: String) {
        override fun toString(): String {
            return "Id: [$id], Owner: [$owner]"
        }
    }
}