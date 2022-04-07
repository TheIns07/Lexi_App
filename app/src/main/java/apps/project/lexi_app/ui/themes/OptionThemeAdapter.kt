package apps.project.lexi_app.ui.themes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.databinding.ItemThemeDetailBinding

class OptionThemeAdapter : RecyclerView.Adapter<OptionThemeAdapter.MyViewHolder>() {
    lateinit var listener : OnOptionListener
    var list = ArrayList<Options>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class  MyViewHolder(val binding : ItemThemeDetailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            textOption.text = "Opción "+list[position].option
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemThemeDetailBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }
    override fun getItemCount() = list.size

}

interface OnOptionListener{
    fun onClick()
}