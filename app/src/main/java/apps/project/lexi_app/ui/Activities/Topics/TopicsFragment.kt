package apps.project.lexi_app.ui.Activities.Topics
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.BoxVoiceBinding
import apps.project.lexi_app.ui.Activities.Fill.FillFragment
import apps.project.lexi_app.ui.notifications.NotificationsFragment


class TopicsFragment: Fragment(){

    private var _binding: BoxVoiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BoxVoiceBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        themeGenerate();
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }

        binding.buttonGridConfirm.setOnClickListener {
            super.onDestroyView()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, NotificationsFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    fun themeGenerate(){
        binding.indicationBoxVoice
    }

}