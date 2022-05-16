package apps.project.lexi_app.ui.Activities.Fill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.databinding.FragmentTextBinding
import apps.project.lexi_app.databinding.ItemThemeDetailBinding
import apps.project.lexi_app.ui.Activities.Grid.GridAdapter
import apps.project.lexi_app.ui.Activities.Grid.OnGridListener

abstract class FillAdapter : RecyclerView.Adapter<FillAdapter.MyViewHolder>() {

    lateinit var listener : OnFillListener
    var list = ArrayList<apps.project.lexi_app.ui.Activities.Grid.Grid>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class  MyViewHolder(val binding : FragmentTextBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FillAdapter.MyViewHolder {
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