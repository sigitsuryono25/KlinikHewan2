package id.co.maminfaruq.klinikhewan.ui.tambah.tambahpemilik

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.model.ResponseUpload
import id.co.maminfaruq.klinikhewan.network.ApiClient
import kotlinx.android.synthetic.main.activity_tambah_pemilik.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahPemilikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_pemilik)

        val apiInterface = ApiClient.create()

        btn_upload.setOnClickListener {

            apiInterface.postPemilik(edt_name_pemilik.text.toString(),
                    edt_alamat.text.toString(),
                    edt_nomor_telephone.text.toString())
                    .enqueue(object : Callback<ResponseUpload> {

                        override fun onResponse(call: Call<ResponseUpload>?, response: Response<ResponseUpload>?) {
                            if (response?.isSuccessful!!) {
                                Toast.makeText(this@TambahPemilikActivity, response.message(), Toast.LENGTH_SHORT).show()
                                finish()
                            }
                        }

                        override fun onFailure(call: Call<ResponseUpload>?, t: Throwable?) {

                        }
                    })

        }


    }
}
