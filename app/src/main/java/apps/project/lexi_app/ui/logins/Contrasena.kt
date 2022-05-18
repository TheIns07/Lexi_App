package apps.project.lexi_app.ui.logins

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import apps.project.lexi_app.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Contrasena: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contrasena)
        auth = Firebase.auth

        val btn_restablecer: Button = findViewById(R.id.reestablicer)

        btn_restablecer.setOnClickListener{
            val et_correo: EditText = findViewById(R.id.editTextTextEmailAddress4)
            var correo: String = et_correo.text.toString()

            if (!correo.isNullOrBlank()){
                auth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener{ task ->

                        if (task.isSuccessful){
                            Toast.makeText(this, "Se envio un mensaje a $correo",
                                Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Error al enviar correo",
                                Toast.LENGTH_SHORT).show()
                        }

                    }
            }else{
                Toast.makeText(this, "Ingresar correo", Toast.LENGTH_SHORT).show()
            }

        }

    }
}