package id.co.maminfaruq.klinikhewan.ui.tambah.tambahhewan

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.co.maminfaruq.klinikhewan.BuildConfig
import id.co.maminfaruq.klinikhewan.Constants
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.model.ResponseUpload
import id.co.maminfaruq.klinikhewan.network.ApiClient
import kotlinx.android.synthetic.main.activity_tambah_hewan.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.util.*

class TambahHewanActivity : AppCompatActivity() {

    private var fileUri: Uri? = null
    private var fileName: String? = null
    private var realPath: String? = null
    private val MEDIATYPEIMAGE = 100
    private val FOLDERNAME = "PresensiOnline"
    private val CAMERAREQ = 1024

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_hewan)


        fab_choose_picture.onClick {
            launchCamera()
        }

        Toast.makeText(this, intent.getStringExtra(Constants.IDPEMILIK), Toast.LENGTH_SHORT).show()

        val apiInterface = ApiClient.create()


        btn_upload_hewan.setOnClickListener {
            apiInterface.postHewan(intent.getStringExtra(Constants.IDPEMILIK)
                    , edt_name_hewan.text.toString(),
                    edt_jenis.text.toString(),
                    fileName)
                    .enqueue(object : Callback<ResponseUpload>{

                        override fun onResponse(call: Call<ResponseUpload>?, response: Response<ResponseUpload>?) {
                            if (response?.isSuccessful!!) {
                                Toast.makeText(this@TambahHewanActivity, response.message(), Toast.LENGTH_SHORT).show()
                                finish()
                            }
                        }

                        override fun onFailure(call: Call<ResponseUpload>?, t: Throwable?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                    })

        }


    }

    private fun launchCamera() {
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        fileUri = getOutputMediaFileUri(MEDIATYPEIMAGE)
        camera.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        startActivityForResult(camera, CAMERAREQ)
    }

    private fun getOutputMediaFileUri(mediatypeimage: Int): Uri? {
        return getOutputMediaFile(mediatypeimage)?.let {
            FileProvider.getUriForFile(
                    this,
                    BuildConfig.APPLICATION_ID + ".provider",
                    it
            )
        }
    }

    private fun getOutputMediaFile(mediatypeimage: Int): File? {


        // External sdcard location
        val mediaStorageDir = File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                FOLDERNAME
        )

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null
            }
        }
        val mediaFile: File
        val c = Calendar.getInstance(Locale.getDefault())
        if (mediatypeimage == MEDIATYPEIMAGE) {
            fileName = "IMG_" + c.timeInMillis.toString() + ".jpg"
            mediaFile = File(
                    mediaStorageDir.path + File.separator
                            + fileName
            )
            realPath = mediaFile.toString()
        } else {
            return null
        }

        return mediaFile
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERAREQ && resultCode == Activity.RESULT_OK) {
            showPreview(realPath)
        }
    }

    private fun showPreview(realPath: String?) {
        Glide.with(this)
                .load(realPath)
                .apply(RequestOptions().centerCrop())
                .into(img_picture)
    }
}
