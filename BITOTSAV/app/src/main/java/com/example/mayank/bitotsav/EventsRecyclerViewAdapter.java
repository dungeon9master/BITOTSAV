package com.example.mayank.bitotsav;


import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder> {
    EventFragment eventFragment;
    LinearLayoutManager linearLayoutManager;
    int a[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Context context;
    JSONObject jsonObject;
    RecyclerView eventsRecyclerView;
    int fine;
    JSONArray jsonArray;

    public EventsRecyclerViewAdapter(Context context, EventFragment eventFragment, LinearLayoutManager linearLayoutManager, RecyclerView eventsRecyclerView, JSONArray json) {
        this.context = context;
        this.eventFragment = eventFragment;
        this.linearLayoutManager = linearLayoutManager;
        this.eventsRecyclerView = eventsRecyclerView;
        jsonArray = json;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_card_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//            @Override
//            public void onClick(View view) {
//                holder.foldingCell.toggle(false);
//
//                if (position > (linearLayoutManager.findLastCompletelyVisibleItemPosition() - linearLayoutManager.findFirstCompletelyVisibleItemPosition()) / 2) {
//                    linearLayoutManager.setStackFromEnd(true);
//                } else {
//                    linearLayoutManager.setStackFromEnd(false);
//                }
//            }
//        });
//        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                linearLayoutManager.scrollToPositionWithOffset(position, 0);
//                holder.foldingCell.toggle(true);
//            }
//        });

                 try {

            jsonObject = jsonArray.getJSONObject(position);
            holder.eventName.setText(jsonObject.getString("Event"));

        } catch (JSONException e) {

        }
        holder.eventName.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
Intent intent=new Intent(context,EventDescriptionAndRules.class);
             try {
                 intent.putExtra("eventsJson",jsonArray.getJSONObject(position).toString());
             } catch (JSONException e) {

             }
             context.startActivity(intent);
         }
     });
    //    try {


//            holder.description.setText(jsonObject.getString("description"));
//            holder.rules.setText(jsonObject.getString("rules"));
//            holder.eventNameBefore.setText(jsonObject.getString("Event"));
//            holder.venue.setText(jsonObject.getString("venue"));
//            holder.startAndEndTime.setText(jsonObject.getString("Start time") + "/" + jsonObject.getString("End Time"));
  //      } catch (JSONException e) {

//        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FoldingCell foldingCell;
        TextView eventName, description, rules, venue, startAndEndTime, eventNameBefore;

        public ViewHolder(final View itemView) {
            super(itemView);
            eventName = (TextView) itemView.findViewById(R.id.eventName);
//            description = (TextView) itemView.findViewById(R.id.description);
//            rules = (TextView) itemView.findViewById(R.id.rules);
//            venue = (TextView) itemView.findViewById(R.id.venue);
//            startAndEndTime = (TextView) itemView.findViewById(R.id.startAndEndTime);
//            foldingCell = (FoldingCell) itemView.findViewById(R.id.folding_cell);
//            eventNameBefore = (TextView) itemView.findViewById(R.id.eventNameBefore);
        }

    }
}