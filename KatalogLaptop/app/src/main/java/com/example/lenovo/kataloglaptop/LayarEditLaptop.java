package com.example.lenovo.kataloglaptop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.kataloglaptop.Model.GetLaptop;
import com.example.lenovo.kataloglaptop.Rest.ApiClient;
import com.example.lenovo.kataloglaptop.Rest.ApiInterface;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarEditLaptop extends AppCompatActivity {
    ImageView mPhotoUrl;
    EditText edtIdLaptop, edtMerk, edtTipe, edtRam, edtProcessor, edtWarna, edtHarga;
    TextView tvMessage;
    Context mContext;
    Button btUpdate, btDelete, btBack, btPhotoUrl;
    String pathImage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_edit_laptop);

        mContext = getApplicationContext();

        mPhotoUrl = (ImageView) findViewById(R.id.imgPhotoId);
        edtIdLaptop = (EditText) findViewById(R.id.edtIdLaptop);
        edtMerk = (EditText) findViewById(R.id.edtMerkLaptop);
        edtTipe = (EditText) findViewById(R.id.edtTipeLaptop);
        edtRam = (EditText) findViewById(R.id.edtRamLaptop);
        edtProcessor = (EditText) findViewById(R.id.edtProcessorLaptop);
        edtWarna = (EditText) findViewById(R.id.edtWarnaLaptop);
        edtHarga = (EditText) findViewById(R.id.edtHargaLaptop);

        tvMessage = (TextView) findViewById(R.id.tvMessage);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btBack = (Button) findViewById(R.id.btBack);
        btPhotoUrl = (Button) findViewById(R.id.btPhotoId);

        Intent mIntent = getIntent();

        edtIdLaptop.setText(mIntent.getStringExtra("id_laptop"));
        edtMerk.setText(mIntent.getStringExtra("merk"));
        edtTipe.setText(mIntent.getStringExtra("tipe"));
        edtRam.setText(mIntent.getStringExtra("ram"));
        edtProcessor.setText(mIntent.getStringExtra("processor"));
        edtWarna.setText(mIntent.getStringExtra("warna"));
        edtHarga.setText(mIntent.getStringExtra("harga"));

//        if (mIntent.getStringExtra("photo_url").length()>0) Picasso.with(mContext).load
// (ApiClient.BASE_URL + mIntent.getStringExtra("photo_url")).into(mPhotoUrl);
//        else Picasso.with(mContext).load(R.drawable.photoid).into(mPhotoUrl);
        if (mIntent.getStringExtra("photo_url") != null)
            Glide.with(mContext).load(ApiClient.BASE_URL +
                    mIntent.getStringExtra("photo_url")).into(mPhotoUrl);


