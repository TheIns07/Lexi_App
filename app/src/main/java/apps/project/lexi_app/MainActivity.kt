package apps.project.lexi_app

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import apps.project.lexi_app.databinding.ActivityMainBinding
import apps.project.lexi_app.databinding.IniciosesionBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var binding_: IniciosesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000);
        setTheme(R.style.SplashTheme)
        setTheme(R.style.Theme_Lexi_App)
        super.onCreate(savedInstanceState)

        binding_ = IniciosesionBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.myCoursesFragment, R.id.navigation_notifications
            )
        )
        //etupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}