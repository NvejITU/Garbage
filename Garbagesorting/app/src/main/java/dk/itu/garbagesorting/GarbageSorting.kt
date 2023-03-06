package dk.itu.garbagesorting

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dk.itu.garbagesorting.AddItem

class GarbageSorting : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garbage_sorting)
        ItemsDB.initialize()
        itemsDB = ItemsDB.get()

        //Text Fields
        var input = findViewById<TextView>(R.id.what_text)
        var findPlace = findViewById<Button>(R.id.where_button)
        findPlace.setOnClickListener {
            var whatS = input.text.toString().trim { it <= ' ' }
            var place = itemsDB?.searchForItem(whatS)
            input.text = "$whatS should be placed in: $place"
        }
        var listItems = findViewById<Button>(R.id.add_item_button)
        listItems.setOnClickListener {
            var intent = Intent(this@GarbageSorting, AddItem::class.java)
            startActivity(intent)
        }
    }

    companion object {
        //Model: Database of items
        private var itemsDB: ItemsDB? = null
    }
}