package com.example.overlapped;


import android.app.usage.UsageEvents;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomEventRecyclerAdapter extends RecyclerView.Adapter<CustomEventRecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<Event> events; //TODO: Need to actually implement the event class.
    public RecyclerClickListener eventClickListener;

    public CustomEventRecyclerAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.event_container_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String date = this.events.get(position).getTimes().toString();
        holder.getMonthText().setText(date);
        Log.i("Fix", "Please fix the OnBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private ArrayList<Event> getEvents() {
        return this.events;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView monthText;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            this.monthText = view.findViewById(R.id.month_text);
//            dayNumberText = view.findViewById(R.id.day_number_text);
//            nameOfEventText = view.findViewById(R.id.event_title);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (eventClickListener != null) {
                eventClickListener.onItemClick(view, getAdapterPosition());
            }
        }

        public TextView getMonthText() {
            return this.monthText;
        }
        
    }

    public void setEventClickListener(RecyclerClickListener listener) {
        this.eventClickListener = listener;
    }

}
