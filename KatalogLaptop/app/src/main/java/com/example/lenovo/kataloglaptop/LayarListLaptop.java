package com.example.lenovo.kataloglaptop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.kataloglaptop.Adapter.LaptopAdapter;
import com.example.lenovo.kataloglaptop.Model.GetLaptop;
import com.example.lenovo.kataloglaptop.Model.Laptop;
import com.example.lenovo.kataloglaptop.Rest.ApiClient;
import com.example.lenovo.kataloglaptop.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListLaptop extends OpsiMenu {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;
    Button btAddData, btGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_laptop);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btGet = (Button) findViewById(R.id.btGet);
        btAddData = (Button) findViewById(R.id.btAddData);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<GetLaptop> mLaptopCall = mApiInterface.getLaptop();
                mLaptopCall.enqueue(new Callback<GetLaptop>() {
                    @Override
                    public void onResponse(Call<GetLaptop> call, Response<GetLaptop> response) {
                        Log.d("Get Laptop",response.body().getStatus());
                        List<Laptop> listLaptop = response.body().getResult();
                        mAdapter = new LaptopAdapter(listLaptop);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetLaptop> call, Throwable t) {
                        Log.d("Get Laptop",t.getMessage());
                    }
                });
            }
        });

        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LayarInsertLaptop.class);
                startActivity(intent);
            }
        });

    }
}
