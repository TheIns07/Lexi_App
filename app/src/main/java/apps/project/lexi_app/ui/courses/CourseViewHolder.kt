package apps.project.lexi_app.ui.courses

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.R

class CourseViewHolder (view: View): RecyclerView.ViewHolder(view){

    val course = view.findViewById<TextView>(R.id.tv_name_course)
    val imageView = view.findViewById<ImageView>(R.id.iv_course)
    val progress1 = view.findViewById<ProgressBar>(R.id.pb_one)

    fun render(courseModel: Course){
        course.text = courseModel.name
        imageView.setImageResource(courseModel.image)
        progress1.progress = courseModel.progress
    }
}