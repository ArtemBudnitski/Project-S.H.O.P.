package com.example.project_s_h_o_p

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val itemTitle : TextView = findViewById(R.id.item_title)
        val itemDesc : TextView = findViewById(R.id.item_desc)
        val itemImage : ImageView = findViewById(R.id.item_image)

        itemTitle.text = intent.getStringExtra("itemTitle")
        itemDesc.text = intent.getStringExtra("itemDesc")
        var  imageId = resources.getIdentifier(intent.getStringExtra("itemImage"), "drawable", packageName)
        itemImage.setImageResource(imageId)



    }
}