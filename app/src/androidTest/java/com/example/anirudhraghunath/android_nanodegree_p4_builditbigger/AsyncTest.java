package com.example.anirudhraghunath.android_nanodegree_p4_builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.anirudhraghunath.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by anirudhraghunath on 05/09/16.
 */
public class AsyncTest extends AsyncTask<Void, Void, String> {
    public static MyApi backendService = null;
    private OnFetchCompleted listener;
    private Context context;

    public AsyncTest(Context context, OnFetchCompleted listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (backendService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://android-nanodegree-p4.appspot.com/_ah/api/");

            backendService = builder.build();
        }

        try {
            return backendService.fetchJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        listener.onFetched(s);
    }

    public interface OnFetchCompleted {
        void onFetched(String result);
    }
}
