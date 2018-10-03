package com.bynry.bpal.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.adapters.TechBitesFragmentAdapter;
import com.bynry.bpal.ui.adapters.WhatsUpFragmentAdapter;
import com.bynry.bpal.ui.models.TechBitesModel;
import com.bynry.bpal.ui.models.WhatsUpModel;

import java.util.ArrayList;

public class TechBitesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<TechBitesModel> techBiteList;
    private Context context;

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

        context = getContext();

        LinearLayoutManager layout = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layout);

        techBiteList = new ArrayList<>();

        TechBitesModel techBitesModel = new TechBitesModel();
        TechBitesModel techBitesModel1 = new TechBitesModel();

        techBitesModel.heading = "Economic Concepts consumers needs to know";
        techBitesModel.description = "The over-the-counter market is not an actual exchange like the NYSE or nasdaq. Instead , it is a network of companies that...";
        techBiteList.add(techBitesModel);

        techBitesModel1.heading = "6 Technology trends That Aren't AI, Blockchain or VR.";
        techBitesModel1.description = "The over-the-counter market is not an actual exchange like the NYSE or nasdaq. Instead , it is a network of companies that...";
        techBiteList.add(techBitesModel1);


        TechBitesFragmentAdapter myAdapter = new TechBitesFragmentAdapter(techBiteList, context);
        recyclerView.setAdapter(myAdapter);
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
}
