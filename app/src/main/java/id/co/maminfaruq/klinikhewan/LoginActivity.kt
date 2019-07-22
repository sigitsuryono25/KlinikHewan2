package id.co.maminfaruq.klinikhewan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import id.co.maminfaruq.klinikhewan.model.BodyLogin
import id.co.maminfaruq.klinikhewan.model.LoginResponse
import id.co.maminfaruq.klinikhewan.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO 1 membuat function agar lebih mudah di baca

        btnLogin.setOnClickListener {
            setLogin()
        }

    }

    private fun setLogin() {

        //TODO 2 mengisi model dari inputan user
        val bodyLogin = BodyLogin()
        bodyLogin.email = edtEmail.text.toString()
        bodyLogin.password = edtPassword.text.toString()

        //TODO 3 membuat object dari api INterface
        val apiInterface = ApiClient.create()


        // TODO 4 melakukan request ke server
        apiInterface.login(edtEmail.text.toString(), edtPassword.text.toString())
                .enqueue(object : Callback<LoginResponse> {

                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        //TODO 5 menampilkan popup berupa token apabila login berhasil
                        Toast.makeText(this@LoginActivity, response?.body()?.token, Toast.LENGTH_SHORT).show()

                        //TODO 6 melakukan perpindahan halaman apabila login berhasil
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                        //TODO 7 menyelesaikan activity login ketika pindah halaman
                        finish()
                    }

                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {

                    }


                })

    }
    
}
