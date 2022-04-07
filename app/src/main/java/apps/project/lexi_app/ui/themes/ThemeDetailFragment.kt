package apps.project.lexi_app.ui.themes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentThemeDetailBinding


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
        bindAdapter()
        binding.btnTitle.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment_activity_main,TitleThemeFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }
    }

    fun bindAdapter(){
        val adapter = OptionThemeAdapter()
        adapter.list = arrayListOf(Options(1),
            Options(2),
            Options(3),
            Options(4),
            Options(5),
            Options(6),
            Options(7),
            Options(8),
            Options(9))
        binding.rvOptions.adapter = adapter

    }
}