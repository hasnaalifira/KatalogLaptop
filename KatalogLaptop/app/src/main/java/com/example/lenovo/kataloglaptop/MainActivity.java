package com.example.lenovo.kataloglaptop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.kataloglaptop.Adapter.MyAdapter;
import com.example.lenovo.kataloglaptop.Model.GetSuka;
import com.example.lenovo.kataloglaptop.Model.Suka;
import com.example.lenovo.kataloglaptop.Rest.ApiClient;
import com.example.lenovo.kataloglaptop.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends OpsiMenu {
    Button btGet;
    ApiInterface mApiInterface;

    private RecyclerView mRecyclerView;
    private  RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGet = (Button) findViewById(R.id.btGet);

        mRecyclerView =  (RecyclerView) findViewById(R.id.recyclerView);
        mlayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mlayoutManager);

        mApiInterface  = ApiClient.getClient().create(ApiInterface.class);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<GetSuka> sukaCall = mApiInterface.getSuka();
                sukaCall.enqueue(new Callback<GetSuka>() {
                    @Override
                    public void onResponse(Call<GetSuka> call, Response<GetSuka> response) {
                        List<Suka> sukaList = response.body().getListDataSuka();
                        Log.d("Retrofit Get", "Jumlah data suka: " + String.valueOf(sukaList.size()));

                        mAdapter = new MyAdapter(sukaList);
                        mRecyclerView.setAdapter(mAdapter);
                    }



                    @Override
                    public void onFailure(Call<GetSuka> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
    }
}
