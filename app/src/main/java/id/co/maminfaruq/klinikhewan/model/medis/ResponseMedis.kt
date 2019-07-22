package id.co.maminfaruq.klinikhewan.model.medis

import com.google.gson.annotations.SerializedName

data class ResponseMedis(

        @field:SerializedName("data")
        val data: List<DataMedis>? = null,

        @field:SerializedName("success")
        val success: Int? = null,

        @field:SerializedName("message")
        val message: String? = null
)