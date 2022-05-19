package apps.project.lexi_app.ui.Activities.Grid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.ItemCoursesBinding
import apps.project.lexi_app.databinding.ItemThemeDetailBinding
import apps.project.lexi_app.ui.courses.Course
import apps.project.lexi_app.ui.courses.CourseViewHolder

class GridAdapter : RecyclerView.Adapter<GridAdapter.MyViewHolder>() {
    lateinit var listener : OnGridListener
    var list = ArrayList<apps.project.lexi_app.ui.Activities.Grid.Grid>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class  MyViewHolder(val binding : ItemThemeDetailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            textOption.text = list[position].gridTitle

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

interface OnGridListener{
    fun onClick()
}

