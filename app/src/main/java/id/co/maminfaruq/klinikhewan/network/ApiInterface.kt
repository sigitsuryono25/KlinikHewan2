package id.co.maminfaruq.klinikhewan.network

import id.co.maminfaruq.klinikhewan.model.BodyLogin
import id.co.maminfaruq.klinikhewan.model.LoginResponse
import id.co.maminfaruq.klinikhewan.model.ResponseUpload
import id.co.maminfaruq.klinikhewan.model.hewan.HewanResponse
import id.co.maminfaruq.klinikhewan.model.medis.ResponseMedis
import id.co.maminfaruq.klinikhewan.model.pemilik.PemilikResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    //TODO memasukkan end point
    @FormUrlEncoded
    @POST("loginuser.php")
    fun login(
            @Field("nama_dokter") namaDokter: String,
            @Field("password") password: String
    ): Call<LoginResponse>

    @POST("pemilik.php")
    fun getPemilik(): Call<PemilikResponse>

    @FormUrlEncoded
    @POST("hewan.php")
    fun getHewan(

            @Field("id_pemilik") pem: String?

    ): Call<HewanResponse>

    @FormUrlEncoded
    @POST("rekammedis.php")
    fun getRekamMedis(

            @Field("id_hewan") hewan: String?

    ): Call<ResponseMedis>


    @FormUrlEncoded
    @POST("uploadpemilik.php")
    fun postPemilik(
            @Field("nama_pemilik") namaPemilik: String?,
            @Field("alamat") alamat: String?,
            @Field("nomor_telphone") noTelp: String?

    ): Call<ResponseUpload>


    @FormUrlEncoded
    @POST("deletepemilik.php")
    fun deletePemilik(
            @Field("id_pemilik") idPemilik: String
    ): Call<ResponseUpload>


    @FormUrlEncoded
    @POST("deletehewan.php")
    fun deleteHewan(
            @Field("id_hewan") idHewan: String
    ): Call<ResponseUpload>


    @FormUrlEncoded
    @POST("uploadhewan.php")
    fun postHewan(
            @Field("id_pemilik") idPemilik: String?,
            @Field("nama_hewan") namaHewan: String?,
            @Field("jenis") jenis: String?,
            @Field("gambar_hewan") gambar: String?

    ): Call<ResponseUpload>

    @FormUrlEncoded
    @POST("uploadrekammedis.php")
    fun postRekamMedis(
            @Field("id_hewan") id_hewan: String?,
            @Field("riwayat") riwayat: String?,
            @Field("status_rawat") status: String?

    ): Call<ResponseUpload>


}