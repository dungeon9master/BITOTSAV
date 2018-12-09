package com.example.mayank.bitotsav;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FAQ extends Fragment {
    List<String> questionsList = new ArrayList<String>();
    List<String> answersList = new ArrayList<String>();
RecyclerView faqRecycerView;
    LinearLayoutManager faqLayoutManager;
    FaqAdapter faqAdapter;
    public FAQ() {
        questionsList.add("\u202CQ. What sort of accommodation will be provided?");
        questionsList.add("Q. Can I purchase merchandise on arrival?");
        questionsList.add("Q. Do we have an app?");
        questionsList.add("Q. Do I have to be a college student to attend BITOTSAV'18?");
        questionsList.add("Q. Do I need to bring my Aadhar Card or any other Photo Identity card along with my College ID Card?");
        questionsList.add("Q. Where do I have food during the nights?");
        questionsList.add("Q. Can we roam around with our friends?");
        questionsList.add("Q. Is day-wise registration facility available?");
        questionsList.add("Q. How do I register for BITOTSAV'18?");
        questionsList.add("Q. Will I be provided with accommodation?");
        questionsList.add("Q. Is food included in the registration fee?");
        questionsList.add("Q. How to reach BIT Mesra?");
        answersList.add("A: Separate accommodation will be provided for boys and girls. You must provide a security deposit for blankets from which a rent will be deducted.");
        answersList.add("A: Merchandise will be provided on a first-come, first- serve basis due to limited stock.");
        answersList.add("A: Yes, we will be launching it in playstore soon.");
        answersList.add("A: Yes, BITOTSAV is only for college students.");
        answersList.add("A: Yes, participants should bring an original photo identity card (Aadhar/ Passport/ EPIC etc.) along with your college ID Card.");
        answersList.add("A: There will be a variety of stalls inside the field during the night where you can help yourself with your food of your choice.");
        answersList.add("A: Yes, the participants can roam around the campus.");
        answersList.add("A: Yes, one can register in a day-wise basis to participate in particular events of their choice. However, if the prelims and finals of the event are on different days, the participant should register for both the dates whether they qualify for the finals or not.");
        answersList.add("A: The registration process will start soon. Make sure you follow us on Facebook and remains updated. A fee will be charged and once registered, the participant can participate in all the events of BITOTSAV'18 including the nights.");
        answersList.add("A: Yes, a nominal amount would be charged for accommodation (if the participant requires it) at the time of registration. Accommodation would be separate for boys and girls.");
        answersList.add("A: You can pay for your coupons to have the food provided by the hostel mess of your accommodation. You can also help yourself in the plethora of food stalls present in the campus (till they are open) and the college canteens.");
        answersList.add("A: Participants can reach Ranchi by train or flight. The Birsa Munda Airport is 5km away from Ranchi. Regular buses are available that ply to and fro from the campus to St. Xavier's College. Private vehicles are also available from Ranchi");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_faq, container, false);

        faqRecycerView=(RecyclerView)v.findViewById(R.id.faqRecyclerView);
        faqLayoutManager=new LinearLayoutManager(getActivity());
        faqAdapter=new FaqAdapter(faqLayoutManager,faqRecycerView);
        faqRecycerView.setLayoutManager(faqLayoutManager);
        faqRecycerView.setAdapter(faqAdapter);
        return v;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
