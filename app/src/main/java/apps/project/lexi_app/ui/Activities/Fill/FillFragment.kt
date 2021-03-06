package apps.project.lexi_app.ui.Activities.Fill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.CompleteTextBinding
import apps.project.lexi_app.ui.Activities.Grid.GridVoiceFragment
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment
import apps.project.lexi_app.ui.courses.CourseFragment
import apps.project.lexi_app.ui.home.HomeFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FillFragment : Fragment(){

    private var _binding: CompleteTextBinding? = null
    private val binding get() = _binding!!
    val adapter = FillAdapter()
    var fille : ArrayList<Fill> = ArrayList<Fill>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CompleteTextBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindAdapter(binding)
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }

        binding.buttonGridConfirm.setOnClickListener {
            answers()
            Thread.sleep(1000)
            onDestroyView()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, GridVoiceFragment())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun answers(){
        val db = Firebase.firestore
        var answer1: String = ""
        var answer2: String = ""
        var result: Int = 0

        var mEdit: EditText = binding.rvOptions.findViewById(R.id.editText_main);

        db.collection("dummy_data/dummy_data/fill_data")
            .whereEqualTo("languaje", HomeFragment.idioma)
            .whereEqualTo("theme", CourseFragment.theme)
            .limit(1)
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents) {
                    if (document != null) {
                        answer1 = document.get("answer1").toString()
                        answer2 = document.get("answer2").toString()
                    }
                }

                if(mEdit.text.equals(answer1) || mEdit.text.equals(answer2)){
                    Toast.makeText(context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(context, "Respuesta Correcta", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(context, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
            }
    }

    fun bindAdapter(binding: CompleteTextBinding){
            val db = Firebase.firestore
            var answer1: String = ""
            var answer2: String = ""
            var begg_word_1: String = ""
            var begg_word_2: String = ""
            var begg_word_3: String = ""
            var begg_word_4: String = ""
            var final_word_1: String = ""
            var final_word_2: String = ""
            var final_word_3: String = ""
            var final_word_4: String = ""



        db.collection("dummy_data/dummy_data/fill_data")
            .whereEqualTo("languaje", HomeFragment.idioma)
            .whereEqualTo("theme", CourseFragment.theme)
            .limit(1)
            .get()
                .addOnSuccessListener { documents ->
                    for(document in documents) {
                    if(document != null){
                            answer1 = document.get("answer1").toString()
                            answer2 = document.get("answer2").toString()
                            begg_word_1 = document.get("begg_word_1").toString()
                            begg_word_2 = document.get("begg_word_2").toString()
                            begg_word_3 = document.get("begg_word_3").toString()
                            final_word_1 = document.get("final_word_1").toString()
                            final_word_2 = document.get("final_word_2").toString()
                            final_word_3 = document.get("final_word_3").toString()
                        }
                    }
                    binding.textWordsActionSub.setText(answer1+" or "+answer2)

                        val adapter = FillAdapter()
                        adapter.list = arrayListOf(
                            Fill(begg_word_1, final_word_1),
                            Fill(begg_word_2, final_word_2),
                            Fill(begg_word_3,final_word_3)
                        )
                        binding.rvOptions.adapter = adapter

                        adapter.listener = object : OnFillListener {
                            override fun onClick() {
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.nav_host_fragment_activity_main, TopicsFragment())
                                    .addToBackStack(null)
                                    .commit()
                            }
                        }

                }
                .addOnFailureListener { exception ->
                    Toast.makeText(context, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
                }



    }
}