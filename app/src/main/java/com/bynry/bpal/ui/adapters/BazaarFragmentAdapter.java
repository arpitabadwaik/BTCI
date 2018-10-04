package com.bynry.bpal.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.models.WhatsUpBazaarModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BazaarFragmentAdapter extends RecyclerView.Adapter<BazaarFragmentAdapter.ViewHolder> {

    private ArrayList<WhatsUpBazaarModel> whatsUpBazaarList;
    private Context context;

    public BazaarFragmentAdapter(ArrayList<WhatsUpBazaarModel> whatsUpBazaarList, Context context) {
        this.whatsUpBazaarList = whatsUpBazaarList;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cell_bazaar, parent, false);
        BazaarFragmentAdapter.ViewHolder viewHolder = new  BazaarFragmentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameUser.setText(whatsUpBazaarList.get(position).getName());
        holder.txtDateBazaar.setText(whatsUpBazaarList.get(position).getDate());
        holder.txtCaption.setText(whatsUpBazaarList.get(position).getCaption());
        holder.txtPrice.setText(whatsUpBazaarList.get(position).getPrice());
        holder.txtDetails.setText(whatsUpBazaarList.get(position).getDetails());
        holder.txtNoOfInterestedPeople.setText(whatsUpBazaarList.get(position).getNoOfInterestedPeople());
        holder.txtLastInterestedClickDate.setText(whatsUpBazaarList.get(position).getLastInterestedClick());
    }

    @Override
    public int getItemCount() {
        return this.whatsUpBazaarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgUserImage;
        TextView txtNameUser, txtDateBazaar, txtCaption, txtPrice, txtDetails, txtNoOfInterestedPeople, txtLastInterestedClickDate;

        public ViewHolder(View itemView) {
            super(itemView);

            imgUserImage = itemView.findViewById(R.id.circle_img_user_image);

            txtNameUser = itemView.findViewById(R.id.txt_name_user);
            txtDateBazaar = itemView.findViewById(R.id.txt_date_bazaar);
            txtCaption = itemView.findViewById(R.id.txt_caption_bazaar);
            txtPrice = itemView.findViewById(R.id.txt_price);
            txtDetails = itemView.findViewById(R.id.txt_details_bazaar);
            txtNoOfInterestedPeople = itemView.findViewById(R.id.txt_no_of_interested_people);
            txtLastInterestedClickDate = itemView.findViewById(R.id.txt_last_interested_click_date);
        }
    }

}
