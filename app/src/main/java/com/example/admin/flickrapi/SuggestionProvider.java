package com.example.admin.flickrapi;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by Admin on 4/4/2018.
 */

public class SuggestionProvider extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY = "com.example.admin.flickrapi" +
            ".SuggestionProvider";

    public static final int MODE = DATABASE_MODE_QUERIES;

    public SuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
