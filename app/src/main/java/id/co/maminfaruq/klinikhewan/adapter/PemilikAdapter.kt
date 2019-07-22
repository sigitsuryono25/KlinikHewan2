package id.co.maminfaruq.klinikhewan.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.model.hewan.DataItem
import id.co.maminfaruq.klinikhewan.model.pemilik.DataPemilik
import kotlinx.android.synthetic.main.item_menu.view.*

class PemilikAdapter(val context: Context,
                     val items: List<DataPemilik>,
                     private val click: PemilikAdapter.OnItemClickListener,
                     private val onLong : PemilikAdapter.OnItemLongClickListener) : RecyclerView.Adapter<PemilikAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, p0, false)
        return ViewHolder(view, context, click, onLong)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(items[p1],p1)
    }

    class ViewHolder(val view: View, val c: Context, val click: OnItemClickListener, val clickLong: OnItemLongClickListener) : RecyclerView.ViewHolder(view) {

        val textTitle = view.tv_judul
        val gambar = view.img_profil

        fun bindItems(dataMenu: DataPemilik, post : Int){
            textTitle.text = dataMenu.namaPemilik

            // Glide.with(itemView.context).load(dataMenu.gambar).into(gambar)

            view.setOnClickListener {
                click.onClick(dataMenu)
            }


            view.setOnLongClickListener {
                clickLong.onLong(dataMenu)
                return@setOnLongClickListener true
            }

        }
    }

    interface OnItemClickListener{
        fun onClick(item : DataPemilik)
    }

    interface  OnItemLongClickListener{
        fun onLong(item: DataPemilik)
    }
}