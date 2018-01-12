package com.myworkone.shais.myworkone;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shais on 01/08/2018.
 */

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.MyViewHolder> {
    private List<Actor> list;
    private Context context;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_profile,parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Actor actor = list.get(position);
        holder.name.setText(actor.getName());
        holder.description.setText(actor.getDescription());
        holder.dob.setText(actor.getDob());
        holder.country.setText(actor.getCountry());
        holder.height.setText(actor.getHeight());
        holder.spouse.setText(actor.getSpouse());
        holder.children.setText(actor.getChildren());
        Picasso.with(context)
                .load(actor.getImage())
                .fit()
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public TextView description;
        public TextView dob;
        public TextView country;
        public TextView height;
        public TextView spouse;
        public TextView children;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txv_name);
            description = itemView.findViewById(R.id.txv_description);
            dob = itemView.findViewById(R.id.txv_dob);
            country = itemView.findViewById(R.id.txv_country);
            height = itemView.findViewById(R.id.txv_height);
            spouse = itemView.findViewById(R.id.txv_spouse);
            children = itemView.findViewById(R.id.txv_children);
            image = itemView.findViewById(R.id.txv_image);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Actor actor = getActor(getAdapterPosition());
            notifyDataSetChanged();
            if (view.getTag().equals("image"))
            {
                Toast.makeText(context,"" + actor.getName(),Toast.LENGTH_LONG).show();
            }

        }
    }

    public ActorsAdapter(List<Actor> actorsList, Context context) {
        this.list = actorsList;
        this.context = context;
    }


    private Actor getActor(int adapterPosition)
    {
        return list.get(adapterPosition);
    }


}


