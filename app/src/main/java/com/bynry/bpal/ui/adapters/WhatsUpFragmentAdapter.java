package com.bynry.bpal.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bynry.bpal.R;

import java.util.List;

public class WhatsUpFragmentAdapter extends RecyclerView.Adapter<WhatsUpFragmentAdapter.ViewHolder> {

    private List<String> itemList;
    private Context context;

    public WhatsUpFragmentAdapter(List<String> itemList, Context context) {
        this.itemList = itemList;
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
        //holder.txtDemo.setText(itemList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDemo, txtMobileNo, txtAddress;

        public ViewHolder(View itemView) {
            super(itemView);

            txtDemo = itemView.findViewById(R.id.txt_demo);
        }
    }
}

