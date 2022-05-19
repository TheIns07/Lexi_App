package apps.project.lexi_app.ui.courses

import apps.project.lexi_app.R

class CourseProvider {
/*
            Theme(R.drawable.th_negocios,"Negocios","negocios"),
            Theme(R.drawable.th_peliculas,"Películas/Series","peliculas"),
            Theme(R.drawable.th_deportes,"Deportes","deportes"),
            Theme(R.drawable.th_musica,"Música","musica"),
            Theme(R.drawable.th_gastronomia,"Frases","frases"),
            Theme(R.drawable.th_historia,"Historia","historia"),
            Theme(R.drawable.th_moda,"Moda","moda"),
            Theme(R.drawable.th_tadiciones,"Tradiciones","tradiciones")
 */
    companion object{
        val courseList = listOf<Course>(
            Course(R.drawable.th_negocios, "Nivel 1: Negocios", 20,"negocios"),
            Course(R.drawable.th_peliculas, "Nivel 6: Peliculas", 10,"peliculas"),
            Course(R.drawable.th_deportes, "Nivel 1: Deportes", 90,"deportes"),
            Course(R.drawable.th_musica, "Nivel 5: Musica", 25,"musica"),
            Course(R.drawable.th_gastronomia, "Nivel 2: Frases", 65,"frases"),
            Course(R.drawable.th_historia, "Nivel 3:  Historia", 80,"historia"),
            Course(R.drawable.th_moda, "Nivel 4: Moda", 10,"moda"),
            Course(R.drawable.th_tadiciones, "Nivel 4: Tradiciones", 50,"tradiciones")


        )
    }


}