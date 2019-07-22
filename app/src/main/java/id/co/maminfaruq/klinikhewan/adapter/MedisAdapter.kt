package id.co.maminfaruq.klinikhewan.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.maminfaruq.klinikhewan.R
import id.co.maminfaruq.klinikhewan.model.hewan.DataItem
import id.co.maminfaruq.klinikhewan.model.medis.DataMedis
import kotlinx.android.synthetic.main.item_medis.view.*
import kotlinx.android.synthetic.main.item_menu.view.*

class MedisAdapter (val context : Context,
                    val items : List<DataMedis>) : RecyclerView.Adapter<MedisAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_medis, p0, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(items[p1],p1)
    }

    class ViewHolder(val view: View, val c: Context ) : RecyclerView.ViewHolder(view) {

        val textTitle = view.tv_status
        val textRiwayat = view.tv_riwayat

        fun bindItems(dataMenu: DataMedis, post : Int){
            textTitle.text = dataMenu.statusRawat
            textRiwayat.text = dataMenu.riwayat

            // Glide.with(itemView.context).load(dataMenu.gambar).into(gambar)

        }
    }


}