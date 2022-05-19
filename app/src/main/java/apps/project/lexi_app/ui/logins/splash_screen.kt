package apps.project.lexi_app.ui.logins

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import apps.project.lexi_app.R

class splash_screen : AppCompatActivity(){

    val duracion: Long = 3000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        cambiarActiviti()

    }

    private fun cambiarActiviti() {
        Handler().postDelayed(Runnable {
            val intent = Intent(this, iniciosesion::class.java)
            startActivity(intent)
        }, duracion)
    }
}