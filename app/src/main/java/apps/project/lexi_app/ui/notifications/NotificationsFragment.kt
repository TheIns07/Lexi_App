package apps.project.lexi_app.ui.notifications

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import apps.project.lexi_app.MainActivity
import apps.project.lexi_app.databinding.FragmentNotificationsBinding
import apps.project.lexi_app.ui.home.HomeFragment
import apps.project.lexi_app.ui.logins.iniciosesion
import com.google.firebase.auth.FirebaseAuth
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList

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
        val root: View = binding.root

        if(iniciosesion.user.displayName != null){
            binding.tvUserName.text = iniciosesion.user.displayName
        }else{
            binding.tvUserName.text = iniciosesion.user.email
        }



        binding.ivShareAchievements.setOnClickListener{
            share()
        }

        binding.ivShareProgress.setOnClickListener {
            share()
        }
        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.tvCloseSession.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            HomeFragment.languages = ArrayList()
            HomeFragment.first=true
            val intent: Intent = Intent(context, iniciosesion::class.java)
            startActivity(intent)

        }


        return root
    }


    fun share(){
        val now = Date()
        DateFormat.format("yyyy-mm-dd_hh:mm:ss", now)


        val path  = ContextCompat.getExternalFilesDirs(requireContext(),null)[0].absolutePath + "/"+ now+".jpg"
        var bitmap = Bitmap.createBitmap(binding.viewPerfil.width, binding.viewPerfil.height, Bitmap.Config.ARGB_8888)
        var canvas = Canvas(bitmap)
        binding.viewPerfil.draw(canvas)
        val imageFile = File(path)
        val outputStream = FileOutputStream(imageFile)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.flush()
        outputStream.close()

        val Uri = FileProvider.getUriForFile(binding.viewPerfil.context, "apps.project.lexi_app", imageFile)

        val intent =  Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "Este es tu perfil \n Ingresa tus comentarios")
        intent.putExtra(Intent.EXTRA_STREAM, Uri)
        intent.type = "text/plain"
        startActivity(intent)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}