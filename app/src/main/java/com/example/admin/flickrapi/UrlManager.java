package com.example.admin.flickrapi;

import android.net.Uri;

/**
 * Created by Admin on 4/4/2018.
 */

public class UrlManager {

    private static final String TAG = UrlManager.class.getSimpleName();
    public static final String API_KEY = "5c8c6f4fe6c2fe36c6e4b1927bd94a39" ;
    public static final String PREF_SEARCH_QUERY = "searchQuery";
    private static final String ENDPOINT = "https://api.flickr.com/services/rest/" ;
    private static final String METHOD_GETRECENT = "flickr.photos.getRecent" ;
    private static final String METHOD_SEARCH = "flickr.photos.search" ;
    private static final String PARAM_EXTRAS = "extras" ;
    private static final String PARAM_TEXT = "query" ;
    private static final String PAGE = "page";
    private static final String EXTRA_SMALL_URL = "url_s" ;

    private static final String XML_PHOTO = "photo" ;

    private static volatile UrlManager instance = null;
    private UrlManager() {

    }

    public static UrlManager getInstance() {
        if (instance == null) {
            synchronized (UrlManager.class) {
                if (instance == null) {
                    instance = new UrlManager();
                }
            }
        }
        return instance;
    }

    public static String getItemUrl(String query, int page) {
        String url;
        if (query != null) {
            url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", METHOD_SEARCH)
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("text", query)
                    .appendQueryParameter("page", String.valueOf(page))
                    .build().toString();
        } else {
            url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", METHOD_GETRECENT)
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("page", String.valueOf(page))
                    .build().toString();
        }
        return url;
    }

    private static final String FLICKR_URL = "http://flickr.com/photo.gne?id=%s";
    private static final String METHOD_GETINFO = "flickr.photos.getInfo";

    public static String getFlickrUrl(String id) {
        return String.format(FLICKR_URL, id);
    }

    public static String getPhotoInfoUrl(String id) {
        return Uri.parse(ENDPOINT).buildUpon()
                .appendQueryParameter("method", METHOD_GETINFO)
                .appendQueryParameter("api_key", API_KEY)
                .appendQueryParameter("format", "json")
                .appendQueryParameter("nojsoncallback", "1")
                .appendQueryParameter("photo_id", id)
                .build().toString();
    }
}
