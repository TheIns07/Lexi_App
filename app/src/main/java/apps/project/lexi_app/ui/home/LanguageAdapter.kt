package apps.project.lexi_app.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import apps.project.lexi_app.R
import apps.project.lexi_app.ui.courses.CourseFragment

class LanguageAdapter: BaseAdapter {
    lateinit var context: Context
    var languages : ArrayList<Language> = ArrayList<Language>()

    constructor(context: Context, languages: ArrayList<Language>){
        this.context = context
        this.languages = languages
    }

    override fun getCount(): Int {
        return languages.size
    }

    override fun getItem(position: Int): Any {
        return languages[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflator = LayoutInflater.from(context)
        var view = inflator.inflate(R.layout.language_item, null)

        var language = languages[position]

        val iv_language: ImageView =  view.findViewById(R.id.iv_language)
        val tv_name_language: TextView = view.findViewById(R.id.tv_name_language)

        tv_name_language.setText(language.name)
        iv_language.setBackgroundResource(language.image)

        view.setOnClickListener { v ->
            val activity = v!!.context as AppCompatActivity
            val coursesFragment = CourseFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, coursesFragment).addToBackStack(null).commitAllowingStateLoss()
        }


        return view
    }
}