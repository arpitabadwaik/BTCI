package com.bynry.bpal.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bynry.bpal.R;

import java.util.ArrayList;
import java.util.List;

public class WhatsUpFragmentAdapter extends RecyclerView.Adapter<WhatsUpFragmentAdapter.ViewHolder> {

    private ArrayList<String> userNames;
    private Context context;

    public WhatsUpFragmentAdapter(ArrayList<String> userNames, Context context) {
        this.userNames = userNames;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cell_whats_up, parent, false);
        WhatsUpFragmentAdapter.ViewHolder viewHolder = new  WhatsUpFragmentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNameOfUser.setText(userNames.get(position));
    }

    @Override
    public int getItemCount() {
        return this.userNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNameOfUser;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNameOfUser = itemView.findViewById(R.id.txt_name_of_user);
        }
    }
}

