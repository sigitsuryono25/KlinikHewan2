package id.co.maminfaruq.klinikhewan.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.co.maminfaruq.klinikhewan.Constants
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.adapter.HewanAdapter
import id.co.maminfaruq.klinikhewan.model.hewan.DataItem
import id.co.maminfaruq.klinikhewan.model.hewan.HewanResponse
import id.co.maminfaruq.klinikhewan.network.ApiClient
import id.co.maminfaruq.klinikhewan.ui.tambah.tambahhewan.TambahHewanActivity
import kotlinx.android.synthetic.main.activity_hewan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HewanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hewan)
        title = "Daftar Hewan"

        fl_hewan.setOnClickListener {
            val i = Intent(this@HewanActivity, TambahHewanActivity::class.java)
            i.putExtra(Constants.IDPEMILIK, intent.getStringExtra(Constants.IDPEMILIK))
            startActivity(i)
        }


        val apiInterface = ApiClient.create()

        apiInterface.getHewan(intent.getStringExtra(Constants.IDPEMILIK))
                .enqueue(object : Callback<HewanResponse>{

                    override fun onResponse(call: Call<HewanResponse>?, response: Response<HewanResponse>?) {
                        rv_hewan.adapter = HewanAdapter(this@HewanActivity, response?.body()?.data!!,
                                object : HewanAdapter.OnItemClickListener{
                                    override fun onClick(item: DataItem) {
                                        val intent = Intent(this@HewanActivity, RekamMedisActivity::class.java)
                                        intent.putExtra(Constants.IDHEWAN, item.idHewan)
                                        startActivity(intent)
                                    }

                                })
                        rv_hewan.layoutManager = LinearLayoutManager(this@HewanActivity)
                    }

                    override fun onFailure(call: Call<HewanResponse>?, t: Throwable?) {

                    }

                })
    }
}
