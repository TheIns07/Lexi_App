package apps.project.lexi_app.ui.courses

import apps.project.lexi_app.R

class CourseProvider {

    companion object{
        val courseList = listOf<Course>(
            Course(R.drawable.th_deportes, "Nivel 1 basico", 70),
            Course(R.drawable.th_gastronomia, "Nivel 2 frases", 60),
            Course(R.drawable.th_historia, "Nivel 3 ocupacion", 80),
            Course(R.drawable.th_moda, "Nivel 4 viajes", 10),
            Course(R.drawable.th_musica, "Nivel 4 viajes", 10),
            Course(R.drawable.th_peliculas, "Nivel 4 viajes", 10),
        )
    }

}