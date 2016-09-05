package com.example.anirudhraghunath.android_nanodegree_p4_builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.anirudhraghunath.jokerenderer.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..");
        progressDialog.show();
        EndPointAsyncTask asyncTask = new EndPointAsyncTask(MainActivity.this, new EndPointAsyncTask.OnFetchCompleted() {
            @Override
            public void onFetched(String result) {
                progressDialog.dismiss();
                startActivity(new Intent(MainActivity.this, JokeDisplayActivity.class).putExtra("joke", result));
            }
        });
        asyncTask.execute();
    }
}
