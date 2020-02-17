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
import com.evoscape.app.models.profile.Option;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private ArrayList<Option> options;
    private Context ctx;

    public ProfileAdapter(Context ctx, ArrayList<Option> options) {
        this.options = options;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_option_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (options.get(position).getName().equals("Logout"))
            holder.imageViewOptionGo.setImageResource(0);

        holder.imageViewOption.setImageResource(ctx.getResources().getIdentifier(options.get(position).getImage(), "drawable", ctx.getPackageName()));
        holder.textViewOptionName.setText(options.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(options.get(position).getName() + " clicked");
            }
        });
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewOption;
        ImageView imageViewOptionGo;
        TextView textViewOptionName;

        public ViewHolder(@NonNull View profileView) {
            super(profileView);
            imageViewOption = profileView.findViewById(R.id.imageViewOption);
            imageViewOptionGo = profileView.findViewById(R.id.imageViewOptionGo);
            textViewOptionName = profileView.findViewById(R.id.textViewOptionName);
        }
    }
}
