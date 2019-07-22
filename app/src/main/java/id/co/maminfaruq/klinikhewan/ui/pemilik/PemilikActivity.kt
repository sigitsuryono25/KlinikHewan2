package id.co.maminfaruq.klinikhewan.ui.pemilik

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import id.co.maminfaruq.klinikhewan.Constants
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.adapter.HewanAdapter
import id.co.maminfaruq.klinikhewan.adapter.PemilikAdapter
import id.co.maminfaruq.klinikhewan.model.ResponseUpload
import id.co.maminfaruq.klinikhewan.model.hewan.DataItem
import id.co.maminfaruq.klinikhewan.model.hewan.HewanResponse
import id.co.maminfaruq.klinikhewan.model.pemilik.DataPemilik
import id.co.maminfaruq.klinikhewan.model.pemilik.PemilikResponse
import id.co.maminfaruq.klinikhewan.network.ApiClient
import id.co.maminfaruq.klinikhewan.ui.HewanActivity
import id.co.maminfaruq.klinikhewan.ui.tambah.tambahpemilik.TambahPemilikActivity
import kotlinx.android.synthetic.main.activity_hewan.*
import kotlinx.android.synthetic.main.activity_pemilik.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PemilikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemilik)
        title = "Pemilik"
        getPemilik()

        fl_pemilik.setOnClickListener {
            val intent = Intent(this@PemilikActivity, TambahPemilikActivity::class.java)
            startActivity(intent)
        }
    }


    fun getPemilik() {
        val apiInterface = ApiClient.create()

        apiInterface.getPemilik()
                .enqueue(object : Callback<PemilikResponse> {

                    override fun onResponse(call: Call<PemilikResponse>?, response: Response<PemilikResponse>?) {
                        rv_pemilik.adapter = PemilikAdapter(this@PemilikActivity, response?.body()?.data!!,
                                object : PemilikAdapter.OnItemClickListener {
                                    override fun onClick(item: DataPemilik) {
                                        val intent = Intent(this@PemilikActivity, HewanActivity::class.java)
                                        intent.putExtra(Constants.IDPEMILIK, item.idPemilik)
                                        startActivity(intent)
                                    }

                                }, object : PemilikAdapter.OnItemLongClickListener {
                            override fun onLong(item: DataPemilik) {
                                alert("Apakah anda mau menghapus") {
                                    title = "Hapus !"
                                    yesButton {
                                        var idPemilik: String? = null
                                        response.body()?.data?.forEach {
                                            idPemilik = it.idPemilik!!
                                        }
                                        apiInterface.deletePemilik(idPemilik!!)
                                                .enqueue(object : Callback<ResponseUpload> {

                                                    override fun onResponse(call: Call<ResponseUpload>?, response: Response<ResponseUpload>?) {
                                                        Toast.makeText(this@PemilikActivity, response?.message(), Toast.LENGTH_SHORT).show()
                                                    }

                                                    override fun onFailure(call: Call<ResponseUpload>?, t: Throwable?) {
                                                        Log.e("Error mas", t?.message)
                                                    }

                                                })
                                    }
                                    noButton {

                                    }
                                }.show()
                            }
                        })
                        rv_pemilik.layoutManager = LinearLayoutManager(this@PemilikActivity)
                    }

                    override fun onFailure(call: Call<PemilikResponse>?, t: Throwable?) {

                    }

                })
    }

    override fun onResume() {
        super.onResume()
        getPemilik()
    }

}
