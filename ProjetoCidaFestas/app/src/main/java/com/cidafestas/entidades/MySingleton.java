package com.cidafestas.entidades;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRquestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private MySingleton(Context context){
        mCtx = context;
        mRquestQueue = getRequestQueue();
    }


    public static synchronized MySingleton getInstance(Context context){
        if(mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }


    private RequestQueue getRequestQueue() {
        if(mRquestQueue == null){
            mRquestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRquestQueue;
    }

    public<T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }


}
