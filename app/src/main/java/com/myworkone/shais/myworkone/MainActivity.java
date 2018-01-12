package com.myworkone.shais.myworkone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ActorsClient actorsClient;
    private ActorsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actorsClient = ApiUtils.getActorsClient();
        recyclerView = findViewById(R.id.my_recycler_view);
        getActorsList();
    }

    private void getActorsList() {
        actorsClient.getActors().enqueue(new Callback<ListOfActors>() {
            @Override
            public void onResponse(Call<ListOfActors> call, Response<ListOfActors> response) {

                if(response.isSuccessful()) {
//                    adapter.updateActorsList(response.body().getActors());
                    Log.d("MainActivity", "Actors list loaded");

                    adapter = new ActorsAdapter(response.body().getActors(), MainActivity.this);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.HORIZONTAL);
                    recyclerView.addItemDecoration(itemDecoration);
                }else {
                    int statusCode  = response.code();
                    switch (statusCode) {
                        case 404:
                            Toast.makeText(MainActivity.this, "not found " + statusCode, Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", "" + statusCode);

                            break;
                        case 500:
                            Toast.makeText(MainActivity.this, "server broken " + statusCode, Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", "" + statusCode);

                            break;
                        default:
                            Toast.makeText(MainActivity.this, "unknown error " + statusCode, Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", "" + statusCode);

                            break;
                    }


                }
            }

            @Override
            public void onFailure(Call<ListOfActors> call, Throwable t) {
                Log.d("MainActivity", "" + t.getMessage());
            }
        });
    }
}
