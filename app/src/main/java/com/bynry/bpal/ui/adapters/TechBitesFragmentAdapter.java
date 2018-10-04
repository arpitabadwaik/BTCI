package com.bynry.bpal.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.models.TechBitesConnectModel;

import java.util.ArrayList;

public class TechBitesFragmentAdapter extends RecyclerView.Adapter<TechBitesFragmentAdapter.ViewHolder> {

    private ArrayList<TechBitesConnectModel> techBiteConnectList;
    private Context context;

    public TechBitesFragmentAdapter(ArrayList<TechBitesConnectModel> techBiteConnectList, Context context) {
        this.techBiteConnectList = techBiteConnectList;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cell_tech_bites, parent, false);
        TechBitesFragmentAdapter.ViewHolder viewHolder = new  TechBitesFragmentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtHeading.setText(techBiteConnectList.get(position).getHeading());
        holder.txtDescription.setText(techBiteConnectList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.techBiteConnectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtHeading, txtDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            txtHeading = itemView.findViewById(R.id.txt_heading);
            txtDescription = itemView.findViewById(R.id.txt_description);
        }
    }
}
