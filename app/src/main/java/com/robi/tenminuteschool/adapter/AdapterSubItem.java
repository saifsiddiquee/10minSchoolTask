package com.robi.tenminuteschool.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.robi.tenminuteschool.R;
import com.robi.tenminuteschool.constant.Methods;
import com.robi.tenminuteschool.model.ItemSub;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterSubItem extends RecyclerView.Adapter<AdapterSubItem.SubItemHolder> {

    List<ItemSub> itemsList;
    private Activity context;

    public AdapterSubItem(List<ItemSub> itemsList, Activity context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public SubItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_sub_item, parent, false);
        return new SubItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemHolder holder, int position) {
        final ItemSub item = itemsList.get(position);

        Picasso.get().load(item.getImage())
                .into(holder.image, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
        holder.txtHeading.setText(item.getHeading());

        if (!item.getHeading().equals("")) {
            holder.txtCaption.setVisibility(View.VISIBLE);
            holder.txtCaption.setText(item.getCaption());
        } else {
            holder.txtCaption.setVisibility(View.GONE);
        }

        holder.holderMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Methods(context).showToast(item.getHeading() + " tapped");
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class SubItemHolder extends RecyclerView.ViewHolder {
        TextView txtHeading, txtCaption;
        ImageView image;
        ConstraintLayout holderMain;

        public SubItemHolder(@NonNull View itemView) {
            super(itemView);
            txtHeading = itemView.findViewById(R.id.txt_sub_heading);
            txtCaption = itemView.findViewById(R.id.txt_sub_caption);
            image = itemView.findViewById(R.id.img_sub_header);
            holderMain = itemView.findViewById(R.id.holder_main);
        }
    }
}
