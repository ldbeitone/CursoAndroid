package com.beitone.android.lalista

class RepositorioPeliculas {
    companion object {
        private val peliculas = arrayOf(
            Pelicula(
                id = 1,
                titulo = "The Matrix",
                fecha = "1999",
                imagen = R.drawable.the_matrix
            ),
            Pelicula(
                id = 2,
                titulo = "The Matrix Reloaded",
                fecha = "2003",
                imagen = R.drawable.the_matrix_reloaded
            ),
            Pelicula(
                id = 3,
                titulo = "The Matrix Revolutions",
                fecha = "2003",
                imagen = R.drawable.the_matrix_revolutions
            ),
            Pelicula(
                id = 4,
                titulo = "The Matrix Resurrections",
                fecha = "2021",
                imagen = R.drawable.the_matrix_resurrections
            ),
            Pelicula(
                id = 5,
                titulo = "Star Wars: Episode IV - A New Hope",
                fecha = "1977",
                imagen = R.drawable.star_wars_episode_4
            ),
            Pelicula(
                id = 6,
                titulo = "Star Wars: Episode V - The Empire Strikes Back",
                fecha = "1980",
                imagen = R.drawable.star_wars_episode_5
            ),
            Pelicula(
                id = 7,
                titulo = "Star Wars: Episode VI - Return of the Jedi",
                fecha = "1983",
                imagen = R.drawable.star_wars_episode_6
            ),
            Pelicula(
                id = 8,
                titulo = "Star Wars: Episode I - The Phantom Menace",
                fecha = "1999",
                imagen = R.drawable.star_wars_episode_1
            ),
            Pelicula(
                id = 9,
                titulo = "Star Wars: Episode II - Attack of the Clones",
                fecha = "2002",
                imagen = R.drawable.star_wars_episode_2
            ),
            Pelicula(
                id = 10,
                titulo = "Star Wars: Episode III - Revenge of the Sith",
                fecha = "2005",
                imagen = R.drawable.star_wars_episode_3
            ),
            Pelicula(
                id = 11,
                titulo = "Star Wars: Episode VII - The Force Awakens",
                fecha = "2015",
                imagen = R.drawable.star_wars_episode_7
            ),
            Pelicula(
                id = 12,
                titulo = "Star Wars: Episode VIII - The Last Jedi",
                fecha = "2017",
                imagen = R.drawable.star_wars_episode_8
            ),
            Pelicula(
                id = 13,
                titulo = "Star Wars: Episode IX - The Rise of Skywalker",
                fecha = "2019",
                imagen = R.drawable.star_wars_episode_9
            )
        )
    }

    fun obtenerPeliculas(): Array<Pelicula> {
        peliculas.shuffle() // mezcla el array en el mismo lugar
        return peliculas
    }

    fun obtenerPelicula(idPelicula: Int): Pelicula? {
        for (pelicula in peliculas) {
            if (pelicula.id == idPelicula) {
                return pelicula
            }
        }
        return null
    }
}