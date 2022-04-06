package apps.project.lexi_app.ui.courses

import apps.project.lexi_app.R

class CourseProvider {

    companion object{
        val courseList = listOf<Course>(
            Course(R.drawable.ic_launcher_background, "Nivel 1 basico", 70),
            Course(R.drawable.ic_launcher_background, "Nivel 2 frases", 60),
            Course(R.drawable.ic_launcher_background, "Nivel 3 ocupacion", 80),
            Course(R.drawable.ic_launcher_background, "Nivel 4 viajes", 10),
            Course(R.drawable.ic_launcher_background, "Nivel 4 viajes", 10),
            Course(R.drawable.ic_launcher_background, "Nivel 4 viajes", 10),
        )
    }

}