package apps.project.lexi_app.ui.Activities.Fill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.databinding.FragmentTextBinding
import apps.project.lexi_app.databinding.ItemThemeDetailBinding

class FillAdapter : RecyclerView.Adapter<FillAdapter.MyViewHolder>() {
    lateinit var listener : OnFillListener
    var list = ArrayList<apps.project.lexi_app.ui.Activities.Fill.Fill>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class  MyViewHolder(val binding : FragmentTextBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            begginingText.text = list[position].wordBeggining
            finalText.text = list[position].wordFinal

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            FragmentTextBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }
    override fun getItemCount() = list.size

}

interface OnFillListener{
    fun onClick()
}