package apps.project.lexi_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.GridVoiceBinding
import apps.project.lexi_app.databinding.IntroductionBinding
import apps.project.lexi_app.ui.Activities.Topics.TopicsFragment
import apps.project.lexi_app.ui.themes.ThemeDetailFragment

class IntroductionFragment: Fragment() {
    private var _binding: IntroductionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = IntroductionBinding.inflate(layoutInflater, container, false)
        println("LexiApp: IntroductionFragment")
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.buttonIntroConfirm.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, ThemeDetailFragment())
                .commit()
        }
    }


}