package com.evoscape.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evoscape.app.R;
import com.evoscape.app.models.profile.Option;
import com.evoscape.app.models.profile.Profile;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private ArrayList<Option> options;
    private Context ctx;
    private Profile profile;

    public ProfileAdapter(Context ctx, ArrayList<Option> options, Profile profile) {
        this.options = options;
        this.ctx = ctx;
        this.profile = profile;
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
                Intent i = new Intent(ctx, options.get(position).getStartActivityClass()).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("profile", profile);
                ctx.startActivity(i);
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
