package com.example.project_s_h_o_p

import ItemsAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList = findViewById<RecyclerView>(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "goose", "Tree", "Tree desc", "Tree text", 100))
        items.add(Item(2, "mug", "Tree", "Tree desc", "Tree text", 100))
        items.add(Item(3, "rekin", "Tree", "Tree desc", "Tree text", 100))

        itemsList.layoutManager = LinearLayoutManager(this)
        val itemsAdapter = ItemsAdapter(items, this)
        itemsList.adapter = itemsAdapter
        itemsAdapter.notifyDataSetChanged()

    }
}