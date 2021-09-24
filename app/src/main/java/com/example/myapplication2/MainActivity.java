package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Item> groceryList;
    private RecyclerView recyclerView;
    private String newListItem;



    Button myButton;
    EditText myEdit;
    TextView myText;

    recyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        groceryList = new ArrayList<>();
        myButton = (Button)findViewById(R.id.button);

        setListInfo();
        adapter = setAdapter();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEdit   = (EditText)findViewById(R.id.textEntryBox);
                //myText = (TextView)findViewById(R.id.textView3);
                //myText.setText("Welcome "+myEdit.getText().toString()+"!");
                groceryList.add(new Item(myEdit.getText().toString()));
                adapter.notifyItemInserted(groceryList.size());
            }
        });

    }

    private recyclerAdapter setAdapter() { //change what's returned??
        recyclerAdapter myAdapter = new recyclerAdapter(groceryList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDelete(myAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
        return myAdapter;
    }

    private void setListInfo() {
        groceryList.add(new Item("Apple"));
        groceryList.add(new Item("Orange"));
        groceryList.add(new Item("Milk"));
    }

}