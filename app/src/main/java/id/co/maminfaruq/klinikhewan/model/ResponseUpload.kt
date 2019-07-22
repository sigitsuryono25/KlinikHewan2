package id.co.maminfaruq.klinikhewan.model

import com.google.gson.annotations.SerializedName

data class ResponseUpload(

	@field:SerializedName("result")
	val result: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)