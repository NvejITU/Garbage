package dk.itu.garbagesorting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dk.itu.garbagesorting.AddItem

class GarbageSorting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garbage_sorting)
        ItemsDB.initialize()
        itemsDB = ItemsDB.get()

        //Text Fields
        val input = findViewById<TextView>(R.id.what_text)
        val findPlace = findViewById<Button>(R.id.where_button)
        findPlace.setOnClickListener {
            val whatS = input.text.toString().trim { it <= ' ' }
            val place = itemsDB?.searchForItem(whatS)
            input.text = "$whatS should be placed in: $place"
        }
        val listItems = findViewById<Button>(R.id.add_item_button)
        listItems.setOnClickListener {
            val intent = Intent(this@GarbageSorting, AddItem::class.java)
            startActivity(intent)
        }
    }

    companion object {
        //Model: Database of items
        private var itemsDB: ItemsDB? = null
    }
}