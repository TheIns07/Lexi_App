package apps.project.lexi_app.ui.courses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.R

class CourseAdapter(private val courseList: List<Course>, private val idioma:String) : RecyclerView.Adapter<CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return CourseViewHolder(layoutInflater.inflate(R.layout.course_item, parent, false))
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val item = courseList[position]
        holder.render(item,idioma)
    }


    override fun getItemCount(): Int {
        return courseList.size
    }

}