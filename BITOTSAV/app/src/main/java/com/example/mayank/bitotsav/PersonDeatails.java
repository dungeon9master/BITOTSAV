package com.example.mayank.bitotsav;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PersonDeatails extends AppCompatActivity {
    TextView callNumber, mailText, personName;
    ImageView callMe, facebook, personImage;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(PersonDeatails.this, MainActivity.class);
                intent.putExtra("fromPersonClass", "from");
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_deatails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        callNumber = (TextView) findViewById(R.id.callNumber);
        mailText = (TextView) findViewById(R.id.mailText);
        callMe = (ImageView) findViewById(R.id.callMe);
        facebook = (ImageView) findViewById(R.id.facebook);
        personImage = (ImageView) findViewById(R.id.personImage);
        personName = (TextView) findViewById(R.id.personName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

        if (name.equals("Rishav")) {
            callNumber.setText("8804010462");
            personName.setText("Rishav");
            personImage.setImageResource(R.drawable.rishav);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "8804010462"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/rishav.1907");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Greeshma Mathew")) {
            callNumber.setText("8804010462");
            personName.setText("Greeshma Mathew");
            personImage.setImageResource(R.drawable.gereeshma);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "8804010462"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/greesh1011?ref=br_rs");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Pratyush Prakash")) {
            callNumber.setText("9955910141");
            personName.setText("Pratyush Prakash");
            personImage.setImageResource(R.drawable.pratyush);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9955910141"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/pratyush.prakash.568");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Zainab Feroz")) {
            callNumber.setText("9955910141");
            personName.setText("Zainab Feroz");
            personImage.setImageResource(R.drawable.zainab);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9955910141"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/zainab606");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Aditi Srivastava")) {
            callNumber.setText("9955910141");
            personName.setText("Aditi Srivastava");
            personImage.setImageResource(R.drawable.aditi);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9955910141"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/aditi.srivastava.94214");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Aditya Vikram Singh")) {
            callNumber.setText("99931801313");
            personName.setText("Aditya Vikram Singh");
            personImage.setImageResource(R.drawable.aditya);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "99931801313"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/ADITYAIZGREAT");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Maloy Rakshit")) {
            callNumber.setText("9006083548");
            personName.setText("Maloy Rakshit");
            personImage.setImageResource(R.drawable.maloy);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9006083548"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/maloy.rakshit");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Kislay Jha")) {
            callNumber.setText("7979075489");
            personName.setText("Kislay Jha");
            personImage.setImageResource(R.drawable.kislay);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "7979075489"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/search/top/?q=kislay%20jah");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else if (name.equals("Komal Gupta")) {
            callNumber.setText("7541921920");
            personName.setText("Komal Gupta");
            personImage.setImageResource(R.drawable.komal);
            callMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "7541921920"));
                    startActivity(intent);
                }
            });
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com/komal.gupta.505");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        }
    }

}
