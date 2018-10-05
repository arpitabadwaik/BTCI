package com.bynry.bpal.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.TechBitesMoreActivity;
import com.bynry.bpal.ui.adapters.TechBitesFragmentAdapter;
import com.bynry.bpal.ui.interfaces.RecyclerViewClickListener;
import com.bynry.bpal.ui.models.TechBitesConnectModel;

import java.util.ArrayList;

public class TechBitesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<TechBitesConnectModel> techBiteconnectList;
    private Context context;
    private ImageView imgMain;

    private OnFragmentInteractionListener mListener;

    public TechBitesFragment() {
    }

    public static TechBitesFragment newInstance(String param1, String param2) {
        TechBitesFragment fragment = new TechBitesFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tech_bites, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_tech_bites);

        View view1 = inflater.inflate(R.layout.cell_tech_bites, container, false);
        imgMain = view1.findViewById(R.id.image_main);
        imgMain.setScaleType(ImageView.ScaleType.FIT_END);

        context = getContext();

        LinearLayoutManager layout = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layout);

        techBiteconnectList = new ArrayList<>();

        TechBitesConnectModel techBitesConnectModel = new TechBitesConnectModel();
        TechBitesConnectModel techBitesConnectModel1 = new TechBitesConnectModel();
        TechBitesConnectModel techBitesConnectModel2 = new TechBitesConnectModel();

        techBitesConnectModel.heading = "Economic Concepts consumers needs to know";
        techBitesConnectModel.description = "The over-the-counter market is not an actual exchange like the NYSE or nasdaq. Instead , it is a network of companies that...";
        techBiteconnectList.add(techBitesConnectModel);

        techBitesConnectModel1.heading = "6 Technology trends That Aren't AI, Blockchain or VR.";
        techBitesConnectModel1.description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its...";
        techBiteconnectList.add(techBitesConnectModel1);

        techBitesConnectModel2.heading = "The (Near) Future of Technology";
        techBitesConnectModel2.description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its...";
        techBiteconnectList.add(techBitesConnectModel2);


        TechBitesFragmentAdapter myAdapter = new TechBitesFragmentAdapter(techBiteconnectList, context);
        recyclerView.setAdapter(myAdapter);

        recyclerView.addOnItemTouchListener(new TechBitesFragment.RecyclerTouchListener(context, recyclerView, new RecyclerViewClickListener() {

            @Override
            public void onClick(View view, final int position) {
                Intent intent = new Intent(context, TechBitesMoreActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(context, "Long press on position :"+position, Toast.LENGTH_LONG).show();
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
