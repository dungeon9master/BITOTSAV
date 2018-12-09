package com.example.mayank.bitotsav;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class RecyclerViewInNavigationViewAdapter extends RecyclerView.Adapter<RecyclerViewInNavigationViewAdapter.ViewHolder> {
    List<String> textInNavigationViewList = new ArrayList<String>();
    List<String> dayNumberList = new ArrayList<String>();
    Context context;
    ViewPager viewPager;
    int itemClicked;
    Fragment fragment = null;
    int a[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    MainActivity mainActivity;
    int count = 0;
    ArrayAdapter dayListAdapter;
    DrawerLayout drawerLayout;
    CircleIndicator circularIndicator;
    RecyclerView recyclerViewInNavigationView;

    RecyclerViewInNavigationViewAdapter(Context context, DrawerLayout drawer, ViewPager viewPager, CircleIndicator circularIndicator, RecyclerView recyclerViewInNavigationView) {
        textInNavigationViewList.add("HOME");
        textInNavigationViewList.add("EVENTS");
        textInNavigationViewList.add("CONTACTS");
        textInNavigationViewList.add("MAPS");
        textInNavigationViewList.add("FAQ's");
        dayNumberList.add("DAY 1");
        this.recyclerViewInNavigationView = recyclerViewInNavigationView;
        dayNumberList.add("DAY 2");
        dayNumberList.add("DAY 3");
        this.viewPager = viewPager;

        this.circularIndicator = circularIndicator;
        dayNumberList.add("DAY 4");
        dayListAdapter = new ArrayAdapter(context, R.layout.navigation_list_view_item,R.id.navigation_item, dayNumberList);
        this.context = context;
        mainActivity = (MainActivity) context;
        drawerLayout = drawer;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigationview_card_view, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.specificationsTextView.setText(textInNavigationViewList.get(position));
        if (position == 0) {
            holder.iconImage.setBackgroundResource(R.drawable.friends_icon);
        } else if (position == 1) {
            holder.iconImage.setBackgroundResource(R.drawable.narcos_icon);
        } else if (position == 2) {
            holder.iconImage.setBackgroundResource(R.drawable.stranger_icon);
        } else if (position == 3) {
            holder.iconImage.setBackgroundResource(R.drawable.breaking_icon);
        } else if (position == 4) {
            holder.iconImage.setBackgroundResource(R.drawable.suits_icon);
        }
        holder.cardViewInNavigationView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


//                    if (count == 0) {
//                        holder.dayNumberListView.setVisibility(View.VISIBLE);
//                        count = 1;
//                    } else if (count == 1) {
//               //         holder.dayNumberListView.setVisibility(View.GONE);
//                        count = 0;
//                    }
//                  Toast.makeText(context,"ARE",Toast.LENGTH_SHORT).show();
//                if (a[position] == 0) {
//                    a[position] = a[position] + 1;
//
//                    holder.dayNumberListView.setAdapter(dayListAdapter);
//
//                    RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.dayNumberListView.getLayoutParams();
//                    RelativeLayout.LayoutParams card = (RelativeLayout.LayoutParams) holder.cardViewInNavigationView.getLayoutParams();
//                    card.addRule(RelativeLayout.SCROLL_INDICATOR_TOP, RelativeLayout.TRUE);
//                    list.height = holder.dayNumberListView.getAdapter().getCount() * 100;
//                    holder.dayNumberListView.setLayoutParams(list);
//                    holder.cardViewInNavigationView.setLayoutParams(card);
//
//                    holder.dayNumberListView.setVisibility(View.VISIBLE);
//                    Log.d("asaa", String.valueOf(holder.dayNumberListView.getHeight()));
//
//                } else if (a[position] == 1) {
//                    holder.dayNumberListView.setVisibility(View.GONE);
//                    a[position] = a[position] - 1;
//                }

                if (position == 1) {
                    if (count == 0) {
                        holder.dayNumberListView.setVisibility(View.VISIBLE);
                        holder.dayNumberListView.setAdapter(dayListAdapter);
                        count = 1;

                        RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.dayNumberListView.getLayoutParams();
                        list.height = holder.dayNumberListView.getAdapter().getCount() * 100;
                    } else if (count == 1) {
                        count = 0;
                        holder.dayNumberListView.setVisibility(View.GONE);
                    }
                    holder.dayNumberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            itemClicked = i + 1;
                            holder.dayNumberListView.setVisibility(View.GONE);
                            apiCall();

//        Bundle bundle = new Bundle();
//                            bundle.putString("item", String.valueOf(i + 1));
//                            fragment = new EventFragment();
//                            fragment.setArguments(bundle);
//                            FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
//                            fragmentTransaction.replace(R.id.group, fragment);
//                            fragmentTransaction.commit();
//                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                    });
                } else if (position == 2) {
                    fragment = new ContactsFragment();
                    FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.group, fragment);
                    fragmentTransaction.commit();
                    viewPager.setVisibility(View.GONE);
                    circularIndicator.setVisibility(View.GONE);


                    if (count == 1) {
                        recyclerViewInNavigationView.getChildAt(1).findViewById(R.id.listInNavigationView).setVisibility(View.GONE);
                        count = 0;
                    }

                    drawerLayout.closeDrawer(GravityCompat.START);


                } else if (position == 3) {
                    fragment = new MapsFragment();
                    FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
                    if (count == 1) {

                        recyclerViewInNavigationView.getChildAt(1).findViewById(R.id.listInNavigationView).setVisibility(View.GONE);
                        count = 0;
                    }
                    fragmentTransaction.replace(R.id.group, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);


                } else if (position == 0) {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                } else if (position == 4) {
                    viewPager.setVisibility(View.GONE);
                    circularIndicator.setVisibility(View.GONE);

                    fragment = new FAQ();
                    FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
                    if (count == 1) {

                        recyclerViewInNavigationView.getChildAt(1).findViewById(R.id.listInNavigationView).setVisibility(View.GONE);
                        count = 0;
                    }
                    fragmentTransaction.replace(R.id.group, fragment);
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);


                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return textInNavigationViewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView specificationsTextView;
        CardView cardViewInNavigationView;
        ListView dayNumberListView;
        ImageView iconImage;

        public ViewHolder(View itemView) {
            super(itemView);
            specificationsTextView = (TextView) itemView.findViewById(R.id.textInNavigationView);
            cardViewInNavigationView = (CardView) itemView.findViewById(R.id.cardViewInNavigationView);
            dayNumberListView = (ListView) itemView.findViewById(R.id.listInNavigationView);
            iconImage = (ImageView) itemView.findViewById(R.id.iconsInNavigationView);
        }

    }

    void apiCall() {
        JSONParse jsonoParse = new JSONParse();
        jsonoParse.execute();
    }

    private class JSONParse extends AsyncTask<String, String, JSONArray> {

        private ProgressDialog dialog = new ProgressDialog(context);


        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Please wait");
            this.dialog.show();

        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            Log.d("we", jsonArray.toString());
            if (dialog.isShowing()) {
                dialog.dismiss();

                viewPager.setVisibility(View.GONE);
                circularIndicator.setVisibility(View.GONE);
                Bundle bundle = new Bundle();
                bundle.putString("jsonArray", String.valueOf(jsonArray));
                fragment = new EventFragment();
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.group, fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {

        }

        @Override
        protected JSONArray doInBackground(String... strings) {
            jsonParser jparser = new jsonParser();
            String url = "http://bitotsav.in:5498/events_web/cmfromarchimc/" + String.valueOf(itemClicked);
            JSONArray json = jparser.getJsonFromUrl(url);

            return json;

        }
    }
}