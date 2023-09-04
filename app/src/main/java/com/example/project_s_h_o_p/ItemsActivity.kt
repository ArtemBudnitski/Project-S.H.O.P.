package com.example.project_s_h_o_p

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList = findViewById<RecyclerView>(R.id.itemsList)
        val items = arrayListOf<Item>()
        items.add(Item(1, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg", "Tree", "Tree desc", "Tree text", 100))
        items.add(Item(2, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg", "Tree", "Tree desc", "Tree text", 100))
        items.add(Item(3, "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg", "Tree", "Tree desc", "Tree text", 100))
    }
}