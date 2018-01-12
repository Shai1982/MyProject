package com.myworkone.shais.myworkone;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shais on 01/08/2018.
 */

public interface ActorsClient {

    @GET("/JSONParsingTutorial/jsonActors")
    Call<ListOfActors> getActors();
}
