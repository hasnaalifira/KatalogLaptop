package com.example.lenovo.kataloglaptop;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
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

import com.example.lenovo.kataloglaptop.Model.GetLaptop;
import com.example.lenovo.kataloglaptop.Rest.ApiClient;
import com.example.lenovo.kataloglaptop.Rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarInsertLaptop extends AppCompatActivity {
    Context mContext;
    ImageView mImageView;
    Button btAddPhotoId, btAddBack, btAddData;
    EditText edtAddMerkLaptop, edtAddTipeLaptop, edtAddRamLaptop;
    EditText edtAddProcessorLaptop, edtAddWarnaLaptop, edtAddHargaLaptop;
    TextView tvAddMessage;
    String imagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_insert_laptop);

        mContext = getApplicationContext();
        mImageView = (ImageView) findViewById(R.id.imgAddPhotoId);
        btAddPhotoId = (Button)  findViewById(R.id.btAddPhotoId);
        edtAddMerkLaptop = (EditText) findViewById(R.id.edtAddMerkLaptop);
        edtAddTipeLaptop = (EditText) findViewById(R.id.edtAddTipeLaptop);
        edtAddRamLaptop = (EditText) findViewById(R.id.edtAddRamLaptop);
        edtAddProcessorLaptop= (EditText) findViewById(R.id.edtAddProcessorLaptop);
        edtAddWarnaLaptop = (EditText) findViewById(R.id.edtAddWarnaLaptop);
        edtAddHargaLaptop = (EditText) findViewById(R.id.edtAddHargaLaptop);

        btAddData = (Button) findViewById(R.id.btAddData);
        btAddBack = (Button) findViewById(R.id.btAddBack);
        tvAddMessage = (TextView) findViewById(R.id.tvAddMessage);

//        mButtonPicture = (Button) findViewById(R.id.btnCapture);
//        mImageView = (ImageView) findViewById(R.id.imgPhotoId);

//        mButtonPicture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                captureImage();
//            }
//        });


//        // Checking camera availability
//        if (!isDeviceSupportCamera()) {
//            Toast.makeText(getApplicationContext(), "Camera di device anda
//                    tidak tersedia", Toast.LENGTH_LONG).show();
//                    finish();
//        }
//    }

    /*
     * Capturing Camera Image will lauch camera app requrest image capture
     */
//    private void captureImage() {
//        Intent takePictureIntent = new
//                Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null)
//        {
//            startActivityForResult(takePictureIntent, 100);
//        }
//    }

        /////////////////////////////////////////////////////////////////////////////

        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//                captureImage();



                MultipartBody.Part body = null;
                if (!imagePath.isEmpty()){
                    // Buat file dari image yang dipilih
                    File file = new File(imagePath);

                    // Buat RequestBody instance dari file
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);

                    // MultipartBody.Part digunakan untuk mendapatkan nama file
                    body = MultipartBody.Part.createFormData("photo_url", file.getName(),
                            requestFile);
                }
                RequestBody reqMerk = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddMerkLaptop.getText().toString().isEmpty())?"":edtAddMerkLaptop.getText().toString());
                RequestBody reqTipe = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddTipeLaptop.getText().toString().isEmpty())?"":edtAddTipeLaptop.getText().toString());
                RequestBody reqRam = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddRamLaptop.getText().toString().isEmpty())?"":edtAddRamLaptop.getText().toString());
                RequestBody reqProcessor = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddProcessorLaptop.getText().toString().isEmpty())?"":edtAddProcessorLaptop.getText().toString());
                RequestBody reqWarna = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddWarnaLaptop.getText().toString().isEmpty())?"":edtAddWarnaLaptop.getText().toString());
                RequestBody reqHarga = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddHargaLaptop.getText().toString().isEmpty())?"":edtAddHargaLaptop.getText().toString());
                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        "insert");
                Call<GetLaptop> mLaptopCall = mApiInterface.postLaptop(body, reqMerk,
                        reqTipe, reqRam, reqProcessor, reqWarna, reqHarga, reqAction );
                mLaptopCall.enqueue(new Callback<GetLaptop>() {
                    @Override
                    public void onResponse(Call<GetLaptop> call, Response<GetLaptop> response) {
//                      Log.d("Insert Retrofit",response.body().getMessage());
                        if (response.body().getStatus().equals("failed")){
                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body()
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
                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body().getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+detail);
                        }
                    }




                    @Override
                    public void onFailure(Call<GetLaptop> call, Throwable t) {
//                      Log.d("Insert Retrofit", t.getMessage());
                        tvAddMessage.setText("Retrofit Insert Failure \n Status = "+ t.getMessage
                                ());
                    }
                });
            }
        });
        btAddBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LayarListLaptop.class);
                startActivity(intent);
            }
        });
        btAddPhotoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(
                        galleryIntent,
                        "Pilih foto untuk di-upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }


    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 100);
        }
    }




}
