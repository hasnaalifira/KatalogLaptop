package com.example.nurul.userlaptop.Rest;

import com.example.nurul.userlaptop.GetLaptop;
import com.example.nurul.userlaptop.Model.GetLogin;
import com.example.nurul.userlaptop.Model.GetSuka;
import com.example.nurul.userlaptop.Model.PostPutDelSuka;

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
            (@Field("id_suka") String idSuka,
             @Field("id_laptop") String idLaptop,
             @Field("id_user") String idUser);

    @FormUrlEncoded
    @PUT("suka/user")
    Call<PostPutDelSuka> putSuka(
             @Field("id_suka") String idSuka,
             @Field("id_laptop") String idLaptop,
             @Field("id_user") String idUser);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "suka/user", hasBody = true)
    Call<PostPutDelSuka> deletePembelian(@Field("id_suka") String idSuka);

   // USER //
    @GET("user/all")
    Call<GetLogin> loginUser(

    );

    @Multipart
    @POST("user/all")
    Call<GetLogin> postUser(
            @Part MultipartBody.Part file,
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("user/all")
    Call<GetLogin> putUser(
            @Part MultipartBody.Part file,
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("user/all")
    Call<GetLogin> deleteUser(
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("action") RequestBody action
    );

    // LAPTOP //

    @GET("laptop/available")
    Call<GetLaptop> getLaptop();

    @FormUrlEncoded
    @POST("laptop/available")
    Call<GetLaptop> getLaptopforUser(
            @Field("id_user") String iduser
    );

//    @FormUrlEncoded
//    @POST("laptop/mylaptop")
//    Call<GetMyLaptop> getMyLaptop(
//            @Field("id_user") String idUser
//    );

    @FormUrlEncoded
    @POST("laptop/all")
    Call<GetLaptop> postLaptop(
            @Field("id_laptop") String idLaptop,
            @Field("merk") String merk,
            @Field("tipe") String tipe,
            @Field("ram") String ram,
            @Field("processor") String processor,
            @Field("warna") String warna,
            @Field("harga") String harga,
            @Field("action") String action
    );

    @FormUrlEncoded
    @POST("laptop/all")
    Call<GetLaptop> putLaptop(
            @Field("id_laptop") String idLaptop,
            @Field("merk") String merk,
            @Field("tipe") String tipe,
            @Field("ram") String ram,
            @Field("processor") String processor,
            @Field("warna") String warna,
            @Field("harga") String harga,
            @Field("action") String action
    );

    @FormUrlEncoded
    @POST("laptop/all")
    Call<GetLaptop> deleteLaptop(
            @Field("id_laptop") String idLaptop,
            @Field("action") String action);

    /********* Login *********/
    // Ingat, tambahkan dulu fungsi login_post() pada controller User di REST server
    @FormUrlEncoded
    @POST("user/login")
    Call loginUser(
            @Field("username") String username,
            @Field("password") String password);

}


