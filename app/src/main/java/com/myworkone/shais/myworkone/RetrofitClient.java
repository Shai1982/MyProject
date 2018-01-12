package com.myworkone.shais.myworkone;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shais on 01/08/2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;
//    public static final String URL = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";

    public static Retrofit getRetrofitClient(String baseUrl)
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
