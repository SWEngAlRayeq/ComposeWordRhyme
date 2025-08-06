package app.word_rhyme.data.remote

import app.word_rhyme.data.model.RhymeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RhymeApi {

    @GET("words")
    suspend fun getRhymes(@Query("rel_rhy") word: String): List<RhymeDto>

}