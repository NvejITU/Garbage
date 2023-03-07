package dk.itu.garbagesorting

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item)
        ItemsDB.initialize(this@AddItem)
        itemsDB = ItemsDB.get()

        //Text Fields
        val newWhat = findViewById<TextView>(R.id.which_item)
        val newWhere = findViewById<TextView>(R.id.where_to_place)
        val addItem = findViewById<Button>(R.id.add_button)
        // adding a new thing
        addItem.setOnClickListener {
            val whatS = newWhat.text.toString().trim { it <= ' ' }
            val whereS = newWhere.text.toString().trim { it <= ' ' }
            if (whatS.length > 0 && whereS.length > 0) {
                itemsDB?.addItem(whatS, whereS)
                newWhat.text = ""
                newWhere.text = ""
            }
        }
    }

    companion object {
        //Model: Database of items
        private var itemsDB: ItemsDB? = null
    }
}