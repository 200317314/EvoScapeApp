package com.evoscape.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evoscape.app.R;
import com.evoscape.app.models.service.Service;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {
    private Context ctx;
    private ArrayList<Service> services;

    public ServiceAdapter(Context ctx, ArrayList<Service> services) {
        this.ctx = ctx;
        this.services = services;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.imageViewService.setImageResource(R.drawable.placeholder);
        viewHolder.serviceTitle.setText(services.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewService;
        TextView serviceTitle;

        public ViewHolder(@NonNull View serviceView) {
            super(serviceView);
            imageViewService = serviceView.findViewById(R.id.imageViewService);
            serviceTitle = serviceView.findViewById(R.id.textViewServiceTitle);
        }
    }
}
