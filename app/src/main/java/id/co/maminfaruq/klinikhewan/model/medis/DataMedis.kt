package id.co.maminfaruq.klinikhewan.model.medis

import com.google.gson.annotations.SerializedName

data class DataMedis(

	@field:SerializedName("id_hewan")
	val idHewan: String? = null,

	@field:SerializedName("riwayat")
	val riwayat: String? = null,

	@field:SerializedName("status_rawat")
	val statusRawat: String? = null,

	@field:SerializedName("id_rekam")
	val idRekam: String? = null
)