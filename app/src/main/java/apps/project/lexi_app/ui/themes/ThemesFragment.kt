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
    private var idioma:String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThemesBinding.inflate(layoutInflater, container, false)
        arguments?.let {
            idioma = it.getString(getString(R.string.llave_idioma))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this).commit()
        }
        println("LexiApp: ThemesFragment")
        bindAdapter()
    }

    private fun bindAdapter() {
        val adapter = ThemesCourseAdapter()
        adapter.list = arrayListOf(Theme(R.drawable.th_negocios,"Negocios","negocios"),
            Theme(R.drawable.th_peliculas,"Películas/Series","peliculas"),
            Theme(R.drawable.th_deportes,"Deportes","deportes"),
            Theme(R.drawable.th_musica,"Música","musica"),
            Theme(R.drawable.th_gastronomia,"Frases","frases"),
            Theme(R.drawable.th_historia,"Historia","historia"),
            Theme(R.drawable.th_moda,"Moda","moda"),
            Theme(R.drawable.th_tadiciones,"Tradiciones","tradiciones"))
        binding.rvThemes.adapter = adapter

        adapter.listener = object : OnThemeListener {
            override fun onClick(ocupacion:String) {
                val bundle=Bundle()
                bundle.putString(getString(R.string.llave_idioma),idioma)
                bundle.putString(getString(R.string.llave_ocupacion),ocupacion)
                val fragmento=ThemeDetailFragment()
                fragmento.arguments=bundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main,fragmento)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


}