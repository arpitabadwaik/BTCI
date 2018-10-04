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
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.TechBitesMoreActivity;
import com.bynry.bpal.ui.adapters.TechBitesFragmentAdapter;
import com.bynry.bpal.ui.interfaces.RecyclerViewClickListener;
import com.bynry.bpal.ui.models.TechBitesConnectModel;

import java.util.ArrayList;

public class ConnectFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<TechBitesConnectModel> techBiteConnectList;
    private Context context;

    private OnFragmentInteractionListener mListener;

    public ConnectFragment() {
    }

    public static ConnectFragment newInstance(String param1, String param2) {
        ConnectFragment fragment = new ConnectFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getContext();

        View view = inflater.inflate(R.layout.fragment_connect, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_connect);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layout = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layout);

        techBiteConnectList = new ArrayList<>();

        TechBitesConnectModel techBitesConnectModel = new TechBitesConnectModel();
        TechBitesConnectModel techBitesConnectModel1 = new TechBitesConnectModel();

        techBitesConnectModel.heading = "Internet Of Things-Events";
        techBitesConnectModel.description = "IOT events is one of the leading events related to current internet activity";
        techBiteConnectList.add(techBitesConnectModel);

        techBitesConnectModel1.heading = "Hackathon";
        techBitesConnectModel1.description = "Register\nwww.hackathon.com";
        techBiteConnectList.add(techBitesConnectModel1);

        TechBitesFragmentAdapter myAdapter = new TechBitesFragmentAdapter(techBiteConnectList, context);
        recyclerView.setAdapter(myAdapter);

        recyclerView.addOnItemTouchListener(new ConnectFragment.RecyclerTouchListener(context, recyclerView, new RecyclerViewClickListener() {

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
