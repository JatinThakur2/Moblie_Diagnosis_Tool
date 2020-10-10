package com.example.mobliediagnosis.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobliediagnosis.R;

import java.util.ArrayList;

public class CPUAdapter extends RecyclerView.Adapter<CPUAdapter.CPUViewHolder> {

    private ArrayList<String> data;

    public CPUAdapter(ArrayList<String> input) {
        data = input;
    }

    @NonNull
    @Override
    public CPUViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cpu_recycler_view, parent, false);
        return new CPUViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CPUViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CPUViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public CPUViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

}