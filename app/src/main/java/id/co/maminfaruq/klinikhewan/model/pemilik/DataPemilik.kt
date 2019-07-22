package id.co.maminfaruq.klinikhewan.model.pemilik

import com.google.gson.annotations.SerializedName

data class DataPemilik(

	@field:SerializedName("nama_pemilik")
	val namaPemilik: String? = null,

	@field:SerializedName("nomor_telphone")
	val nomorTelphone: String? = null,

	@field:SerializedName("id_pemilik")
	val idPemilik: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
)