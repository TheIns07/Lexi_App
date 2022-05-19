package apps.project.lexi_app.ui.Activities.Grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.GridVoiceBinding
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment
import apps.project.lexi_app.ui.themes.OnThemeListener
import apps.project.lexi_app.ui.themes.ThemeDetailFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


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
        println("LexiApp: GridVoiceFragment")
        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindAdapter(binding)


        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonGridConfirm.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, TopicsFragment())
                .commit()
        }


    }



    fun bindAdapter(binding: GridVoiceBinding){
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
            .limit(1)
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents) {
                    if (document != null) {
                        gridAction = document.get("grid_actions").toString()
                        gridTitle = document.get("titulo_grid").toString()
                        field1 = document.get("field1").toString()
                        field2 = document.get("field2").toString()
                        field3 = document.get("field3").toString()
                        field4 = document.get("field4").toString()
                    }
                }
                binding.titleGrid.setText(gridTitle);
                binding.activityGrid.setText(gridAction);

                val adapter = GridAdapter()

                adapter.list = arrayListOf(
                    Grid(field1),
                    Grid(field2),
                    Grid(field3),
                    Grid(field4)
                )
                binding.gridLayoutOptions.adapter = adapter

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