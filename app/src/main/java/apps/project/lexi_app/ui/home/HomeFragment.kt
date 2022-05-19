package apps.project.lexi_app.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentHomeBinding
import apps.project.lexi_app.ui.courses.Course
import apps.project.lexi_app.ui.courses.CourseProvider
import apps.project.lexi_app.ui.logins.iniciosesion
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    companion object{
        var languages : ArrayList<Language> = ArrayList<Language>()
        var first: Boolean = true
        var idioma: String =""

        fun cargarIdiomas(){
            val db = Firebase.firestore
            var name: String = ""
            var image: Int = 0


            db.collection("courses")
                .get()
                .addOnSuccessListener { documents ->
                    for(document in documents) {
                        if (document != null) {
                            name = document.get("nombre").toString()
                            image = document.get("img").toString().toInt()
                        }
                        languages.add(Language(image, name))
                    }

                }
                .addOnFailureListener { exception ->
                     Log.e("ocurrio un error",exception.toString())
                }

        }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        if(iniciosesion.user.displayName != null){
            binding.textView2.text = "Hola, "+iniciosesion.user.displayName
        }else{
            binding.textView2.text = "Hola, "+iniciosesion.user.email
        }



        val gridView: GridView = binding.gridView
        val adapter = LanguageAdapter(binding.gridView.context, languages)


        gridView.adapter = adapter
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}