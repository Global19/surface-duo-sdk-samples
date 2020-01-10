package com.microsoft.device.display.samples.complementarycontext.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.microsoft.device.display.samples.complementarycontext.R;
import com.microsoft.device.display.samples.complementarycontext.Slide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.SlideViewHolder> {
    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private ArrayList<Slide> slides;
    private int currentPosition;

    public RecyclerViewAdapter(Context context, ArrayList<Slide> slides) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.slides = slides;
    }

    @Override
    public SlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SlideViewHolder holder = new SlideViewHolder(mLayoutInflater.inflate(R.layout.item_slide, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(SlideViewHolder holder, int position) {
        holder.content.setText(slides.get(position).getContent());
        holder.title.setText(slides.get(position).getTitle());
        if(currentPosition == position) {
            holder.setSelected(true);
        } else {
            holder.setSelected(false);
        }
    }

    public void setCurrentPosition(int position) {
        currentPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }

    public static class SlideViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = SlideViewHolder.class.getSimpleName();
        TextView content;
        TextView title;
        CardView cardView;

        SlideViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.slide_title);
            content = view.findViewById(R.id.slide_content);
            cardView = view.findViewById(R.id.cardview);
        }

        public void setSelected(boolean selected) {
            cardView.setSelected(selected);
        }
    }
}