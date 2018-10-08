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
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.BazaarDescriptionActivity;
import com.bynry.bpal.ui.activities.TechBitesMoreActivity;
import com.bynry.bpal.ui.adapters.BazaarFragmentAdapter;
import com.bynry.bpal.ui.adapters.WhatsUpFragmentAdapter;
import com.bynry.bpal.ui.interfaces.RecyclerViewClickListener;
import com.bynry.bpal.ui.models.WhatsUpBazaarModel;

import java.util.ArrayList;

public class BazaarFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<WhatsUpBazaarModel> whatsUpBazaarList;
    private Context context;

    private OnFragmentInteractionListener mListener;

    public BazaarFragment() {
    }

    public static BazaarFragment newInstance(String param1, String param2) {
        BazaarFragment fragment = new BazaarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bazaar, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_bazaar);

        context = getContext();

        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(layout);

        whatsUpBazaarList = new ArrayList<>();

        WhatsUpBazaarModel whatsUpBazaarModel = new WhatsUpBazaarModel();
        WhatsUpBazaarModel whatsUpBazaarModel2 = new WhatsUpBazaarModel();
        WhatsUpBazaarModel whatsUpBazaarModel3 = new WhatsUpBazaarModel();
        WhatsUpBazaarModel whatsUpBazaarModel4 = new WhatsUpBazaarModel();

        whatsUpBazaarModel.name = "Bradley Chase";
        whatsUpBazaarModel.date = "1st july 2017";
        whatsUpBazaarModel.caption = "Haier fully automatic washing machine";
        whatsUpBazaarModel.price = "Rs. 7000";
        whatsUpBazaarModel.details = "";
        whatsUpBazaarModel.noOfInterestedPeople = "43 ,";
        whatsUpBazaarModel.lastInterestedClick = "3rd july 2017";
        whatsUpBazaarList.add(whatsUpBazaarModel);

        whatsUpBazaarModel2.name = "Priyanka Chhetri";
        whatsUpBazaarModel2.date = "1st july 2017";
        whatsUpBazaarModel2.caption = "iphone 7 for sale";
        whatsUpBazaarModel2.price = "";
        whatsUpBazaarModel2.details = "It's a steal..! just a month old iphone for sale. You can reach...";
        whatsUpBazaarModel2.noOfInterestedPeople = "43 ,";
        whatsUpBazaarModel2.lastInterestedClick = "3rd july 2017";
        whatsUpBazaarList.add(whatsUpBazaarModel2);

        whatsUpBazaarModel4.name = "Priynaka Chhetri";
        whatsUpBazaarModel4.date = "1st july 2017";
        whatsUpBazaarModel4.caption = "Wooden furniture items clearance";
        whatsUpBazaarModel4.price = "Rs. 38000";
        whatsUpBazaarModel4.details = "Beautiful contemporary style furniture i.e. Dining table chairs, tv units, centre and corner tables, book shelf for sale";
        whatsUpBazaarModel4.noOfInterestedPeople = "43 ,";
        whatsUpBazaarModel4.lastInterestedClick = "3rd july 2017";
        whatsUpBazaarList.add(whatsUpBazaarModel4);

        whatsUpBazaarModel3.name = "Anjali Desai";
        whatsUpBazaarModel3.date = "1st july 2017";
        whatsUpBazaarModel3.caption = "2 years old TVS apache RTR, tiptop condition";
        whatsUpBazaarModel3.price = "Rs. 7000";
        whatsUpBazaarModel3.details = "";
        whatsUpBazaarModel3.noOfInterestedPeople = "43 ,";
        whatsUpBazaarModel3.lastInterestedClick = "3rd july 2017";
        whatsUpBazaarList.add(whatsUpBazaarModel3);

        BazaarFragmentAdapter myAdapter = new BazaarFragmentAdapter(whatsUpBazaarList, context);
        recyclerView.setAdapter(myAdapter);

        recyclerView.addOnItemTouchListener(new BazaarFragment.RecyclerTouchListener(context, recyclerView, new RecyclerViewClickListener() {

            @Override
            public void onClick(View view, final int position) {
                Intent intent = new Intent(context, BazaarDescriptionActivity.class);
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
