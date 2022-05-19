package apps.project.lexi_app.ui.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentCourseBinding
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CourseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!
    // TODO: Rename and change types of parameters
    private var idioma: String? = null
    private var ocupacion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idioma = it.getString(getString(R.string.llave_idioma))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView:RecyclerView = binding.recyclerCourse
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CourseAdapter(CourseProvider.courseList,idioma!!)//lowercase()

        println("LexiApp: CourseFragment : $idioma")

        recyclerView.setOnClickListener {
            val bundle=Bundle()
            bundle.putString(getString(R.string.llave_idioma),idioma)
            bundle.putString(getString(R.string.llave_ocupacion),ocupacion)
            val fragmento=TopicsFragment()
            fragmento.arguments=bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, fragmento)
                .commit()
        }

        return root
    }


    /*
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CourseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    */
}