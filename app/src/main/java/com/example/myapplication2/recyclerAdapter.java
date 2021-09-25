package com.example.myapplication2;

import android.service.autofill.TextValueSanitizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Item> itemList;

    public recyclerAdapter(ArrayList<Item> itemList){
        this.itemList = itemList;
    }

    public void deleteItem(int position) {
        Item mRecentlyDeletedItem = itemList.get(position);
        int mRecentlyDeletedItemPosition = position;
        itemList.remove(position);
        notifyItemRemoved(position);
        //showUndoSnackbar();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView itemText;

        private TextView itemNum;

        public MyViewHolder(final View view){
            super(view);
            itemText = view.findViewById(R.id.textView2);
            itemNum = view.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View objectView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(objectView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String listItem = itemList.get(position).getItemName();
        holder.itemText.setText(listItem);
        holder.itemNum.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
