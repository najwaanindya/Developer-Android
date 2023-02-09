package com.example.whowroteitloader;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;

public class BookLoader extends Loader<String> {
    private String mQueryString;

    BookLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}
