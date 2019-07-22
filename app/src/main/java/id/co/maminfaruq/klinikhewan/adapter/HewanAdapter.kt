package id.co.maminfaruq.klinikhewan.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.model.hewan.DataItem
import id.co.maminfaruq.klinikhewan.ui.profil.ProfilActivity
import kotlinx.android.synthetic.main.item_menu.view.*

class HewanAdapter  (val context : Context,
                     val items : List<DataItem>,
                     private val click : OnItemClickListener
                     ) : RecyclerView.Adapter<HewanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HewanAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, p0, false)
        return ViewHolder(view, context, click)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(items[p1],p1)
    }

    class ViewHolder(val view: View, val c: Context, val click: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        val textTitle = view.tv_judul
        val gambar = view.img_profil

        fun bindItems(dataMenu: DataItem, post : Int){
            textTitle.text = dataMenu.namaHewan

           // Glide.with(itemView.context).load(dataMenu.gambar).into(gambar)

            view.setOnClickListener {
                click.onClick(dataMenu)
            }
        }
    }

    interface OnItemClickListener{
        fun onClick(item : DataItem)
    }

}