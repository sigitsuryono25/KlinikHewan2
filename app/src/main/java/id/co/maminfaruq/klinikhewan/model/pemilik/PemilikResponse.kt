package id.co.maminfaruq.klinikhewan.model.pemilik

import com.google.gson.annotations.SerializedName

data class PemilikResponse(

		@field:SerializedName("data")
	val data: List<DataPemilik>? = null,

		@field:SerializedName("success")
	val success: Int? = null,

		@field:SerializedName("message")
	val message: String? = null
)