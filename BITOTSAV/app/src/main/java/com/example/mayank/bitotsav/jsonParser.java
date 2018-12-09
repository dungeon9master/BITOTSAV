package com.example.mayank.bitotsav;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class jsonParser {
    HttpURLConnection urlConnection = null;

    static InputStream is = null;

    public JSONArray getJsonFromUrl(String web) {
   Log.d("as",web);
        try {
            URL url = new URL(web);
            urlConnection = (HttpURLConnection) url.openConnection();
            is = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(is);

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
      //    Log.d("as",responseStrBuilder.toString());
            JSONArray jsonObject = new JSONArray(responseStrBuilder.toString());
            Log.d("pp",jsonObject.toString());
            return jsonObject;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
