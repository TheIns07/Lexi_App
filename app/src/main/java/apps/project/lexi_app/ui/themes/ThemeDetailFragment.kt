package apps.project.lexi_app.ui.themes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentThemeDetailBinding
import apps.project.lexi_app.databinding.GridVoiceBinding
import apps.project.lexi_app.ui.Activities.Fill.FillFragment
import apps.project.lexi_app.ui.Activities.Grid.Grid
import apps.project.lexi_app.ui.Activities.Grid.GridAdapter
import apps.project.lexi_app.ui.Activities.Grid.OnGridListener
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ThemeDetailFragment : Fragment() {
    private var _binding: FragmentThemeDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThemeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindAdapter(binding)

        binding.titleGrid.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, FillFragment())
                .commit()
        }

        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }
    }

    fun bindAdapter(binding: FragmentThemeDetailBinding){
            val db = Firebase.firestore
            var gridAction: String = ""
            var gridTitle: String = ""
            var field1: String = ""
            var field2: String = ""
            var field3: String = ""
            var field4: String = ""
            db.collection("dummy_data/dummy_data/grid_data")
                .whereEqualTo("languaje", "aleman")
                .whereEqualTo("theme", "ocupacion")
                .get()
                .addOnSuccessListener { documents ->
                    for(document in documents) {
                    if(document != null) {
                        gridAction = document.get("grid_actions").toString()
                        gridTitle = document.get("titulo_grid").toString()
                        field1 = document.get("field1").toString()
                        field2 = document.get("field2").toString()
                        field3 = document.get("field3").toString()
                        field4 = document.get("field4").toString()
                    }

                    }
                        binding.titleGrid.setText(gridTitle);
                        binding.textView8.setText(gridAction);

                        val adapter = GridAdapter()

                        adapter.list = arrayListOf(
                            Grid(field1),
                            Grid(field2),
                            Grid(field3),
                            Grid(field4)
                        )
                        binding.rvOptions.adapter = adapter

                        adapter.listener = object : OnGridListener {
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
