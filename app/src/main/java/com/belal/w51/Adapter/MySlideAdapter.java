package com.belal.w51.Adapter;

import com.squareup.picasso.Picasso;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MySlideAdapter extends SliderAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                Picasso.get().load("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg").into(viewHolder.imageView);
                break;
            case 1:
                Picasso.get().load("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg").into(viewHolder.imageView);
                break;
            case 2:
                Picasso.get().load("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png").into(viewHolder.imageView);
                break;
        }
    }
}
