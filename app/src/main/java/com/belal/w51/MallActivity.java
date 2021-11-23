package com.belal.w51;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.belal.w51.Adapter.MySlideAdapter;
import com.belal.w51.Adapter.MyStoreAdapter;
import com.belal.w51.Module.StoreModule;
import com.belal.w51.Tools.PicassoImageLoadingService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.Slider;

public class MallActivity extends AppCompatActivity {

    private Slider slider;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_stores);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Mall").child("Stores");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final List<StoreModule> storeModuleList = new ArrayList<>();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    StoreModule store = dataSnapshot.getValue(StoreModule.class);
                    storeModuleList.add(store);
                }
                OnLoadDone(storeModuleList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        slider = findViewById(R.id.banner_slider1);
        slider.setAdapter(new MySlideAdapter());


    }

    void OnLoadDone(List<StoreModule> storeModuleList)
    {
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setLayoutManager(horizontalLayoutManager);

        recyclerView.setAdapter(new MyStoreAdapter(getApplicationContext(), storeModuleList));
    }
}