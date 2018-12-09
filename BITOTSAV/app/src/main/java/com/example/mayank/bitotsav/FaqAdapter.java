package com.example.mayank.bitotsav;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

    List<String> questionsList = new ArrayList<String>();
    List<String> answersList = new ArrayList<String>();
LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    FaqAdapter(LinearLayoutManager layoutManager,RecyclerView recyclerView) {
this.layoutManager=layoutManager;
        this.recyclerView=recyclerView;
        questionsList.add("Q. What sort of accommodation will be provided?");
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.answer.setText(answersList.get(position));
        holder.questions.setText(questionsList.get(position));
        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //layoutManager.scrollToPositionWithOffset(position,0);

                holder.foldingCell.toggle(true);

            }
        });
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FoldingCell foldingCell;
        TextView questions, answer;

        public ViewHolder(View itemView) {
            super(itemView);
            foldingCell = (FoldingCell) itemView.findViewById(R.id.folding_cell);
            questions = (TextView) itemView.findViewById(R.id.question);
            answer = (TextView) itemView.findViewById(R.id.answer);
        }
    }
}
