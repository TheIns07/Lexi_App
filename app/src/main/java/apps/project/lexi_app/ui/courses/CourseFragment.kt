package apps.project.lexi_app.ui.courses

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentCourseBinding
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment
import apps.project.lexi_app.ui.home.HomeFragment
import apps.project.lexi_app.ui.logins.iniciosesion
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    companion object{
        lateinit var theme:String

        fun cargarCursosPorIdioma(){
            val db = Firebase.firestore
            var listaCursos = ArrayList<Course>()
            var name: String = ""
            var image: Int = 0
            var progress: Int = 0

            db.collection("themes")
                .whereEqualTo("idioma", HomeFragment.idioma)
                .get()
                .addOnSuccessListener { documents ->
                    for(document in documents) {
                        if (document != null) {
                            name = document.get("nombre").toString()
                            image = document.get("imagen").toString().toInt()
                            db.collection("/themes/"+document.id+"/user").document(iniciosesion.user.email.toString()).get()
                                .addOnSuccessListener { doc ->
                                    if(doc.get("progrees") != null){
                                        progress = doc.get("progress").toString().toInt()
                                    }else{
                                        progress = 0
                                    }
                                }
                        }
                        listaCursos.add(Course(image, name, progress))
                    }
                    CourseProvider.coursesList = listaCursos

                }
                .addOnFailureListener { exception ->
                    Log.e("ocurrio un error",exception.toString())
                }

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView:RecyclerView = binding.recyclerCourse
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CourseAdapter(CourseProvider.coursesList)

        recyclerView.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, TopicsFragment())
                .commit()
        }

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }





}