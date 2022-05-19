package apps.project.lexi_app.ui.courses

import apps.project.lexi_app.R

class CourseProvider {

    companion object{
        val courseList = listOf<Course>(
            Course(R.drawable.th_deportes, "Nivel 1: Deportes", 70),
            Course(R.drawable.th_gastronomia, "Nivel 2: Frases", 60),
            Course(R.drawable.th_historia, "Nivel 3:  Ocupacion", 80),
            Course(R.drawable.th_moda, "Nivel 4: Viajes", 10),
            Course(R.drawable.th_musica, "Nivel 5: Musica", 10),
            Course(R.drawable.th_peliculas, "Nivel 6: Peliculas", 10),
        )
    }


}