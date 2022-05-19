package apps.project.lexi_app.ui.themes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.databinding.ItemThemeBinding

class ThemesCourseAdapter : RecyclerView.Adapter<ThemesCourseAdapter.MyViewHolder>() {
    lateinit var listener : OnThemeListener
    var list = ArrayList<Theme>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class  MyViewHolder(val binding : ItemThemeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            imgTheme.setImageResource(list[position].img)
            textName.text = list[position].name

            containerTheme.setOnClickListener {
                listener.onClick(list[position].claveocupacion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemThemeBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }
    override fun getItemCount() = list.size

}

interface OnThemeListener{
    fun onClick(ocupacion:String)
}