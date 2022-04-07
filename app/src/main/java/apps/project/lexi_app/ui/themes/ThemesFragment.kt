package apps.project.lexi_app.ui.themes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentThemesBinding

class ThemesFragment : Fragment() {
    private var _binding: FragmentThemesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThemesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }
        bindAdapter()
    }

    private fun bindAdapter() {
        val adapter = ThemesCourseAdapter()
        adapter.list = arrayListOf(Theme(R.drawable.th_negocios,"Negocios"),
            Theme(R.drawable.th_peliculas,"Películas/Series"),
            Theme(R.drawable.th_deportes,"Deportes"),
            Theme(R.drawable.th_musica,"Música"),
            Theme(R.drawable.th_gastronomia,"Gastronomía"),
            Theme(R.drawable.th_historia,"Historia"),
            Theme(R.drawable.th_moda,"Moda"),
            Theme(R.drawable.th_tadiciones,"Tradiciones"))
        binding.rvThemes.adapter = adapter

        adapter.listener = object : OnThemeListener {
            override fun onClick() {
                requireActivity().supportFragmentManager.beginTransaction()
                    .add(R.id.nav_host_fragment_activity_main,ThemeDetailFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


}