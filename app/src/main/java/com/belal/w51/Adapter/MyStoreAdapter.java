package com.belal.w51.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belal.w51.Module.StoreModule;
import com.belal.w51.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyStoreAdapter extends RecyclerView.Adapter<com.belal.w51.Adapter.MyStoreAdapter.MyViewHolder> {

    Context context;
    List<StoreModule> storeModuleList;
    LayoutInflater inflater;


    public MyStoreAdapter(Context context, List<StoreModule> storeModuleList)
    {
        this.context = context;
        this.storeModuleList = storeModuleList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = inflater.inflate(R.layout.store_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(storeModuleList.get(position).name);
        if(!storeModuleList.get(position).text.equals(""))
            holder.textView.setTextColor(Color.parseColor(storeModuleList.get(position).text));
        holder.frameLayout.setBackgroundColor(Color.parseColor(storeModuleList.get(position).color));
        Picasso.get().load(storeModuleList.get(position).img).into(holder.imageView);
        Log.d("TEST ========> ", storeModuleList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return storeModuleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        FrameLayout frameLayout;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.txt_name);
            frameLayout = (FrameLayout)itemView.findViewById(R.id.frame_background);
            imageView = (ImageView)itemView.findViewById(R.id.img_icon);
        }
    }
}
