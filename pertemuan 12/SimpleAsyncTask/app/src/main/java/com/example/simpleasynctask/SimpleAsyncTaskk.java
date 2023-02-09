package com.example.simpleasynctask;

import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTaskk implements SimpleAsyncTask {
    private WeakReference<TextView> mTextView;

    SimpleAsyncTaskk(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    public String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    public void execute() {
    }
}

