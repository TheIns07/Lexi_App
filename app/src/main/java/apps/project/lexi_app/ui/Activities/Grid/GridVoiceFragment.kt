package apps.project.lexi_app.ui.Activities.Grid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.GridVoiceBinding
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment
import com.google.firebase.database.FirebaseDatabase


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

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dummy_data").child("grid_data")
        val titulogrid = myRef.child("grid_actions")




        /*titulogrid.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java)
                binding.activityGrid.text = "$value"
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })*/

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.gridLayoutOptions.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, TopicsFragment())
                .commit()
        }

        binding.buttonGridConfirm.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, TopicsFragment())
                .commit()
        }


    }

    fun bindAdapter(){


        val adapter = GridAdapter()

        adapter.list = arrayListOf(
           Grid("Happy"),
            Grid("Sad"),
            Grid("Normal"),
            Grid("Trained")
        )



        binding.gridLayoutOptions.adapter = adapter
    }
}