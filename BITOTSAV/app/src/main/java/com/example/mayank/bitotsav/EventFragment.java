package com.example.mayank.bitotsav;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class EventFragment extends Fragment {
    RecyclerView eventsRecyclerView;
    LinearLayoutManager linearLayoutManager;
    EventsRecyclerViewAdapter eventsRecyclerViewAdapter;
    String jsonArray;
    JSONArray json;

    public static EventFragment newInstance(int item) {
        EventFragment f = new EventFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("item", item);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        jsonArray = args.getString("jsonArray");
        try {
            json = new JSONArray(jsonArray);
        } catch (JSONException e) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        eventsRecyclerView = (RecyclerView) v.findViewById(R.id.eventsRecyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());

        eventsRecyclerView.setLayoutManager(linearLayoutManager);
        eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(getActivity(), EventFragment.this, linearLayoutManager, eventsRecyclerView, json);

        eventsRecyclerView.setAdapter(eventsRecyclerViewAdapter);

        return v;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
}
