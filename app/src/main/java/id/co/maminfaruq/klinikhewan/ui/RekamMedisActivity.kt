package id.co.maminfaruq.klinikhewan.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import id.co.maminfaruq.klinikhewan.Constants
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.adapter.HewanAdapter
import id.co.maminfaruq.klinikhewan.adapter.MedisAdapter
import id.co.maminfaruq.klinikhewan.model.medis.ResponseMedis
import id.co.maminfaruq.klinikhewan.network.ApiClient
import kotlinx.android.synthetic.main.activity_pemilik.*
import kotlinx.android.synthetic.main.activity_rekam_medis.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RekamMedisActivity : AppCompatActivity() {

    val apiInterface = ApiClient.create()


    override fun onStart() {
        super.onStart()

        apiInterface.getRekamMedis(intent.getStringExtra(Constants.IDHEWAN))
                .enqueue(object : Callback<ResponseMedis>{

                    override fun onResponse(call: Call<ResponseMedis>?, response: Response<ResponseMedis>?) {
                        rv_rekam_medis.adapter = MedisAdapter(this@RekamMedisActivity, response?.body()?.data!!)
                        rv_rekam_medis.layoutManager = LinearLayoutManager(this@RekamMedisActivity)
                    }

                    override fun onFailure(call: Call<ResponseMedis>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekam_medis)
        title = "Rekam Medis"

    }


}
