package dk.itu.garbagesorting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;

public class GarbageSorting extends AppCompatActivity {

    //Model: Database of items
    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage_sorting);

        ItemsDB.initialize();
        itemsDB = ItemsDB.get();

        //Text Fields
        TextView input = findViewById(R.id.what_text);


        Button findPlace = findViewById(R.id.where_button);
        findPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whatS = input.getText().toString().trim();
                String place = itemsDB.searchForItem(whatS);

                input.setText(whatS + " should be placed in: " + place);
            }
        });

        Button listItems = findViewById(R.id.add_item_button);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GarbageSorting.this, AddItem.class);
                startActivity(intent);
            }
        });
    }
}