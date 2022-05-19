package apps.project.lexi_app.ui.myCourses

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import apps.project.lexi_app.R
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.databinding.ItemCoursesBinding

class MyCoursesAdapter : RecyclerView.Adapter<MyCoursesAdapter.MyViewHolder>() {

    lateinit var listener : OnCourseListener

    var list = ArrayList<Course>()


        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class  MyViewHolder(val binding : ItemCoursesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            textNameCourse.text = list[position].name
            textLvl.text = list[position].level.toString()
            val avance=list[position].progress.toString()
            textProgress.text =  textNameCourse.context.getString(R.string.texto_avance,avance)

            imgFlag.setImageResource(list[position].img)

            btnNext.setOnClickListener {
                listener.onClick(list[position].name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemCoursesBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }
    override fun getItemCount() = list.size

}

interface OnCourseListener{
    fun onClick(idioma:String)
}