package apps.project.lexi_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    var languages : ArrayList<Language> = ArrayList<Language>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fill_languages()

        val gridView: GridView = binding.gridView
        val adapter = LanguageAdapter(root.context, languages)


        gridView.adapter = adapter
        return root
    }

    fun fill_languages(){
        languages.add(Language(R.drawable.uk_flag, "Ingles"))
        languages.add(Language( R.drawable.francia,"Frances"))
        languages.add(Language(R.drawable.alemania, "Aleman"))
        languages.add(Language(R.drawable.italia, "Italiano"))
        languages.add(Language(R.drawable.rusia, "Ruso"))
        languages.add(Language(R.drawable.japon, "Japones"))
        languages.add(Language(R.drawable.corea, "Coreano"))
        languages.add(Language(R.drawable.china, "Chino"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}