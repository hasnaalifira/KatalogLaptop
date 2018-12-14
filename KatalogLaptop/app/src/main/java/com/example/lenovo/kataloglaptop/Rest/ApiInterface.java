package com.example.lenovo.kataloglaptop.Rest;

import com.example.lenovo.kataloglaptop.Model.GetLaptop;
import com.example.lenovo.kataloglaptop.Model.GetSuka;
import com.example.lenovo.kataloglaptop.Model.PostPutDelSuka;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface ApiInterface {
    @GET("suka/user")
    Call<GetSuka> getSuka();

    @FormUrlEncoded
    @POST("suka/user")
    Call<PostPutDelSuka> postSuka
            (@Field("id_suka") String idSuka, @Field("id_laptop") String idLaptop,
             @Field("id_user") String idUser);

    @FormUrlEncoded
    @PUT("suka/user")
    Call<PostPutDelSuka> putSuka(
            @Field("id_suka") String idSuka, @Field("id_laptop") String idLaptop,
            @Field("id_user") String idUser);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "suka/user", hasBody = true)
    Call<PostPutDelSuka> deleteSuka(@Field("id_suka") String idSuka);

    /********* Laptop *********/
    @GET("laptop/all")
    Call<GetLaptop> getLaptop();

    @Multipart
    @POST("laptop/all")
    Call<GetLaptop> postLaptop(
            @Part MultipartBody.Part file,
            @Part("merk") RequestBody merk,
            @Part("tipe") RequestBody tipe,
            @Part("ram") RequestBody ram,
            @Part("processor") RequestBody processor,
            @Part("warna") RequestBody warna,
            @Part("harga") RequestBody harga,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("laptop/all")
    Call<GetLaptop> putLaptop(
            @Part MultipartBody.Part file,
            @Part("id_laptop") RequestBody idLaptop,
            @Part("merk") RequestBody merk,
            @Part("tipe") RequestBody tipe,
            @Part("ram") RequestBody ram,
            @Part("processor") RequestBody processor,
            @Part("warna") RequestBody warna,
            @Part("harga") RequestBody harga,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("laptop/all")
    Call<GetLaptop> deleteLaptop(
            @Part("id_laptop") RequestBody idLaptop,
            @Part("action") RequestBody action);
//

}
