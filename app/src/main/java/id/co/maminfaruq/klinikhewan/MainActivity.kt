package id.co.maminfaruq.klinikhewan

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import id.co.maminfaruq.klinikhewan.adapter.MainAdapter
import id.co.maminfaruq.klinikhewan.model.DataMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data: MutableList<DataMenu> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nama = resources.getStringArray(R.array.name)
        val gambar = resources.obtainTypedArray(R.array.image_name)

        for (i in nama.indices) {
            data.add(DataMenu(nama[i], gambar.getResourceId(i, 0)))
        }

        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = MainAdapter(this, data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId){
            R.id.action_call -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "087810440414"))
                startActivity(intent)

            }
        }

        return super.onOptionsItemSelected(item)
    }
}
