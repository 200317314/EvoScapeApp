package com.evoscape.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evoscape.app.R;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    private Context ctx;
    private ArrayList<String> addresses;
    private String cachedAddress;
    private TextView textViewHomeAddress;

    public AddressAdapter(Context ctx, ArrayList<String> addresses, TextView textViewHomeAddress) {
        this.ctx = ctx;
        this.addresses = addresses;
        this.cachedAddress = "";
        this.textViewHomeAddress = textViewHomeAddress;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.textViewAddress.setText(addresses.get(position));
        System.out.println(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cachedAddress = textViewHomeAddress.getText().toString();
                textViewHomeAddress.setText(addresses.get(position));
                addresses.set(position, cachedAddress);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return addresses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAddress;

        public ViewHolder(@NonNull View view) {
            super(view);
            textViewAddress = view.findViewById(R.id.textViewAddress);
        }
    }
}
