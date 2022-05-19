package apps.project.lexi_app.ui.logins


import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import apps.project.lexi_app.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth


class Registro: AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_aplicacion)

        auth = Firebase.auth


        val btn_registrar: TextView = findViewById(R.id.button_grid_confirm)

        btn_registrar.setOnClickListener{
            validar_registro()
        }

    }

    private fun validar_registro() {
        val et_nombre: EditText = findViewById(R.id.editTextTextEmailAddress2)
        val et_correo: EditText = findViewById(R.id.editTextTextEmailAddress3)
        val et_contra1: EditText = findViewById(R.id.editTextTextPassword)
        val et_contra2: EditText = findViewById(R.id.editTextTextPassword2)

        var nombre: String = et_nombre.text.toString()
        var correo: String = et_correo.text.toString()
        var contra1: String = et_contra1.text.toString()
        var contra2: String = et_contra2.text.toString()

        if (!nombre.isNullOrBlank() &&!contra1.isNullOrBlank() && !contra1.isNullOrBlank() && !contra2.isNullOrBlank()){
            if (contra1 == contra2){
                registra_firebase(correo, contra1)
            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Ingresa los datos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun registra_firebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                   // updateUI(null)
                }
            }
    }
}