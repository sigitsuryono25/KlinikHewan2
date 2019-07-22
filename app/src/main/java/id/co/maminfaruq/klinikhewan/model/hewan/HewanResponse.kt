package id.co.maminfaruq.klinikhewan.model.hewan

import com.google.gson.annotations.SerializedName
data class HewanResponse(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("success")
	val success: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)