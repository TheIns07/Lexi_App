package apps.project.lexi_app.ui.Activities.Grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.GridVoiceBinding
import apps.project.lexi_app.ui.Activities.Fill.Fill
import apps.project.lexi_app.ui.Activities.Fill.FillFragment
import apps.project.lexi_app.ui.myCourses.Course
import apps.project.lexi_app.ui.myCourses.MyCoursesAdapter
import apps.project.lexi_app.ui.myCourses.OnCourseListener
import apps.project.lexi_app.ui.themes.OptionThemeAdapter
import apps.project.lexi_app.ui.themes.Options
import apps.project.lexi_app.ui.themes.ThemesFragment

class GridVoiceFragment: Fragment() {

    private var _binding: GridVoiceBinding? = null
    private val binding get() = _binding!!
    var fille : ArrayList<Grid> = ArrayList<Grid>()
    val adapter = GridAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GridVoiceBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindAdapter()

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.gridLayoutOptions.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, FillFragment())
                .commit()
        }


    }

    fun bindAdapter(){
        val adapter = GridAdapter()
        adapter.list = arrayListOf(
            Grid("Beauty"),
            Grid("Mama"),
            Grid("Tencent"),
            Grid("Fiorentina")
        )
        binding.gridLayoutOptions.adapter = adapter
    }
}