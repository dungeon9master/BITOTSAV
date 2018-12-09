package com.example.mayank.bitotsav;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    ArrayAdapter namesAdapter;
    Context context;
    RecyclerView contactsRecyclerView;
    int a[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    ContactsAdapter(Context context, RecyclerView contactsRecyclerView) {
        Log.d("jf", "hgvhjj");
        this.context = context;
        this.contactsRecyclerView = contactsRecyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_card_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position == 0) {
            holder.post.setText("Student Co-ordinators");
        } else if (position == 2) {
            holder.post.setText("Publicity");
        } else if (position == 3) {
            holder.post.setText("Web");
        } else if (position == 4) {
            holder.post.setText("Finance & Sponsorship");
        } else if (position == 1) {
            holder.post.setText("Events");
        }
        holder.post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[position] = a[position] + 1;
                if (position == 0) {
                    for (int i = 0; i < 9; i++) {
                        if (a[i] > 0 && position != i) {
                            contactsRecyclerView.getChildAt(i).findViewById(R.id.namesListView).setVisibility(View.GONE);
                            //a[position]=0;
                        }
                    }
                    List<String> postOneName = new ArrayList<String>();
                    postOneName.add("Rishav");
                    postOneName.add("Komal Gupta");
                    namesAdapter = new ArrayAdapter(context, R.layout.contacts_listview_item,R.id.header_text, postOneName);
                    holder.namesListView.setAdapter(namesAdapter);
                    RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.namesListView.getLayoutParams();
                    list.height = holder.namesListView.getAdapter().getCount() * 100;
                    holder.namesListView.setVisibility(View.VISIBLE);

                    holder.namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //     Toast.makeText(context, holder.post.getText().toString(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context, PersonDeatails.class);

                            intent.putExtra("Name", (String) adapterView.getItemAtPosition(i));
                            context.startActivity(intent);
                        }
                    });
                } else if (position == 1) {

                    for (int i = 0; i < 9; i++) {
                        if (a[i] > 0 && position != i) {
                            contactsRecyclerView.getChildAt(i).findViewById(R.id.namesListView).setVisibility(View.GONE);

                        }
                    }
                    List<String> postOneName = new ArrayList<String>();
                    postOneName.add("Greeshma Mathew");
                    postOneName.add("Aditi Srivastava");
                    namesAdapter = new ArrayAdapter(context,R.layout.contacts_listview_item,R.id.header_text, postOneName);
                    holder.namesListView.setAdapter(namesAdapter);
                    RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.namesListView.getLayoutParams();
                    list.height = holder.namesListView.getAdapter().getCount() * 100;
                    holder.namesListView.setVisibility(View.VISIBLE);

                    holder.namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            // Toast.makeText(context, holder.post.getText().toString(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context, PersonDeatails.class);

                            intent.putExtra("Name", (String) adapterView.getItemAtPosition(i));
                            context.startActivity(intent);
                        }
                    });
                } else if (position == 2) {

                    for (int i = 0; i < 9; i++) {
                        if (a[i] > 0 && position != i) {
                            contactsRecyclerView.getChildAt(i).findViewById(R.id.namesListView).setVisibility(View.GONE);
                            //  a[position]=0;
                        }
                    }
                    List<String> postTwoName = new ArrayList<String>();
                    postTwoName.add("Pratyush Prakash");
                    postTwoName.add("Aditi Srivastava");
                    namesAdapter = new ArrayAdapter(context, R.layout.contacts_listview_item,R.id.header_text, postTwoName);
                    holder.namesListView.setAdapter(namesAdapter);
                    RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.namesListView.getLayoutParams();
                    list.height = holder.namesListView.getAdapter().getCount() * 100;
                    holder.namesListView.setVisibility(View.VISIBLE);

                    holder.namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //   Toast.makeText(context, holder.post.getText().toString(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context, PersonDeatails.class);

                            intent.putExtra("Name", (String) adapterView.getItemAtPosition(i));
                            context.startActivity(intent);
                        }
                    });
                } else if (position == 3) {

                    for (int i = 0; i < 9; i++) {
                        if (a[i] > 0 && position != i) {
                            contactsRecyclerView.getChildAt(i).findViewById(R.id.namesListView).setVisibility(View.GONE);
                            //   a[position]=0;
                        }
                    }
                    List<String> postThreeName = new ArrayList<String>();
                    postThreeName.add("Aditya Vikram Singh");
                    postThreeName.add("Maloy Rakshit");
                    namesAdapter = new ArrayAdapter(context,R.layout.contacts_listview_item,R.id.header_text, postThreeName);
                    holder.namesListView.setAdapter(namesAdapter);
                    RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.namesListView.getLayoutParams();
                    list.height = holder.namesListView.getAdapter().getCount() * 100;
                    holder.namesListView.setVisibility(View.VISIBLE);
                    holder.namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //   Toast.makeText(context, holder.post.getText().toString(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context, PersonDeatails.class);

                            intent.putExtra("Name", (String) adapterView.getItemAtPosition(i));
                            context.startActivity(intent);
                        }
                    });

                } else if (position == 4) {

                    for (int i = 0; i < 9; i++) {
                        if (a[i] > 0 && position != i) {
                            contactsRecyclerView.getChildAt(i).findViewById(R.id.namesListView).setVisibility(View.GONE);

                        }
                    }
                    List<String> postFourName = new ArrayList<String>();
                    postFourName.add("Kislay Jha");
                    namesAdapter = new ArrayAdapter(context, R.layout.contacts_listview_item,R.id.header_text, postFourName);
                    holder.namesListView.setAdapter(namesAdapter);
                    RelativeLayout.LayoutParams list = (RelativeLayout.LayoutParams) holder.namesListView.getLayoutParams();
                    list.height = holder.namesListView.getAdapter().getCount() * 100;
                    holder.namesListView.setVisibility(View.VISIBLE);

                    holder.namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //   Toast.makeText(context, holder.post.getText().toString(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context, PersonDeatails.class);
                            intent.putExtra("Name", (String) adapterView.getItemAtPosition(i));
//                            Log.d("name",(String)adapterView.getItemAtPosition(i));
                            context.startActivity(intent);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView post;
        ListView namesListView;

        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.post);
            namesListView = (ListView) itemView.findViewById(R.id.namesListView);
        }
    }
}
