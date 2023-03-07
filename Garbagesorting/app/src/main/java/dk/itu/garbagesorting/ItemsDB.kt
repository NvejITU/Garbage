package dk.itu.garbagesorting

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ItemsDB private constructor(context: Context) {
    private val itemsDB: MutableMap<String, String> = HashMap()

    init {
        fillItemsDB(context)
    }

    fun addItem(what: String, where: String) {
        itemsDB[what] = where
    }

    fun fillItemsDB(context: Context) {
        try {
            val reader = BufferedReader(
                    InputStreamReader(context.assets.open("garbage.txt")))
            var line = reader.readLine()
            while (line != null) {
                val listItem = line.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                addItem(listItem[0], listItem[1])
                line = reader.readLine()
            }
        } catch (e: IOException) {
            println("Error")
        }
    }

    fun searchForItem(item: String): String {
        var itemPlace = "not found"
        for ((key, value) in itemsDB) {
            if (key == item) {
                itemPlace = value
            }
        }
        return itemPlace
    }

    val map: Map<String, String>
        get() = itemsDB

    companion object {
        private var sItemsDB: ItemsDB? = null
        fun initialize(context: Context) {
            if (sItemsDB == null) sItemsDB = ItemsDB(context)
        }

        fun get(): ItemsDB? {
            checkNotNull(sItemsDB) { "ItemsDB must be initialized" }
            return sItemsDB
        }
    }
}