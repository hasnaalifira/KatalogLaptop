package com.example.lenovo.kataloglaptop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.kataloglaptop.Model.PostPutDelSuka;
import com.example.lenovo.kataloglaptop.Rest.ApiClient;
import com.example.lenovo.kataloglaptop.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarDetail extends AppCompatActivity {
    EditText edtIdSuka, edtIdLaptop, edtIdUser;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_detail);

        edtIdSuka = (EditText) findViewById(R.id.edtIdSuka);
        edtIdLaptop = (EditText) findViewById(R.id.edtIdLaptop);
        edtIdUser = (EditText) findViewById(R.id.edtIdUser);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);

        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);

        Intent mIntent = getIntent();
        edtIdSuka.setText(mIntent.getStringExtra("id_suka"));
        edtIdLaptop.setText(mIntent.getStringExtra("id_laptop"));
        edtIdUser.setText(mIntent.getStringExtra("id_user"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelSuka> updateSukaCall = mApiInterface.putSuka(
                        edtIdSuka.getText().toString(),
                        edtIdLaptop.getText().toString(),
                        edtIdUser.getText().toString());

                updateSukaCall.enqueue(new Callback<PostPutDelSuka>() {
                    @Override
                    public void onResponse(Call<PostPutDelSuka> call, Response<PostPutDelSuka> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : " +response.body().getStatus() +
                                "\n " + " Message Update : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelSuka> call, Throwable t) {
                        tvMessage.setText("Retrofit Update: \n Status Update :"+ t.getMessage());
                    }
                });
            }
        });

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelSuka> postSukaCall = mApiInterface.postSuka(
                        edtIdSuka.getText().toString(),
                        edtIdLaptop.getText().toString(),
                        edtIdUser.getText().toString());

                postSukaCall.enqueue(new Callback<PostPutDelSuka>() {
                    @Override
                    public void onResponse(Call<PostPutDelSuka> call, Response<PostPutDelSuka> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : " +
                                response.body().getStatus() +
                                "\n " + " Message Insert : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelSuka> call, Throwable t) {
                        tvMessage.setText("Retrofit Insert: \n Status Insert :"+ t.getMessage());
                    }
                });
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtIdSuka.getText().toString().trim().isEmpty()){

                    Call<PostPutDelSuka> deleteSuka = mApiInterface.deleteSuka(edtIdSuka.getText().toString());
                    deleteSuka.enqueue(new Callback<PostPutDelSuka>() {
                        @Override
                        public void onResponse(Call<PostPutDelSuka> call, Response<PostPutDelSuka> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : " +response.body().getStatus() +
                                    "\n " + " Message Delete : "+ response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<PostPutDelSuka> call, Throwable t) {
                            tvMessage.setText("Retrofit Delete: \n Status Delete :"+ t.getMessage());
                        }
                    });
                }else{
                    tvMessage.setText("id_suka harus diisi");
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
