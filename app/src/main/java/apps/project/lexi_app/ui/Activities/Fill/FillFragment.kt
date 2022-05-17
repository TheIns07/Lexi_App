package apps.project.lexi_app.ui.Activities.Fill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.CompleteTextBinding
import apps.project.lexi_app.ui.Activities.Grid.Grid
import apps.project.lexi_app.ui.Activities.Grid.GridAdapter
import apps.project.lexi_app.ui.Activities.Grid.GridVoiceFragment

class FillFragment : Fragment(){

    private var _binding: CompleteTextBinding? = null
    private val binding get() = _binding!!
    var fille : ArrayList<Fill> = ArrayList<Fill>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CompleteTextBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindAdapter()
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }

        binding.buttonGridConfirm.setOnClickListener {
            onDestroyView()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, GridVoiceFragment())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun bindAdapter(){
        val adapter = FillAdapter()
        adapter.list = arrayListOf(
            Fill("I am", "a man"),
            Fill("We are", "the plaza tonight"),
            Fill("Are you"," Eric Andre?"),
            Fill("Can you", "5 minutes?")
        )
        binding.rvOptions.adapter = adapter
    }
}