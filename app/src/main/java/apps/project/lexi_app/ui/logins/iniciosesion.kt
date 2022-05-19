package apps.project.lexi_app.ui.logins

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import apps.project.lexi_app.MainActivity
import apps.project.lexi_app.R
import apps.project.lexi_app.ui.home.HomeFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class iniciosesion : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciosesion)
        auth = Firebase.auth

        val btn_registrarse: Button = findViewById(R.id.crear_cuenta)
        val btn_contra: Button = findViewById(R.id.password_forget)
        val btn_ingresar: Button = findViewById(R.id.inicio_sesion)

        btn_registrarse.setOnClickListener{
            val intent: Intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
        btn_ingresar.setOnClickListener{
            valida_ingreso()
        }
        btn_contra.setOnClickListener{
            val intent: Intent = Intent(this, Contrasena::class.java)
            startActivity(intent)
        }

    }

    private fun valida_ingreso() {
        val et_correo: EditText = findViewById(R.id.editTextTextEmailAddress)
        val et_contra: EditText = findViewById(R.id.editTextNumberPassword)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if (!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresa_firebase(correo, contra)
        }else{
            Toast.makeText(this, "ingresar datos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ingresa_firebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser
                    HomeFragment.user = auth.currentUser?.displayName.toString()
                    HomeFragment.correo = auth.currentUser?.email.toString()
                    val intent: Intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }
}