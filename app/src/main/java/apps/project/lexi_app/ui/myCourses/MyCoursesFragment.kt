package apps.project.lexi_app.ui.myCourses

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentMyCoursesBinding
import apps.project.lexi_app.databinding.FragmentThemeDetailBinding
import apps.project.lexi_app.ui.themes.ThemesFragment


class MyCoursesFragment : Fragment() {
    private var _binding: FragmentMyCoursesBinding? = null
    private val binding get() = _binding!!
    val adapter = MyCoursesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCoursesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        bindAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindAdapter()
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    private fun bindAdapter() {
        adapter.list = arrayListOf(Course(10,"Ingles",58, R.drawable.inglaterra),
            Course(1,"Aleman",10, R.drawable.alemania))
        binding.rvCourses.adapter = adapter

        adapter.listener = object : OnCourseListener {
            override fun onClick() {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,
                    ThemesFragment()
                ).addToBackStack(null).commit()
            }
        }
    }
}