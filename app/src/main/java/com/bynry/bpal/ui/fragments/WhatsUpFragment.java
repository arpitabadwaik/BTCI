package com.bynry.bpal.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.activities.DiscussionActivity;
import com.bynry.bpal.ui.adapters.WhatsUpFragmentAdapter;
import com.bynry.bpal.ui.models.WhatsUpModel;

import java.util.ArrayList;

public class WhatsUpFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<WhatsUpModel> whatsUpList;
    private Context context;

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

        WhatsUpModel whatsUpModel = new WhatsUpModel();
        WhatsUpModel whatsUpModel2 = new WhatsUpModel();
        WhatsUpModel whatsUpModel3 = new WhatsUpModel();
        WhatsUpModel whatsUpModel4 = new WhatsUpModel();

        whatsUpModel.name = "Aalok Dekhane";
        whatsUpModel.subject = "";
        whatsUpModel.date = "1st july 2017";
        whatsUpModel.caption = "Worth visiting place: Mahabaleshwar :)";
        whatsUpModel.details = "";
        whatsUpModel.noOfComments = "43 ,";
        whatsUpModel.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpModel);

        whatsUpModel2.name = "Anjali Desai";
        whatsUpModel2.subject = "Inspirational";
        whatsUpModel2.date = "1st july 2017";
        whatsUpModel2.caption = "Self motivational stuff to read:";
        whatsUpModel2.details = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its.";
        whatsUpModel2.noOfComments = "43 ,";
        whatsUpModel2.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpModel2);

        whatsUpModel3.name = "Priyanka Chhetri";
        whatsUpModel3.subject = "Technology";
        whatsUpModel3.date = "1st july 2017";
        whatsUpModel3.caption = "Tech Query:";
        whatsUpModel3.details = "Lookin for CSS/HTML expertise, no. of request:5";
        whatsUpModel3.noOfComments = "43 ,";
        whatsUpModel3.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpModel3);

        whatsUpModel4.name = "Ajaykumar Singh";
        whatsUpModel4.subject = "Office Party";
        whatsUpModel4.date = "1st july 2017";
        whatsUpModel4.caption = "Worth visiting place: Mahabaleshwar :)";
        whatsUpModel4.details = "";
        whatsUpModel4.noOfComments = "43 ,";
        whatsUpModel4.lastCommentDate = "3rd july 2017";
        whatsUpList.add(whatsUpModel4);

        WhatsUpFragmentAdapter myAdapter = new WhatsUpFragmentAdapter(whatsUpList, context);
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
