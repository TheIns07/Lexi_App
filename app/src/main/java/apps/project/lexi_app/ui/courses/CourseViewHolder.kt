package apps.project.lexi_app.ui.courses

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.CourseItemBinding
import apps.project.lexi_app.ui.IntroductionFragment

class CourseViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = CourseItemBinding.bind(view)


    fun render(courseModel: Course,idioma:String){
        binding.tvNameCourse.text = courseModel.name
        binding.ivCourse.setImageResource(courseModel.image)
        binding.pbOne.progress = courseModel.progress
        binding.itemCourse.setOnClickListener{
               v ->
           val activity = v!!.context as AppCompatActivity
            val bundle= Bundle()
            bundle.putString(activity.getString(R.string.llave_idioma),idioma)
            bundle.putString(activity.getString(R.string.llave_ocupacion),courseModel.clave)
           val introductionFragment = IntroductionFragment()
            introductionFragment.arguments=bundle

           activity.supportFragmentManager.beginTransaction()
              .replace(R.id.nav_host_fragment_activity_main, introductionFragment).addToBackStack(null).commitAllowingStateLoss()
        }
    }
}