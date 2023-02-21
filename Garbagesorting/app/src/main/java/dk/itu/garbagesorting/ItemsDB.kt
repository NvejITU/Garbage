package dk.itu.garbagesorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsDB {
    private static ItemsDB sItemsDB;
    private Map<String, String> itemsDB= new HashMap<>();

    private ItemsDB() { fillItemsDB(); }

    public static void initialize() {
        if (sItemsDB == null) sItemsDB= new ItemsDB();
    }

    public static ItemsDB get() {
        if (sItemsDB == null) throw new IllegalStateException("ItemsDB must be initialized");
        return sItemsDB;
    }

    public void addItem(String what, String where){
        itemsDB.put(what, where);
    }

    public void fillItemsDB() {
        itemsDB.put("coffee", "residual waste");
        itemsDB.put("carrots", "residual waste");
        itemsDB.put("milk carton", "cardboard");
        itemsDB.put("bread", "residual waste");
        itemsDB.put("butter", "residual waste");
        itemsDB.put("meat package", "plastic");
        itemsDB.put("bean can", "metal");
    }

    public String searchForItem(String item){
        String itemPlace = "not found";

        for (Map.Entry<String, String> existingItem : itemsDB.entrySet()) {
            if (existingItem.getKey().equals(item)){
                itemPlace = existingItem.getValue();
            }
        }
        return itemPlace;
    }

    public Map<String, String> getMap(){
        return itemsDB;
    }
}
