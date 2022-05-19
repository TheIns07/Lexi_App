package apps.project.lexi_app.ui.notifications

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        println("LexiApp: NotificationsFragment")
        val root: View = binding.root

        binding.ivShareAchievements.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            val view = layoutInflater.inflate(R.layout.dialog_share, null)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
        }

        binding.ivShareProgress.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            val view = layoutInflater.inflate(R.layout.dialog_share, null)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}