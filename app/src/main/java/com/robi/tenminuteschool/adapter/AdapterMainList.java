package com.robi.tenminuteschool.adapter;

import android.app.Activity;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.robi.tenminuteschool.R;
import com.robi.tenminuteschool.constant.Methods;
import com.robi.tenminuteschool.model.Items;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMainList extends RecyclerView.Adapter<AdapterMainList.MainListHolder> {

    private List<Items> itemsList;
    private Activity context;

    public AdapterMainList(List<Items> itemsList, Activity context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MainListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_main_item, parent, false);
        return new MainListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainListHolder holder, int position) {
        final Items item = itemsList.get(position);

        if (item.getImage() != 0) {
            holder.imageHolder.setVisibility(View.VISIBLE);
            Picasso.get().load(item.getImage())
                    .into(holder.image, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {
                        }
                    });
        } else {
            holder.imageHolder.setVisibility(View.GONE);
        }
        holder.txtHeading.setText(item.getHeading());

        if (item.getItemSubs() != null) {
            holder.arrowBtn.setVisibility(View.VISIBLE);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            holder.rvSubItem.setLayoutManager(layoutManager);
            AdapterSubItem adapter = new AdapterSubItem(item.getItemSubs(), context);
            holder.rvSubItem.setItemAnimator(new DefaultItemAnimator());
            holder.rvSubItem.setAdapter(adapter);

            holder.holderMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.expandableView.getVisibility() == View.GONE) {
                        TransitionManager.beginDelayedTransition(holder.holderMain, new AutoTransition());
                        holder.expandableView.setVisibility(View.VISIBLE);
                        holder.arrowBtn.setBackgroundResource(R.drawable.ic_arrow_up);
                    } else {
                        TransitionManager.beginDelayedTransition(holder.holderMain, new AutoTransition());
                        holder.expandableView.setVisibility(View.GONE);
                        holder.arrowBtn.setBackgroundResource(R.drawable.ic_arrow_down);
                    }
                }
            });

        } else {
            holder.arrowBtn.setVisibility(View.GONE);

            holder.holderMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new Methods(context).showToast(item.getHeading() + " tapped");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MainListHolder extends RecyclerView.ViewHolder {
        TextView txtHeading;
        ImageView image;
        //        ImageView headerIndicator;
        RecyclerView rvSubItem;
        MaterialCardView holderMain;
        CardView imageHolder;
        ConstraintLayout expandableView;
        ImageView arrowBtn;

        public MainListHolder(@NonNull View itemView) {
            super(itemView);
            txtHeading = itemView.findViewById(R.id.txt_heading);
            image = itemView.findViewById(R.id.img_header);
//            headerIndicator = itemView.findViewById(R.id.header_indicator);
            rvSubItem = itemView.findViewById(R.id.rv_sub_item);
            holderMain = itemView.findViewById(R.id.cardView);
            expandableView = itemView.findViewById(R.id.expandableView);
            arrowBtn = itemView.findViewById(R.id.arrowBtn);
            imageHolder = itemView.findViewById(R.id.image_holder);
        }
    }
}
