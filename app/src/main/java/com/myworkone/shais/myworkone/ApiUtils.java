package com.myworkone.shais.myworkone;

/**
 * Created by shais on 01/08/2018.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://microblogging.wingnity.com/";
    public static ActorsClient getActorsClient()
    {
        return RetrofitClient.getRetrofitClient(BASE_URL).create(ActorsClient.class);
    }
}
