package dk.itu.garbagesorting

class ItemsDB private constructor() {
    private val itemsDB: MutableMap<String, String> = HashMap()

    init {
        fillItemsDB()
    }

    fun addItem(what: String, where: String) {
        itemsDB[what] = where
    }

    fun fillItemsDB() {
        itemsDB["coffee"] = "residual waste"
        itemsDB["carrots"] = "residual waste"
        itemsDB["milk carton"] = "cardboard"
        itemsDB["bread"] = "residual waste"
        itemsDB["butter"] = "residual waste"
        itemsDB["meat package"] = "plastic"
        itemsDB["bean can"] = "metal"
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
        fun initialize() {
            if (sItemsDB == null) sItemsDB = ItemsDB()
        }

        fun get(): ItemsDB? {
            checkNotNull(sItemsDB) { "ItemsDB must be initialized" }
            return sItemsDB
        }
    }
}