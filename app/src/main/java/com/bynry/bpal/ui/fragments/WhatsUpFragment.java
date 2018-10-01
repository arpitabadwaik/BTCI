package com.bynry.bpal.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.LandingActivity;
import com.bynry.bpal.ui.activities.SignUpActivity;
import com.bynry.bpal.ui.adapters.WhatsUpFragmentAdapter;

import java.util.ArrayList;

public class WhatsUpFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<String> userNames;
    Context context;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

   /* // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;*/

    private OnFragmentInteractionListener mListener;

    public WhatsUpFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static WhatsUpFragment newInstance(String param1, String param2) {
        WhatsUpFragment fragment = new WhatsUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_whats_up, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_whats_up);

        context = getContext();

        StaggeredGridLayoutManager layout =  new StaggeredGridLayoutManager(3,1);
        recyclerView.setLayoutManager(layout);

        userNames = new ArrayList<>();

        userNames.add("Swaraj Negi");
        userNames.add("Bhaskar Negi");
        userNames.add("Bhakti Negi");
        userNames.add("Swati Negi");

        WhatsUpFragmentAdapter myAdapter = new WhatsUpFragmentAdapter(userNames, context);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
