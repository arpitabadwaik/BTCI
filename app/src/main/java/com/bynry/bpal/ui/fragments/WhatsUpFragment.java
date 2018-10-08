package com.bynry.bpal.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.DiscussionActivity;
import com.bynry.bpal.ui.activities.LandingActivity;
import com.bynry.bpal.ui.adapters.WhatsUpFragmentAdapter;
import com.bynry.bpal.ui.interfaces.RecyclerViewClickListener;
import com.bynry.bpal.ui.models.WhatsUpBazaarModel;

import java.util.ArrayList;

public class WhatsUpFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<WhatsUpBazaarModel> whatsUpList;
    private Context context;
    private String caption;

    private OnFragmentInteractionListener mListener;

    public WhatsUpFragment() {
    }


    public static WhatsUpFragment newInstance(String param1, String param2) {
        WhatsUpFragment fragment = new WhatsUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whats_up, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_whats_up);

        context = getContext();

        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(layout);

        whatsUpList = new ArrayList<>();

        WhatsUpBazaarModel whatsUpBazaarModel = new WhatsUpBazaarModel();
        WhatsUpBazaarModel whatsUpBazaarModel2 = new WhatsUpBazaarModel();
        WhatsUpBazaarModel whatsUpBazaarModel3 = new WhatsUpBazaarModel();
        WhatsUpBazaarModel whatsUpBazaarModel4 = new WhatsUpBazaarModel();

        whatsUpBazaarModel.name = "Aalok Dekhane";
        whatsUpBazaarModel.subject = "";
        whatsUpBazaarModel.date = "1st july 2017";
        whatsUpBazaarModel.caption = "Worth visiting place: Mahabaleshwar :)";
        whatsUpBazaarModel.details = "";
        whatsUpBazaarModel.noOfComments = "43 ,";
        whatsUpBazaarModel.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpBazaarModel);

        whatsUpBazaarModel2.name = "Anjali Desai";
        whatsUpBazaarModel2.subject = "Inspirational";
        whatsUpBazaarModel2.date = "1st july 2017";
        whatsUpBazaarModel2.caption = "Self motivational stuff to read:";
        whatsUpBazaarModel2.details = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its.";
        whatsUpBazaarModel2.noOfComments = "43 ,";
        whatsUpBazaarModel2.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpBazaarModel2);

        whatsUpBazaarModel3.name = "Priyanka Chhetri";
        whatsUpBazaarModel3.subject = "Technology";
        whatsUpBazaarModel3.date = "1st july 2017";
        whatsUpBazaarModel3.caption = "Tech Query:";
        whatsUpBazaarModel3.details = "Lookin for CSS/HTML expertise, no. of request:5";
        whatsUpBazaarModel3.noOfComments = "43 ,";
        whatsUpBazaarModel3.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpBazaarModel3);

        whatsUpBazaarModel4.name = "Ajaykumar Singh";
        whatsUpBazaarModel4.subject = "Office Party";
        whatsUpBazaarModel4.date = "1st july 2017";
        whatsUpBazaarModel4.caption = "Worth visiting place: Mahabaleshwar :)";
        whatsUpBazaarModel4.details = "";
        whatsUpBazaarModel4.noOfComments = "43 ,";
        whatsUpBazaarModel4.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpBazaarModel4);

        WhatsUpFragmentAdapter myAdapter = new WhatsUpFragmentAdapter(whatsUpList, context);
        recyclerView.setAdapter(myAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(context, recyclerView, new RecyclerViewClickListener() {

            @Override
            public void onClick(View view, final int position) {
                Intent intent = new Intent(context, DiscussionActivity.class);
                caption = ((TextView) recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.txt_caption)).getText().toString();
                intent.putExtra("caption", caption);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private RecyclerViewClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final RecyclerViewClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
