package id.co.maminfaruq.klinikhewan.model.hewan

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("nama_hewan")
	val namaHewan: String? = null,

	@field:SerializedName("id_hewan")
	val idHewan: String? = null,

	@field:SerializedName("id_pemilik")
	val idPemilik: String? = null,

	@field:SerializedName("jenis")
	val jenis: String? = null,

	@field:SerializedName("gambar_hewan")
	val gambarHewan: String? = null
)