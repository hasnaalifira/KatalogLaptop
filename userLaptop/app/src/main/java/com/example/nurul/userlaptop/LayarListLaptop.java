package com.example.nurul.userlaptop;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.nurul.userlaptop.Rest.ApiClient;
import com.example.nurul.userlaptop.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListLaptop extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_laptop);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.list_data_laptop);
//        LaptopAdapter laptopAdapter = new LaptopAdapter(this, Laptop);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        final LaptopAdapter laptopAdapter = new LaptopAdapter(this, Laptop);
//        mRecyclerView.setAdapter(mAdapter);


//        mRecyclerView.setOnLongClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Laptop laptop = Laptop[position];
//                Laptop.toggleFavorite();
//
//                // This tells the GridView to redraw itself
//                // in turn calling your MovieAdapter's getView method again for each cell
//                mAdapter.notifyDataSetChanged();
//            }
//        });

        dapatkanData();
    }

    private void dapatkanData() {
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<GetLaptop> mLaptopCall = mApiInterface.getLaptop();
        mLaptopCall.enqueue(new Callback<GetLaptop>() {
            @Override
            public void onResponse(Call<GetLaptop> call, Response<GetLaptop> response) {
                Log.d("GetLaptop",String.valueOf(response.body().getResult()));
                List<Laptop> listLaptop = response.body().getResult();
                mAdapter = new LaptopAdapter(listLaptop, LayarListLaptop.this);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<GetLaptop> call, Throwable  t) {
                Log.d("Get Laptop",t.getMessage());
            }
        });



    }
}