//        Glide.with(mContext).load(ApiClient
//                    .BASE_URL + mIntent.getStringExtra("photo_url")).into(mPhotoUrl);
        else
            Glide.with(mContext).load(R.drawable.laptop).into(mPhotoUrl);

        pathImage = mIntent.getStringExtra("photo_url");
        setListener();
    }

    private void setListener() {
        final ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MultipartBody.Part body = null;
                //dicek apakah image sama dengan yang ada di server atau berubah
                //jika sama dikirim lagi jika berbeda akan dikirim ke server
                if ((!pathImage.contains( "uploads/" )) && (!pathImage.isEmpty())){

//                    if ((!pathImage.contains("upload/" + edtIdLaptop.getText().toString())) &&
//                        (pathImage.length()>0)){
                    //File creating from selected URL
                    File file = new File(pathImage);

                    // create RequestBody instance from file
                    RequestBody requestFile = RequestBody.create(
                            MediaType.parse("multipart/form-data"), file);

                    // MultipartBody.Part is used to send also the actual file name
                    body = MultipartBody.Part.createFormData("photo_url", file.getName(),
                            requestFile);
                }

                RequestBody reqIdLaptop =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtIdLaptop.getText().toString().isEmpty())?
                                        "" : edtIdLaptop.getText().toString());

                RequestBody reqMerk =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtMerk.getText().toString().isEmpty())?
                                        "" : edtMerk.getText().toString());

                RequestBody reqTipe =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtTipe.getText().toString().isEmpty())?
                                        "" : edtTipe.getText().toString());

                RequestBody reqRam =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtRam.getText().toString().isEmpty())?
                                        "" : edtRam.getText().toString());
                RequestBody reqProcessor =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtProcessor.getText().toString().isEmpty())?
                                        "" : edtProcessor.getText().toString());
                RequestBody reqWarna =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtWarna.getText().toString().isEmpty())?
                                        "" : edtWarna.getText().toString());
                RequestBody reqHarga =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtHarga.getText().toString().isEmpty())?
                                        "" : edtHarga.getText().toString());

                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"), "update");

                Call<GetLaptop> callUpdate = mApiInterface.putLaptop(body, reqIdLaptop, reqMerk,
                        reqTipe, reqRam, reqProcessor, reqWarna, reqHarga, reqAction);

                callUpdate.enqueue(new Callback<GetLaptop>() {
                    @Override
                    public void onResponse(Call<GetLaptop> call, Response<GetLaptop> response) {
                        //Log.d("Update Retrofit ", response.body().getStatus());
                        if (response.body().getStatus().equals("failed")){
                            tvMessage.setText("Retrofit Update \n Status = " + response.body()
                                    .getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+
                                    "id_laptop = "+response.body().getResult().get(0).getIdLaptop()+"\n"+
                                    "merk = "+response.body().getResult().get(0).getMerk()+"\n"+
                                    "tipe = "+response.body().getResult().get(0).getTipe()+"\n"+
                                    "ram = "+response.body().getResult().get(0).getRam()+"\n"+
                                    "processor = "+response.body().getResult().get(0).getProcessor()+"\n"+
                                    "warna = "+response.body().getResult().get(0).getWarna()+"\n"+
                                    "harga = "+response.body().getResult().get(0).getHarga()+"\n"+
                                    "photo_url = "+response.body().getResult().get(0).getPhotoUrl()
                                    +"\n";
                            tvMessage.setText("Retrofit Update \n Status = "+response.body().getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+detail);
                        }
                    }

                    @Override
                    public void onFailure(Call<GetLaptop> call, Throwable t) {
                        //Log.d("Update Retrofit ", t.getMessage());
                        tvMessage.setText("Retrofit Update \n Status = "+ t.getMessage());
                    }
                });

            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody reqIdLaptop =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtIdLaptop.getText().toString().isEmpty())?
                                        "" : edtIdLaptop.getText().toString());
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"), "delete");

                Call<GetLaptop> callDelete = mApiInterface.deleteLaptop(reqIdLaptop,reqAction);
                callDelete.enqueue(new Callback<GetLaptop>() {
                    @Override
                    public void onResponse(Call<GetLaptop> call, Response<GetLaptop> response) {
                        tvMessage.setText("Retrofit Delete \n Status = "+response.body()
                                .getStatus() +"\n"+
                                "Message = "+response.body().getMessage()+"\n");
                    }

                    @Override
                    public void onFailure(Call<GetLaptop> call, Throwable t) {
                        tvMessage.setText("Retrofit Delete \n Status = "+ t.getMessage());
                    }
                });
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempIntent = new Intent(mContext, LayarListLaptop.class);
                startActivity(tempIntent);
            }
        });

        btPhotoUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih foto untuk " +
                        "di-upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode ==10) {
            if (data == null) {
                Toast.makeText(mContext, "Foto gagal di-load", Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                pathImage = cursor.getString(columnIndex);

                //Picasso.with(mContext).load(new File(imagePath)).fit().into(mImageView);
                Glide.with(mContext).load(new File(pathImage)).into(mPhotoUrl);
                cursor.close();
            } else {
                Toast.makeText(mContext, "Foto gagal di-load", Toast.LENGTH_LONG).show();
            }
        }
    }
}
