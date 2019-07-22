package id.co.maminfaruq.klinikhewan.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.model.DataMenu
import id.co.maminfaruq.klinikhewan.ui.jadwal.JadwalActivity
import id.co.maminfaruq.klinikhewan.ui.pasien.PasienActivity
import id.co.maminfaruq.klinikhewan.ui.pemilik.PemilikActivity
import id.co.maminfaruq.klinikhewan.ui.profil.ProfilActivity
import kotlinx.android.synthetic.main.item_menu.view.*

class MainAdapter (val context : Context, val items : List<DataMenu>) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, p0, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(items[p1],p1)
    }

    class ViewHolder(val view : View, val c : Context) : RecyclerView.ViewHolder(view) {

        val textTitle = view.tv_judul
        val gambar = view.img_profil

        fun bindItems(dataMenu: DataMenu, post : Int){
            textTitle.text = dataMenu.judul

            Glide.with(itemView.context).load(dataMenu.gambar).into(gambar)

            view.setOnClickListener {
                when(post){
                    0 -> c.startActivity(Intent(c, ProfilActivity::class.java))
                    1 -> c.startActivity(Intent(c, PemilikActivity::class.java))
                    2 -> c.startActivity(Intent(c, JadwalActivity::class.java))

                }
            }
        }
    }


}