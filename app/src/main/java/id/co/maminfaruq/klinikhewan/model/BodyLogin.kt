package id.co.maminfaruq.klinikhewan.model

import com.google.gson.annotations.SerializedName

class BodyLogin {

    //TODO mengambil data dari api untuk di convert ke GSON
    @SerializedName("email")
    var email: String? = null

    @SerializedName("password")
    var password: String? = null

    @SerializedName("nama_dokter")
    var namaDokter : String? = null
}
