package apps.project.lexi_app.ui.Activities.Topics
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import apps.project.lexi_app.R
import apps.project.lexi_app.databinding.BoxVoiceBinding
import apps.project.lexi_app.databinding.CompleteTextBinding
import apps.project.lexi_app.ui.Activities.Fill.Fill
import apps.project.lexi_app.ui.Activities.Fill.FillAdapter
import apps.project.lexi_app.ui.Activities.Fill.FillFragment
import apps.project.lexi_app.ui.Activities.Fill.OnFillListener
import apps.project.lexi_app.ui.notifications.NotificationsFragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


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
        bindAdapter(binding)
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



    fun bindAdapter(binding: BoxVoiceBinding){
        val db = Firebase.firestore
        var action_box_voice: String
        var instruction_voice: String

        db.collection("dummy_data/dummy_data/box_data").document("96aPmuIpqXy1FwdIG8Ht")
            .get()
            .addOnSuccessListener { document ->
                if(document != null){
                    action_box_voice = document.get("activity_box").toString()
                    instruction_voice = document.get("instruction_voice").toString()

                    binding.actionBoxVoice.setText(action_box_voice)
                    binding.instructionVoice.setText(instruction_voice)

                    binding.buttonGridConfirm.setOnClickListener {
                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment_activity_main, NotificationsFragment())
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