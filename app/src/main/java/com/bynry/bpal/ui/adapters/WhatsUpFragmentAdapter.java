package com.bynry.bpal.ui.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.LandingActivity;
import com.bynry.bpal.ui.fragments.WhatsUpFragment;
import com.bynry.bpal.ui.models.WhatsUpBazaarModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class WhatsUpFragmentAdapter extends RecyclerView.Adapter<WhatsUpFragmentAdapter.ViewHolder> {

    private ArrayList<WhatsUpBazaarModel> whatsUpList;
    private Context context;

    public WhatsUpFragmentAdapter(ArrayList<WhatsUpBazaarModel> whatsUpList, Context context) {
        this.whatsUpList = whatsUpList;
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

        holder.txtNameOfUser.setText(whatsUpList.get(position).getName());
        holder.txtSubject.setText(whatsUpList.get(position).getSubject());
        holder.txtDate.setText(whatsUpList.get(position).getDate());
        holder.txtCaption.setText(whatsUpList.get(position).getCaption());
        holder.txtDetails.setText(whatsUpList.get(position).getDetails());
        holder.txtNoOfComments.setText(whatsUpList.get(position).getNoOfComments());
        holder.txtLastCommentDate.setText(whatsUpList.get(position).getLastCommentDate());

    }

    @Override
    public int getItemCount() {
        return this.whatsUpList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView circleImgUserImage;
        private TextView txtNameOfUser, txtSubject, txtDate, txtCaption, txtDetails, txtNoOfComments, txtLastCommentDate;

        public ViewHolder(View itemView) {
            super(itemView);

            circleImgUserImage = itemView.findViewById(R.id.circle_img_user_image);

            txtNameOfUser = itemView.findViewById(R.id.txt_name_of_user);
            txtSubject = itemView.findViewById(R.id.txt_subject);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtCaption = itemView.findViewById(R.id.txt_caption);
            txtDetails = itemView.findViewById(R.id.txt_details);
            txtNoOfComments = itemView.findViewById(R.id.txt_no_of_comments);
            txtLastCommentDate = itemView.findViewById(R.id.txt_last_comment_date);
        }
    }
}

