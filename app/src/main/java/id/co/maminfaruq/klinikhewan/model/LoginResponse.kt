package id.co.maminfaruq.klinikhewan.model

import com.google.gson.annotations.SerializedName

class LoginResponse {

    //TODO mengambil data dari api untuk menampilkan token ketika berhasil
    @SerializedName("token")
    val token: String? = null

    @SerializedName("result")
    val result: Int? = null

    @SerializedName("message")
    val message: Int? = null

    @SerializedName("data")
    val data : BodyLogin? = null
}